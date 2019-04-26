package controller.enums;

import controller.operations.FileOperation;
import controller.commands.FileCommand;
import org.apache.log4j.Logger;

public enum WriteToFile {

    Y("y") {
        @Override
        public FileOperation getFileOperation() {
            LOGGER.info("Selected write data to file");
            return fileCommand::writeToFile;
        }
    },
    N("n") {
        @Override
        public FileOperation getFileOperation() {
            LOGGER.info("Selected show data");
            return fileCommand::doNothing;
        }
    };

    private final static Logger LOGGER = Logger.getLogger(WriteToFile.class);

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
