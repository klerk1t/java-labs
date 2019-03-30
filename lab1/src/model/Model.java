package model;

import model.db.DBExample;
import model.entity.Teacher;
import model.filework.SerializationData;

public class Model {

    private Teacher[] teachers;
    private SerializationData serializationData;

    public Model() {
        DBExample dbExample = new DBExample(20);
        teachers = dbExample.getTeachers();
        serializationData = new SerializationData();
    }



    public void loadFromDB() {
        loadFromDB(10);
    }

    public void loadFromDB(int i) {
        DBExample dbExample = new DBExample(i);
        teachers = dbExample.getTeachers();
    }

    public void loadFromFile() {
        teachers = serializationData.getTeachersR();
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }
}
