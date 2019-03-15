package controller.util;

import model.enums.Department;
import model.enums.Subjects;
import view.View;
import view.ViewConstans;

import java.util.Arrays;
import java.util.Scanner;

public class Validator {

    private Scanner scanner;
    private View view;

    public Validator(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public ValidInput checkOfValidValue() {
        ValidInput validInput = null;
        String string;
        while (!(scanner.hasNext() && Arrays.stream(ValidInput.values())
                .map(ValidInput::getName)
                .anyMatch((string = scanner.next())::equals))
        ) {
            view.printMessage(ViewConstans.WRONG_INPUT);
        }

        for (ValidInput v : ValidInput.values()) {
            if (string.equals(v.getName())) {
                validInput = v;
                break;
            }
        }
        return validInput;
    }

    public String inputSubject() {
        view.printMessage(ViewConstans.INPUT_SUBJECT);
        view.printSubject();
        String subject;
        while (!(scanner.hasNext() && Arrays.stream(Subjects.values())
                .map(Subjects::getName)
                .anyMatch((subject = scanner.next())::equals))
        ) {
            view.printMessage(ViewConstans.INPUT_SUBJECT);
            view.printSubject();
        }
        return subject;
    }

    public String inputDepartment() {
        view.printMessage(ViewConstans.INPUT_DEPARTMENT);
        view.printDepartments();
        String department;
        while (!(scanner.hasNext() && Arrays.stream(Department.values())
                .map(Department::getName)
                .anyMatch((department = scanner.next())::equals))
        ) {
            view.printMessage(ViewConstans.INPUT_SUBJECT);
            view.printSubject();
        }
        return department;
    }
}
