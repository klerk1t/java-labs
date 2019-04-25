package model.filework;

import model.entity.Teacher;

import java.io.*;

public class ReadSerializationData {

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
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/teachers"))) {
            teachersRead = (Teacher[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
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
