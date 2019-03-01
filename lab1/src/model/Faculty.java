package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Faculty {

    private String name;
    private String teacher;
    private Date dateOfStart;
    private Date dateOfEnd;
    private List<Student> listOfStudent;
    private double averageMarks;

    public Faculty(String name, String teacher, Date dateOfStart,
                   Date dateOfEnd, List listOfStudent) {
        this.name = name;
        this.teacher = teacher;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
        this.listOfStudent = listOfStudent;
        this.averageMarks = this.listOfStudent
                .stream()
                .mapToInt(e -> e.getMark())
                .average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    @Override
    public String toString() {
        StringBuilder students = new StringBuilder();
        listOfStudent.stream().forEach(e -> students.append(e));
        return "Faculty name: " + name +
                "\nTeacher name: " + teacher +
                "\nDate of start: " + dateOfStart +
                "\nDate of end: " + dateOfEnd + "\n" +
                "Students: " + students
                + "\nAverage marks: " + averageMarks + "\n";
    }
}
