package model;

public class Student {

    private String firstName;
    private String lastName;
    private int mark;

    public Student(String firstName, String lastName, int mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "\n" + "Firstname: " + firstName +
                " Lastname: " + lastName +
                " Mark: " + mark;
    }
}
