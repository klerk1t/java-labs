package controller.util;

import controller.operations.Operation;
import model.enums.Department;
import model.enums.Subjects;
import view.Util;
import view.View;
import view.ViewConstants;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Validator {

    private Scanner scanner;
    private View view;

    public Validator(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    public Operation checkOfValidValue() throws WrongInputDataException {
        String str = verifyInput(ValidInput.values());

        checkException(str);

        return Arrays.stream(ValidInput.values())
                .filter(e -> e.toString().equals(str))
                .findFirst()
                .get()
                .getOperation();
    }

    String verificationOfAdditionalParameters(Enum<?>[] enums) {
        String string;
        while(true) {
            try {
                string = input(enums);
                break;
            } catch (WrongInputDataException e) {
                e.printStackTrace();
            }
        }
        return string;
    }

    private String input(Enum<?>[] enums) throws WrongInputDataException {
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

        view.printMessage(input);
        util.print();

        String str = verifyInput(enums);

        checkException(str);

        return str;
    }

    private void checkException(String str) throws WrongInputDataException {
        if(!("".equals(str))) {
            return;
        }
        throw new WrongInputDataException(ViewConstants.WRONG_INPUT);
    }

    private String verifyInput(Enum<?>[] enums) {
        return stream(enums)
                .map(Enum::toString)
                .filter(scanner.nextLine().toLowerCase()::equals)
                .findFirst()
                .orElse("");
    }
}
