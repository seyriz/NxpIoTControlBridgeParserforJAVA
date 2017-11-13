package camp.cultr.NxpIoTControlBridgeParser;

import camp.cultr.NxpIoTControlBridgeParser.CommandObjects.BasePacketObject;
import camp.cultr.NxpIoTControlBridgeParser.Declarations.Exceptions.ParsingError;
import camp.cultr.NxpIoTControlBridgeParser.Helper.LogHelper;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Parser {
    private static byte getChecksum(int messageType, byte[] data) {
        // get Checksum from message type
        byte checkSum = (byte)((messageType >> 8) & 0xFF);
        checkSum ^= (byte)((messageType) & 0xFF);

        // get Checksum from data length
        checkSum ^= (byte)((data.length >> 8) & 0xFF);
        checkSum ^= (byte)((data.length >> 0) & 0xFF);

        // get Checksum from data
        for(byte elem : data) {
            checkSum ^= (byte)(elem & 0xFF);
        }
        return checkSum;
    }

    private static BasePacketObject detactPacketType(int messageType) {
        return null;
    }

    public static BasePacketObject parse(byte[] dataStream) throws ParsingError{
        BasePacketObject basePacketObject = null;
        byte checksum = 0;
        int messageType = 0;
        short dataLength = 0;
        ByteBuffer buffer = null;
        for (int i = 0; i < dataStream.length; i++) {
            if (i == 0) {
                if(dataStream[i] != 0x01){
                    throw new ParsingError("Start byte is not 0x01");
                }
            }
            else if (i == 1) {
                // messageType MSB
                messageType = (dataStream[i] << 8);
            }
            else if (i == 2) {
                messageType += (dataStream[i]);
                basePacketObject = detactPacketType(messageType);
            }
            else if (i == 3) {
                // dataLength MSB
                dataLength = (short)(dataStream[i] << 8);
            }
            else if (i == 4) {
                dataLength += (short)dataStream[i];
                buffer = ByteBuffer.allocate(dataLength);
                if(basePacketObject != null) {
                    basePacketObject.setDataLength(dataLength);
                }
            }
            else if (i == 5) {
                checksum = (byte)dataStream[i];
                if(basePacketObject != null) {
                    basePacketObject.setCheckSum(checksum);
                }
            }
            else if (i == (dataStream.length - 1)) {
                buffer.flip();
                byte[] data = buffer.array();
                System.out.println("sData::"+ LogHelper.byteArrayToHexString(data));
                if(dataLength != data.length) {
                    throw new ParsingError(String.format("Length mismatched expected(%d), got(%d)", dataLength, data.length));
                }
                byte aChecksum = getChecksum(messageType, data);
                System.out.printf("CheckSum(0x%02X) aChecksum(0x%02X)\n", checksum, aChecksum);
                if(checksum != aChecksum) {
                    throw new ParsingError(String.format("CheckSum mismatched expected(0x%02X), got(0x%02X)", (byte)checksum, (byte)aChecksum));
                }
//                basePacketObject.makeInstanse(data);
                return basePacketObject;
            }
            else {
                System.out.printf("Data putting::0x%02X\n", dataStream[i]);
                buffer.put(dataStream[i]);
            }
        }
        throw new ParsingError("Endless message. check your module or cabling");
    }

    public static byte[] uncompressing(byte[] compressed) {
        ByteBuffer buffer = ByteBuffer.allocate(compressed.length);

        for(byte elem : compressed) {
            buffer.put((byte)((elem & 0xF0) >> 4));
            buffer.put((byte)((elem & 0x0F)));
        }
        buffer.flip();
        return buffer.array();
    }
}
