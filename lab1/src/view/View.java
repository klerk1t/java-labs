package view;

import model.entity.Teacher;
import model.enums.Department;
import model.enums.Subjects;

import java.util.Arrays;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWrongInput(String message) {
        StringBuilder sb = new StringBuilder(ViewConstans.WRONG_INPUT)
                .append("\n")
                .append(message);
        System.out.println(sb);
    }

    public void printTeachers(Teacher[] teachers) {
        if(teachers.length == 0) {
            printMessage(ViewConstans.EMPTY_LIST);
        } else
        printMessage(Arrays.toString(teachers));
    }

    public void printSubject() {
        printMessage(Arrays.toString(Subjects.values()));
    }

    public void printDepartments() {
        printMessage(Arrays.toString(Department.values()));
    }

    public void tablePrint(Teacher[] teachers) {
        if(teachers.length == 0) {
            printMessage(ViewConstans.EMPTY_LIST);
        }
        String[][] table = new String[teachers.length][];
        for(int i = 0; i < teachers.length; i++) {
            table[i] = teachers[i].toString().split("\n");
        }

        for(int i = 0; i < table[0].length; i++) {
            for(int j = 0; j < table.length; j++) {
                System.out.printf("%-40s", table[j][i]);
            }
            System.out.println("\n");
        }
    }

}
