package controller.enums;

import controller.operations.FileOperation;
import controller.commands.FileCommand;

public enum ReadFromFile {

    Y("y") {
        @Override
        public FileOperation getFileOperation() {
            return fileCommand::loadFormFile;
        }
    },
    N("n") {
        @Override
        public FileOperation getFileOperation() {
            return fileCommand::loadFromDB;
        }
    };

    private String name;

    private static FileCommand fileCommand;

    ReadFromFile(String name) {
        this.name = name;
    }

    public static void setFileCommand(FileCommand fileCommands) {
        fileCommand = fileCommands;
    }

    public abstract FileOperation getFileOperation();

    @Override
    public String toString() {
        return name;
    }

}
