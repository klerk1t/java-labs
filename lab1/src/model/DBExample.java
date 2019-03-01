package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DBExample {

    private Date dateOfStart = new Date();
    private Date dateOfEnd = new Date();

    private String[] lastNames = {"Smith", "Johnson", "Williams",
            "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore",
            "Taylor", "Anderson", "Thomas", "Jackson", "White" , "Harris"};

    private String[] firstNames = {"James", "John", "Mary", "Patricia",
            "Robert", "Michael", "Linda", "Barbara", "William", "David",
            "Elizabeth", "Jennifer", "Richard", "Charles", "Maria"};

    private String[] facultyNames = {"Chess", "Music", "Sports", "Math", "Physics",
            "Chemistry", "Programing", "Self development", "Theatrical", "Reading"};

    private String[] teachers = {"Jeff Scott", "Jason Morris", "Sarah Diaz", "Carol Watson", "Steven Nelson"};

    private List<Student> createListOfStudent() {
        List<Student> students = new LinkedList<>();
        Random random = new Random();

        for(int i = 0; i < 6; i++) {
            String firstName = firstNames[random.nextInt(15)];
            String lastName = lastNames[random.nextInt(15)];
            int mark = random.nextInt(5) + 1;
            Student student = new Student(firstName, lastName, mark);
            students.add(student);
        }
        return students;
    }

    public List<Faculty> createFacultyList() {
        List<Faculty> list = new LinkedList<>();

        for(int i = 0; i < facultyNames.length; i++) {
            String facultyName = facultyNames[i];
            String teacherName = teachers[(i + 1) % 5];
            Faculty faculty = new Faculty(facultyName, teacherName,
                    dateOfStart, dateOfEnd, createListOfStudent());
            list.add(faculty);
        }
        return list;
    }
}
