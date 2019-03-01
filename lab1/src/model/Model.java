package model;

import java.util.List;

public class Model {

    private DBExample dbExample;
    private List<Faculty> facultyList;

    public Model() {
        dbExample = new DBExample();
        facultyList = dbExample.createFacultyList();
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }
}
