package controller.commands;

import model.Model;
import model.filework.WriteStringData;

public class FileCommand {

    private Model model;
    private WriteStringData writeStringData;
    private String strData;

    public FileCommand(Model model, WriteStringData writeStringData) {
        this.model = model;
        this.writeStringData = writeStringData;
    }

    public void loadFormFile() {
        model.loadTeachersfromFile();
    }

    public void loadFromDB() {
        model.loadTeachersFromDB();
    }

    public void writeToFile() {
        writeStringData.writeData(strData);
    }

    public void doNothing() {}

    void setStrData(String strData) {
        this.strData = strData;
    }
}
