package model;

import model.db.DBExample;
import model.entity.Teacher;

public class Model {

    private Teacher[] teachers;

    public Model() {
        DBExample dbExample = new DBExample();
        teachers = dbExample.getTeachers();
    }

    public Teacher[] getTeachers() {
        return teachers;
    }
}
