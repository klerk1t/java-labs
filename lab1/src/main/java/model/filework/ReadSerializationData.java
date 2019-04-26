package model.filework;

import model.entity.Teacher;
import org.apache.log4j.Logger;

import java.io.*;

public class ReadSerializationData {

    private final static Logger LOGGER = Logger.getLogger(ReadSerializationData.class);

    private Teacher[] teachersWrite;
    private Teacher[] teachersRead;

    public void writeData() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/teachers"))) {
            oos.writeObject(teachersWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/files/teachers"))) {
            teachersRead = (Teacher[]) ois.readObject();
            LOGGER.info("Data successfully read from file");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.info("Impossible read data from file", e);
            e.printStackTrace();
        }
    }

    public Teacher[] getTeachersRead() {
        return teachersRead;
    }

    public void setTeachersWrite(Teacher[] teachersWrite) {
        this.teachersWrite = teachersWrite;
    }
}
