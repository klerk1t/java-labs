package controller.util;

import controller.operations.FileOperation;

import java.util.Arrays;

public class FileValidator {

    private VerifyInput verifyInput;

    public FileValidator(VerifyInput verifyInput) {
        this.verifyInput = verifyInput;
    }

    public FileOperation checkOfCorrectInputFileRead(Enum<?>[] enums) throws WrongInputDataException {
        String str = verifyInput.verifyInput(enums);

        verifyInput.checkException(str);

        return Arrays.stream(ReadFromFile.values())
                .filter(e -> e.toString().equals(str))
                .findFirst()
                .get()
                .getFileOperation();
    }

    FileOperation checkOfCorrectInputFileWrite(Enum<?>[] enums) throws WrongInputDataException {
        String str = verifyInput.verifyInput(enums);

        verifyInput.checkException(str);

        return Arrays.stream(WriteToFile.values())
                .filter(e -> e.toString().equals(str))
                .findFirst()
                .get()
                .getFileOperation();
    }

}

