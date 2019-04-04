package com.bohdan.model.db;

import com.bohdan.model.entity.Student;
import com.bohdan.model.entity.enums.Subject;

import java.util.LinkedList;
import java.util.List;

public class DBExample {

    private List<Student> studentList;

    public DBExample() {
        studentList = initList();
    }

    private List<Student> initList() {
        List<Student> list = new LinkedList<>();

        String name = "Student";

        Student student;

        for(int i = 0; i < 10; i++) {
            String studentName = name + i;
            student = new Student(studentName);
            Subject.MATH.setStudent(student, (int)(Math.random() * 4) + 2);
            Subject.OOP.setStudent(student, (int)(Math.random() * 4) + 2);
            Subject.PHYSICS.setStudent(student, (int)(Math.random() * 4) + 2);
            list.add(student);
        }

        return list;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
