package com.bohdan.model;

import com.bohdan.model.db.DBExample;
import com.bohdan.model.entity.Student;
import com.bohdan.model.entity.enums.Subject;

import java.util.HashMap;
import java.util.List;

public class Model {

    private HashMap<Student, Double> hashMap;
    private List<Student> list;

    public Model() {
        hashMap = new HashMap<>();
        list = new DBExample().getStudentList();
        for(Student x : list) {
            double averageMarks = Subject.getAverageMarks(x).getAsDouble();
            hashMap.put(x, averageMarks);
            x.setAverageMarks(averageMarks);
        }
    }

    public HashMap<Student, Double> getHashMap() {
        return hashMap;
    }

    public List<Student> getList() {
        return list;
    }
}
