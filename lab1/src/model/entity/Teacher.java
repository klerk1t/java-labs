package model.entity;

import model.enums.Department;
import model.enums.Gender;
import model.enums.Position;
import model.enums.Subjects;

public class Teacher {

    private String name;
    private String surname;
    private String patronymic;
    private Gender gender;
    private Department department;
    private Subjects[] subjects;
    private Position position;

    public Teacher(String name, String surname, String patronymic, Gender gender,
                   Department department, Subjects[] subjects, Position position) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.department = department;
        this.subjects = subjects;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Subjects[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects[] subjects) {
        this.subjects = subjects;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Name: ")
                .append(name).append("\n")
                .append("Surname: ").append(surname).append("\n")
                .append("Patronymic: ").append(patronymic).append("\n")
                .append("Gender: ").append(gender.getName()).append("\n")
                .append("Department: ").append(department.getName()).append("\n")
                .append("Subjects: ").append(arrayOfSubjectsToString()).append("\n")
                .append("Position: ").append(position.getName()).append("\n");
        return new String(sb);
    }

    private String arrayOfSubjectsToString() {
        StringBuilder sb = new StringBuilder();
        for(Subjects subjects : subjects) {
            sb.append(subjects.getName())
                    .append(" ");
        }
        return new String(sb).trim();
    }
}
