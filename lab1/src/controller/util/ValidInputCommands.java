package controller.util;

import controller.operations.Operation;

public enum ValidInputCommands {

    SHOW_ALL("1") {
        @Override
        public Operation getOperation() {
            return allCommand::showAll;
        }
    }, SHOW_BY_DEPARTMENT("2") {
        @Override
        public Operation getOperation() {
            return allCommand::showByDepartment;
        }
    }, SHOW_BY_SUBJECT("3") {
        @Override
        public Operation getOperation() {
            return allCommand::showBySubject;
        }
    },
    SHOW_BY_FEMALE_DOCENT("4") {
        @Override
        public Operation getOperation() {
            return allCommand::showFemaleDocent;
        }
    }, EXIT("-q") {
        @Override
        public Operation getOperation() {
            return allCommand::exit;
        }
    };

    private static AllCommand allCommand;
    private String name;

    ValidInputCommands(String name) {
        this.name = name;
    }

    public static void setAllCommand(AllCommand allCommands) {
        allCommand = allCommands;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Operation getOperation();


}
