package controller.util;

import model.Model;
import model.SearchTeachersByParameters;
import model.enums.Department;
import model.enums.Subjects;
import view.View;

public class AllCommand {

    private View view;
    private Validator validator;
    private SearchTeachersByParameters searchTeachersByParameters;
    private Model model;

    public AllCommand(Model model, Validator validator, View view) {
        this.model = model;
        this.validator = validator;
        this.view = view;
        searchTeachersByParameters = new SearchTeachersByParameters();
    }

    boolean showAll() {
        view.tablePrint(model.getTeachers());
        return true;
    }

    boolean showByDepartment() {
        view.tablePrint(searchTeachersByParameters
                .getTeachersByDepartments(model.getTeachers(),
                        validator.verificationOfAdditionalParameters(Department.values())));
        return true;
    }

    boolean showBySubject() {
        view.tablePrint(searchTeachersByParameters
                .getTeachersBySubject(model.getTeachers(),
                        validator.verificationOfAdditionalParameters(Subjects.values())));
        return true;
    }

    boolean showFemaleDocent() {
        view.tablePrint(searchTeachersByParameters
                .getFemaleDocent(model.getTeachers()));
        return true;
    }

    boolean exit() {
        return false;
    }
}
