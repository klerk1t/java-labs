package controller.util;

import controller.operations.FileOperation;

public enum ReadFromFile {
    Y("y") {
        @Override
        FileOperation getFileOperation() {
            return fileCommand::loadFormFile;
        }
    },
    N("n") {
        @Override
        FileOperation getFileOperation() {
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

    abstract FileOperation getFileOperation();

    @Override
    public String toString() {
        return name;
    }

}
