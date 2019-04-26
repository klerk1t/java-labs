package controller;

import controller.commands.AllCommand;
import controller.commands.FileCommand;
import controller.enums.ReadFromFile;
import controller.enums.ValidInputCommands;
import controller.exceptions.WrongInputDataException;
import controller.util.*;
import model.Model;
import model.filework.WriteStringData;
import org.apache.log4j.Logger;
import view.View;
import view.ViewConstants;

import java.util.Scanner;

public class Controller {

    private final static Logger LOGGER = Logger.getLogger(Controller.class);

    private View view;
    private Scanner scanner;
    private InputCommandsValidator inputCommandsValidator;
    private AllCommand allCommand;
    private VerifyInput verifyInput;
    private FileCommand fileCommand;
    private FileValidator fileValidator;
    private WriteStringData writeStringData;

    public Controller(Model model, View view) {
        this.view = view;
        scanner = new Scanner(System.in);
        verifyInput = new VerifyInput(scanner);
        inputCommandsValidator = new InputCommandsValidator(view, verifyInput);
        fileValidator = new FileValidator(verifyInput);
        writeStringData = new WriteStringData();
        fileCommand = new FileCommand(model, writeStringData);
        allCommand = new AllCommand(model, inputCommandsValidator, view, fileCommand, fileValidator);
        ValidInputCommands.setAllCommand(allCommand);
        ReadFromFile.setFileCommand(fileCommand);

    }

    public void execute() {
        LOGGER.info("Program start");
        boolean key = true;
        view.printMessage(ViewConstants.READ_FROM_FILE);
        while(true) {
            try {
                fileValidator.checkOfCorrectInputFileRead(ReadFromFile.values()).doOperation();
                break;
            } catch (WrongInputDataException e) {
                LOGGER.warn("Read data from file y/n", e);
                view.printMessage(ViewConstants.READ_FROM_FILE);
            }
        }
        while(key) {
            view.printMessage(ViewConstants.START_MESSAGE);
            while (true) {
                try {
                    key = inputCommandsValidator.checkOfValidValue().doOperation();
                    break;
                } catch (WrongInputDataException e) {
                    LOGGER.warn("Wrong choose in start menu" , e);
                    view.printMessage(ViewConstants.START_MESSAGE);
                }
            }
        }
    }

}
