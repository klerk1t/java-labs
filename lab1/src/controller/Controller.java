package controller;

import controller.util.AllCommand;
import controller.util.ValidInput;
import controller.util.Validator;
import controller.util.WrongInputDataException;
import model.Model;
import view.View;
import view.ViewConstants;

import java.util.Scanner;

public class Controller {

    private View view;
    private Scanner scanner;
    private Validator validator;
    private AllCommand allCommand;

    public Controller(Model model, View view) {
        this.view = view;
        scanner = new Scanner(System.in);
        validator = new Validator(scanner, view);
        allCommand = new AllCommand(model, validator, view);
        ValidInput.setAllCommand(allCommand);
    }

    public void execute() {
        boolean key = true;
        while(key) {
            view.printMessage(ViewConstants.START_MESSAGE);
            while (true) {
                try {
                    key = validator.checkOfValidValue().doOperation();
                    break;
                } catch (WrongInputDataException e) {
                    e.printStackTrace();
                    view.printMessage(ViewConstants.START_MESSAGE);
                }
            }
        }
    }

}
