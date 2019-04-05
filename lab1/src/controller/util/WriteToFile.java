package controller.util;

import controller.operations.FileOperation;

public enum WriteToFile {

    Y("y") {
        @Override
        FileOperation getFileOperation() {
            return fileCommand::writeToFile;
        }
    },
    N("n") {
        @Override
        FileOperation getFileOperation() {
            return fileCommand::doNothing;
        }
    };

    private String name;

    private static FileCommand fileCommand;


    WriteToFile(String name) {
        this.name = name;
    }

    public static void setFileCommand(FileCommand fileCommands) {
        fileCommand = fileCommands;
    }

    @Override
    public String toString() {
     return name;
    }

    abstract FileOperation getFileOperation();

}
