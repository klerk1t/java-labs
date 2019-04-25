package controller.util;

import controller.exceptions.WrongInputDataException;
import view.ViewConstants;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class VerifyInput {

    private Scanner scanner;

    public VerifyInput(Scanner scanner) {
        this.scanner = scanner;
    }

    String verifyInput(Enum<?>[] enums) {
        return stream(enums)
                .map(Enum::toString)
                .filter(scanner.nextLine().toLowerCase()::equals)
                .findFirst()
                .orElse("");
    }

    void checkException(String str) throws WrongInputDataException {
        if(!("".equals(str))) {
            return;
        }
        throw new WrongInputDataException(ViewConstants.WRONG_INPUT);
    }

}
