package com.bohdan.model.entity.enums;

import com.bohdan.model.entity.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalDouble;

public enum Subject {

    MATH, OOP, PHYSICS;

    private HashMap<Student, Integer> hashMap;

    Subject() {
        hashMap = new HashMap<>();
    }

    public static OptionalDouble getAverageMarks(Student student) {
        return Arrays.stream(Subject.values())
                .mapToDouble(e -> e.getMark(student))
                .average();
    }

    public int getMark(Student student) {
        return hashMap.get(student);
    }

    public HashMap<Student, Integer> getHashMap() {
        return hashMap;
    }


    public void setStudent(Student student, Integer mark) {
        hashMap.put(student, mark);
    }

}
