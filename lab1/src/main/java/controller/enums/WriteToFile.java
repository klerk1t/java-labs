package controller.enums;

import controller.operations.FileOperation;
import controller.commands.FileCommand;

public enum WriteToFile {

    Y("y") {
        @Override
        public FileOperation getFileOperation() {
            return fileCommand::writeToFile;
        }
    },
    N("n") {
        @Override
        public FileOperation getFileOperation() {
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

    public abstract FileOperation getFileOperation();

    @Override
    public String toString() {
        return name;
    }

}
