package model;

import model.db.DBExample;
import model.entity.Teacher;
import model.filework.ReadSerializationData;

public class Model {

    private Teacher[] teachers;
    private ReadSerializationData readSerializationData;
    private DBExample dbExample;

    public Model() {
        dbExample = new DBExample(20);
        readSerializationData = new ReadSerializationData();
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void loadTeachersfromFile() {
        readSerializationData.readData();
        teachers =  readSerializationData.getTeachersRead();
    }

    public void loadTeachersFromDB() {
        teachers = dbExample.getTeachers();
    }
}
