package controller.commands;

import controller.enums.WriteToFile;
import controller.exceptions.WrongInputDataException;
import controller.util.FileValidator;
import controller.util.InputCommandsValidator;
import model.Model;
import model.service.SearchTeachersByParameters;
import model.entity.Teacher;
import model.enums.Department;
import model.enums.Subjects;
import view.View;
import view.ViewConstants;

import java.util.Arrays;

public class AllCommand {

    private View view;
    private InputCommandsValidator inputCommandsValidator;
    private SearchTeachersByParameters searchTeachersByParameters;
    private Model model;
    private FileCommand fileCommand;
    private FileValidator fileValidator;

    public AllCommand(Model model, InputCommandsValidator inputCommandsValidator,
                      View view, FileCommand fileCommand, FileValidator fileValidator) {
        this.model = model;
        this.inputCommandsValidator = inputCommandsValidator;
        this.view = view;
        this.fileCommand = fileCommand;
        this.fileValidator = fileValidator;
        searchTeachersByParameters = new SearchTeachersByParameters();
    }

    public boolean showAll() {
        Teacher[] teachers = model.getTeachers();
        checkIfWriteToFile(teachers);
        return true;
    }

    public boolean showByDepartment() {
        Teacher[] teachers = searchTeachersByParameters
                .getTeachersByDepartments(model.getTeachers(),
                        inputCommandsValidator.verificationOfAdditionalParameters(Department.values()));
        checkIfWriteToFile(teachers);
        return true;
    }

    public boolean showBySubject() {
        Teacher[] teachers = searchTeachersByParameters
                .getTeachersBySubject(model.getTeachers(),
                        inputCommandsValidator.verificationOfAdditionalParameters(Subjects.values()));
        checkIfWriteToFile(teachers);
        return true;
    }

    public boolean showFemaleDocent() {
        Teacher[] teachers = searchTeachersByParameters
                .getFemaleDocent(model.getTeachers());
        checkIfWriteToFile(teachers);
        return true;
    }

    public boolean exit() {
        return false;
    }

    private void checkIfWriteToFile(Teacher[] teachers) {
        fileCommand.setStrData(Arrays.toString(teachers));
        WriteToFile.setFileCommand(fileCommand);
        view.printMessage(ViewConstants.WRITE_TO_FILE);
        while (true) {
            try {
                fileValidator.checkOfCorrectInputFileWrite(WriteToFile.values()).doOperation();
                break;
            } catch (WrongInputDataException e) {
                view.printMessage(ViewConstants.WRITE_TO_FILE);
            }
        }

        view.tablePrint(teachers);
    }

}
