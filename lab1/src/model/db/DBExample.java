package model.db;

import model.entity.Teacher;
import model.enums.Department;
import model.enums.Gender;
import model.enums.Position;
import model.enums.Subjects;

import java.util.Random;

public class DBExample {

    private Teacher[] teachers;
    private Random random;
    private String[] names;
    private String[] surnames;
    private String[] patronymics;



    public DBExample(int i) {
        teachers = new Teacher[i];
        initParameters();
        createArrayOfTravels();
    }

    public DBExample() {
        this(10);
    }

    private void createArrayOfTravels() {
        for(int i = 0; i < teachers.length; i++) {
            String name = getRandomString(names);
            String surname = getRandomString(surnames);
            String patronymic = getRandomString(patronymics);
            Gender gender = getGender();
            Department department = getDepartment();
            Subjects[] subjects = getSubjects();
            Position position = getPosition();
            teachers[i] = new Teacher(name, surname, patronymic,
                    gender, department, subjects, position);
        }
    }

    private String getRandomString(String[] array) {
        return array[random.nextInt(array.length)];
    }

    private Department getDepartment() {
        return Department.values()
                [random.nextInt(Department.values().length)];
    }

    private Gender getGender() {
        return Gender.values()
                [random.nextInt(Gender.values().length)];
    }

    private Position getPosition() {
        return Position.values()
                [random.nextInt(Position.values().length)];
    }

    private Subjects[] getSubjects() {
        int j = 1 + (int)(Math.random() * 2);
        Subjects[] subjects = new Subjects[j];

        for(int i = 0; i < j; i++) {
            subjects[i] = checkOfUniqueSubject(subjects);
        }

        return subjects;
    }

    private Subjects checkOfUniqueSubject(Subjects[] subjects) {
        Subjects subject = null;
        boolean key = true;
        while(key) {
            key = false;
            subject = getSubject();
            if(subjects.length != 0) {
                for(int i = 0; subjects[i] != null; i++) {
                    if(subjects[i].equals(subject)) {
                        key = true;
                    }
                }
            }
        }
        return subject;
    }

    private Subjects getSubject() {
        return Subjects.values()
                [random.nextInt(Subjects.values().length)];
    }

    private void initParameters() {
        random = new Random();
        names = new String[]{"Name1", "Name2", "Name3", "Name4", "Name5", "Name6", "Name7"};
        surnames = new String[]{"Surname1", "Surname2", "Surname3", "Surname4", "Surname5", "Surname6",
                "Surname7"};
        patronymics = new String[]{"Patronymic1", "Patronymic2", "Patronymic3", "Patronymic4",
                "Patronymic5", "Patronymic6", "Patronymic7"};
    }

    public Teacher[] getTeachers() {
        return teachers;
    }
}
