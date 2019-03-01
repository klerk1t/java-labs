package controller;

import model.Model;
import view.View;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        model.getFacultyList()
                .stream()
                .forEach(System.out::println);
    }

}
