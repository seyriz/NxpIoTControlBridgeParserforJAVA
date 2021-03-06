package camp.cultr.NxpIoTControlBridgeParser;

import camp.cultr.NxpIoTControlBridgeParser.CommandObjects.BasePacketObject;
import camp.cultr.NxpIoTControlBridgeParser.Declarations.Exceptions.ParsingError;
import camp.cultr.NxpIoTControlBridgeParser.Helper.LogHelper;

public class main {
    public static void main(String[] args) {
        byte[] data = new byte[]{0x01, (byte)0x80, 0x04, 0x00, 0x45, (byte)0xBD, 0x01, 0x01, 0x04, 0x03, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x07, 0x00, 0x08, 0x00, 0x10, 0x00, 0x11, 0x00, 0x12, 0x00, 0x13, 0x00, 0x15, 0x00, 0x16, 0x00, 0x17, 0x00, 0x19, 0x00, 0x1A, 0x00, 0x20, 0x00, 0x21, 0x00, 0x22, 0x00, 0x24, 0x00, 0x25, 0x00, 0x26, 0x00, 0x28, 0x00, 0x29, 0x00, 0x2A, 0x40, 0x00, 0x40, 0x01, 0x40, 0x02, 0x40, 0x03, 0x40, 0x04, 0x40, 0x06, 0x40, 0x0A, 0x40, 0x0B, 0x40, 0x0C, 0x03};
        System.out.println("DATA::"+LogHelper.byteArrayToHexString(data));
        try {
            BasePacketObject basePacketObject = Parser.parse(data);
            System.out.println("OBJ::"+basePacketObject.toString());
        }
        catch (ParsingError e) {
            e.printStackTrace();
        }
    }
}
