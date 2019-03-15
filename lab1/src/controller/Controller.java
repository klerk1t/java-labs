package controller;

import controller.operations.*;
import controller.util.AllCommand;
import controller.util.ValidInput;
import controller.util.Validator;
import model.Model;
import view.View;
import view.ViewConstans;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private Scanner scanner;
    private Validator validator;
    private ValidInput validInput;
    private AllCommand allCommand;
    private Map<ValidInput, Operation> hashMap;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
        validator = new Validator(scanner, view);
        allCommand = new AllCommand(model, validator, view);
        initMap();
    }

    public void execute() {
        do {
            view.printMessage(ViewConstans.START_MESSAGE);
            validInput = validator.checkOfValidValue();
        } while(hashMap.get(validInput).doOperation());
    }

    private void initMap() {
        hashMap = new HashMap<>();
        hashMap.put(ValidInput.SHOW_ALL, new ShowAll(allCommand));
        hashMap.put(ValidInput.SHOW_BY_DEPARTMENT, new ShowByDepartment(allCommand));
        hashMap.put(ValidInput.SHOW_BY_SUBJECT, new ShowBySubject(allCommand));
        hashMap.put(ValidInput.SHOW_BY_FEMALE_DOCENT, new ShowFemaleDocent(allCommand));
        hashMap.put(ValidInput.EXIT, new Exit(allCommand));
    }
}
