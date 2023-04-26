package StudentPackage;

import java.io.*;

public class FileInputOutputInstance {
    private static FileInputOutputInstance instance = null;
    private Object[] datainstringform;

    public static FileInputOutputInstance getInstance(){
        if (instance == null)
            instance = new FileInputOutputInstance();
        return instance;
    }

    public Object[] getDataininstringform() {
        return datainstringform;
    }

    public void setDataininstringform(Object[] dataininstringform) {
        this.datainstringform = dataininstringform;
    }

    public byte[] serializeData() throws IOException{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteStream);
        out.writeObject(datainstringform);
        out.close();
        return byteStream.toByteArray();
    }
    public void deserialize(byte[] serializedData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(serializedData);
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        datainstringform = (Object[]) objectStream.readObject();
        objectStream.close();
    }
}
