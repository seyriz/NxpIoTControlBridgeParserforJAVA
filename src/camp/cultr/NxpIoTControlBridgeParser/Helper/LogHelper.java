package camp.cultr.NxpIoTControlBridgeParser.Helper;

public class LogHelper {
    public static String byteArrayToHexString(byte[] arr) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(byte b : arr) {
            builder.append(String.format("0x%02X, ", b));
        }
        builder.delete(builder.lastIndexOf(","),  builder.lastIndexOf(",")+1);
        builder.append("]");
        return builder.toString();
    }
}
