package controller.util;

import controller.operations.Operation;
import model.enums.Department;
import model.enums.Subjects;
import view.Util;
import view.View;
import view.ViewConstants;

import java.util.Arrays;
import java.util.Scanner;

public class Validator {

    private Scanner scanner;
    private View view;

    public Validator(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public Operation checkOfValidValue() throws WrongInputDataException {
        String string;
        while (!(scanner.hasNextLine() && Arrays.stream(ValidInput.values())
                .map(ValidInput::getName)
                .anyMatch((string = scanner.nextLine())::equals))
        ) {
            throw new WrongInputDataException(ViewConstants.WRONG_INPUT);
        }

        String temp = string;

        return Arrays.stream(ValidInput.values())
                .filter(e -> e.getName().equals(temp))
                .findFirst()
                .get()
                .getOperation();
    }

    private String verifyInput(Enum<?>[] enums) throws WrongInputDataException {
        String input = "";
        Util util = () -> {};
        if(enums instanceof Department[]) {
            input = ViewConstants.INPUT_DEPARTMENT;
            util = () -> view.printDepartments();
        }
        if(enums instanceof Subjects[]) {
            input = ViewConstants.INPUT_SUBJECT;
            util = () -> view.printSubject();
        }
        String str;

        view.printMessage(input);
        util.print();

        while (!(scanner.hasNextLine() && Arrays.stream(enums)
                .map(Enum::toString)
                .anyMatch((str = scanner.nextLine())::equals))
        ) {
            throw new WrongInputDataException(ViewConstants.WRONG_INPUT);
        }
        return str;
    }

    String input(Enum<?>[] enums) {
        String string;
        while(true) {
            try {
                string = verifyInput(enums);
                break;
            } catch (WrongInputDataException e) {
                e.printStackTrace();
            }
        }
        return string;
    }
}
