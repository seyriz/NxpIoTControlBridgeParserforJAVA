package camp.cultr.NxpIoTControlBridgeParser;

import com.sun.istack.internal.NotNull;

import java.nio.ByteBuffer;

public class Composer {
    private static byte[] makeStuffedByte(byte aByte, boolean isSpecial, boolean isAscii) {
        byte[] ret;
        if(isAscii) {
            if(!isSpecial && aByte < 0x10) {
                // Escaping ascii character that it's not special char and value is under 0x10
                ret = new byte[]{0x02, (byte)(aByte^0x10)};
            }
            else {
                // Non escaping ascii character
                ret = new byte[]{aByte};
            }
        }
        else {
            if(!isSpecial && (int)aByte < 0x10) {
                // Escaping non ascii byte that it's not special char and value is under 0x10
                ret = new byte[]{0x02, (byte)(aByte^0x10)};
            }
            else {
                ret = new byte[]{aByte};
            }
        }
        return ret;
    }

    private static byte makeChecksum(int messageType, byte[] data) {
        // get Checksum from message type
        byte checkSum = (byte)((messageType >> 8) & 0xFF);
        checkSum ^= (byte)((messageType) & 0xFF);

        // get Checksum from data length
        checkSum ^= (byte)((data.length/2 >> 8) & 0xFF);
        checkSum ^= (byte)((data.length/2 >> 0) & 0xFF);

        // get Checksum from data
        boolean bIn = true;
        byte aByte = 0;
        for(byte elem : data) {
            if (bIn) {
                byte i = Byte.parseByte(new String(new byte[]{elem}), 16);
                aByte = (byte)((i << 4) & 0xFF);
                bIn = false;
            }
            else {
                byte i = Byte.parseByte(new String(new byte[]{elem}), 16);
                aByte |= (byte)((i >> 0) & 0xFF);
                bIn = true;
                checkSum ^= aByte;
            }
        }
        return checkSum;
    }

    /**
     * Make compressed data stream.
     * It's Byte stuffed.
     * @param data
     * @return
     */
    @NotNull
    private static byte[] byteCompressing(byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(data.length);
        boolean bIn = true;
        byte aByte = 0;

        for(byte elem : data) {
            if (bIn) {
                byte i = Byte.parseByte(new String(new byte[]{elem}), 16);
                aByte = (byte)((i << 4) & 0xFF);
                bIn = false;
            }
            else {
                byte i = Byte.parseByte(new String(new byte[]{elem}), 16);
                aByte |= (byte)((i >> 0) & 0xFF);
                buffer.put(makeStuffedByte(aByte, false, true));
                bIn = true;
            }
        }
        buffer.flip();
        return buffer.array();
    }

    @NotNull
    public static byte[] compose(int messageType, byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(data.length*2);
        // STX
        buffer.put(makeStuffedByte((byte)0x01, true, false));
        // Add message type to Packet.
        buffer.put(makeStuffedByte((byte)((messageType >> 8) & 0xFF), false, false));
        buffer.put(makeStuffedByte((byte)((messageType >> 0) & 0xFF), false, false));
        // Add data length to Packet. data is compressed that half sizing.
        buffer.put(makeStuffedByte((byte)(((data.length/2) >> 8) & 0xFF), false, false));
        buffer.put(makeStuffedByte((byte)(((data.length/2) >> 0) & 0xFF), false, false));
        // Add checksum to Packet.
        buffer.put(makeStuffedByte((byte)makeChecksum(messageType, data), false, false));
        // Add data to Packet.
        buffer.put(byteCompressing(data));
        // EOH
        buffer.put(makeStuffedByte((byte)0x03, true, false));

        // Compress array size and reset pointer to index 0.
        buffer.flip();
        return buffer.array();
    }
}
