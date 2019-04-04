package com.bohdan.controller;

import com.bohdan.model.Model;
import com.bohdan.model.SearchStudentByAverageMarks;
import com.bohdan.model.entity.Student;
import com.bohdan.view.View;
import com.bohdan.view.ViewConstants;

import java.util.List;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        view.print(ViewConstants.ALL_STUDENTS);
        view.printStudentList(model.getList());
        List<Student> list  = new SearchStudentByAverageMarks(model.getHashMap()).search();
        view.print(ViewConstants.STUDENTS);
        view.printStudentList(list);
    }

}
