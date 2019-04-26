package controller.util;

import controller.enums.ValidInputCommands;
import controller.exceptions.WrongInputDataException;
import controller.operations.Operation;
import model.enums.Department;
import model.enums.Subjects;
import org.apache.log4j.Logger;
import view.Util;
import view.View;
import view.ViewConstants;

import java.util.Arrays;

public class InputCommandsValidator {

    private final static Logger LOGGER = Logger.getLogger(InputCommandsValidator.class);

    private View view;
    private VerifyInput verifyInput;

    public InputCommandsValidator(View view, VerifyInput verifyInput) {
        this.view = view;
        this.verifyInput = verifyInput;
    }

    public Operation checkOfValidValue() throws WrongInputDataException {
        String str = verifyInput.verifyInput(ValidInputCommands.values());

        verifyInput.checkException(str);

        return Arrays.stream(ValidInputCommands.values())
                .filter(e -> e.toString().equals(str))
                .findFirst()
                .get()
                .getOperation();
    }

    public String verificationOfAdditionalParameters(Enum<?>[] enums) {
        String string;
        while(true) {
            try {
                string = input(enums);
                break;
            } catch (WrongInputDataException e) {
                LOGGER.info("Incorrect input name of department or subject", e);
                view.printMessage(ViewConstants.WRONG_INPUT);
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

        String str = verifyInput.verifyInput(enums);

        verifyInput.checkException(str);

        return str;
    }

}
