package camp.cultr.NxpIoTControlBridgeParser.CommandObjects;

import java.lang.reflect.Field;

public abstract class BasePacketObject {
    private int messageType;
    private byte checkSum;
    private short dataLength;

    public abstract BasePacketObject makeInstanse(byte[] data);

    public BasePacketObject() {
    }

    public BasePacketObject(int messageType, byte checkSum, short dataLength) {
        this.messageType = messageType;
        this.checkSum = checkSum;
        this.dataLength = dataLength;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        builder.append(String.format("\t\"MessageName\": %s,", this.getClass().getSimpleName()));

        builder.append("\t\"Fields\": [\n");
        for(Field field: this.getClass().getFields()) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                builder.append(String.format("\t\t\"%s\": %s,", field.getName(), field.get(field)));
                field.setAccessible(isAccessible);
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        builder.append("\t]\n}");
        return builder.toString();
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public byte getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(byte checkSum) {
        this.checkSum = checkSum;
    }

    public short getDataLength() {
        return dataLength;
    }

    public void setDataLength(short dataLength) {
        this.dataLength = dataLength;
    }
}
