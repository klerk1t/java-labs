package controller.enums;

import controller.operations.FileOperation;
import controller.commands.FileCommand;
import org.apache.log4j.Logger;

public enum ReadFromFile {

    Y("y") {
        @Override
        public FileOperation getFileOperation() {
            LOGGER.info("Selected read from file");
            return fileCommand::loadFormFile;
        }
    },
    N("n") {
        @Override
        public FileOperation getFileOperation() {
            LOGGER.info("Selected read data from DB");
            return fileCommand::loadFromDB;
        }
    };

    private final static Logger LOGGER = Logger.getLogger(ReadFromFile.class);

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
