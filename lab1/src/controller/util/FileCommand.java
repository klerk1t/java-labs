package controller.util;

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

    void loadFormFile() {
        model.loadTeachersfromFile();
    }

    void loadFromDB() {
        model.loadTeachersFromDB();
    }

    void writeToFile() {
        writeStringData.writeData(strData);
    }

    void doNothing() {}

    void setStrData(String strData) {
        this.strData = strData;
    }
}
