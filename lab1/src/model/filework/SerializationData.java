package model.filework;

import model.entity.Teacher;

import java.io.*;

public class SerializationData {

    private Teacher[] teachersW;
    private Teacher[] teachersR;

    public void writeData() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res/teachers"))) {
            oos.writeObject(teachersW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("res/teachers"))) {
            teachersR = (Teacher[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Teacher[] getTeachersR() {
        return teachersR;
    }

    public void setTeachersW(Teacher[] teachersW) {
        this.teachersW = teachersW;
    }
}
