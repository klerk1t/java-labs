package view;

import model.entity.Teacher;
import model.enums.Department;
import model.enums.Subjects;

import java.util.Arrays;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSubject() {
        printMessage(
                Arrays.toString(
                        Arrays.stream(Subjects.values())
                                .map(Subjects::toString)
                                .toArray())
        );
    }

    public void printDepartments() {
        printMessage(
                Arrays.toString(
                        Arrays.stream(Department.values())
                                .map(Department::toString)
                                .toArray())
        );
    }

    public void tablePrint(Teacher[] teachers) {
        if(teachers == null||teachers.length == 0) {
            printMessage(ViewConstants.EMPTY_LIST);
        } else {
            String[][] table = new String[teachers.length][];
            for (int i = 0; i < teachers.length; i++) {
                table[i] = teachers[i].toString().split("\n");
            }

            for (int i = 0; i < table[0].length; i++) {
                for (String[] strings : table) {
                    System.out.printf("%-40s", strings[i]);
                }
                System.out.println("\n");
            }
        }
    }

}
