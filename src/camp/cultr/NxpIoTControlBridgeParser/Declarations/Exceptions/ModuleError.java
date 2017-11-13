package camp.cultr.NxpIoTControlBridgeParser.Declarations.Exceptions;

public class ModuleError extends Throwable {
    private int statusCode;
    private String statusMessage;

    private ModuleError(String msg) {
        super(msg);
    }

    public static ModuleError Builder(int statusCode, String statusMessage) {
        String msg;
        switch (statusCode) {
            case 1:
                msg = "Incorrect Parameters";
                break;
            case 2:
                msg = "Unhandled Command";
                break;
            case 3:
                msg = "Command Failed";
                break;
            case 4:
                msg = "Module Busy";
                break;
            case 5:
                msg = "Stack already started";
                break;
            default:
                msg = "Unknown status code(" + statusCode + ")";
                break;
        }
        if(statusMessage != null && !statusMessage.isEmpty()) {
            msg += "::" + statusMessage;
        }
        return new ModuleError(msg);
    }
}
