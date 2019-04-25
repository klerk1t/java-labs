package com.bohdan.model.entity;

import com.bohdan.model.entity.enums.Subject;

import java.util.Objects;

public class Student {

    private String surname;

    private Double averageMarks;

    public Student(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAverageMarks() {
        return averageMarks;
    }

    public void setAverageMarks(Double averageMarks) {
        this.averageMarks = averageMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return surname.equalsIgnoreCase(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }

    @Override
    public String toString() {
        return "Name: " + surname +
                " | average mark: " + averageMarks +
                " | math mark: " + Subject.MATH.getMark(this) +
                " | oop mark: " + Subject.OOP.getMark(this) +
                " | physics mark: " + Subject.PHYSICS.getMark(this);
    }
}
