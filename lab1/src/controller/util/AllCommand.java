package controller.util;

import model.Model;
import model.SearchTeachersByParameters;
import model.entity.Teacher;
import view.View;

public class AllCommand {

    private Model model;
    private View view;
    private Validator validator;
    private SearchTeachersByParameters searchTeachersByParameters;
    private Teacher[] teachers;

    public AllCommand(Model model, Validator validator, View view) {
        this.model = model;
        this.validator = validator;
        this.view = view;
        searchTeachersByParameters = new SearchTeachersByParameters();
        teachers = this.model.getTeachers();
    }

    public boolean showAll() {
        view.tablePrint(teachers);
        return true;
    }

    public boolean showByDepartment() {
        view.tablePrint(searchTeachersByParameters
                .getTeachersByDepartments(teachers, validator.inputDepartment()));
        return true;
    }

    public boolean showBySubject() {
        view.tablePrint(searchTeachersByParameters
                .getTeachersBySubject(teachers, validator.inputSubject()));
        return true;
    }

    public boolean showFemaleDocent() {
        view.tablePrint(searchTeachersByParameters
                .getFemaleDocent(teachers));
        return true;
    }

    public boolean exit() {
        return false;
    }
}
