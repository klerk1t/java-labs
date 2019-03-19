package controller.util;

import controller.operations.Operation;

public enum ValidInput {

    SHOW_ALL("1") {
        @Override
        public Operation setOperation() {
            return allCommand::showAll;
        }
    }, SHOW_BY_DEPARTMENT("2") {
        @Override
        public Operation setOperation() {
            return allCommand::showByDepartment;
        }
    }, SHOW_BY_SUBJECT("3") {
        @Override
        public Operation setOperation() {
            return allCommand::showBySubject;
        }
    },
    SHOW_BY_FEMALE_DOCENT("4") {
        @Override
        public Operation setOperation() {
            return allCommand::showFemaleDocent;
        }
    }, EXIT("-q") {
        @Override
        public Operation setOperation() {
            return allCommand::exit;
        }
    };

    private static AllCommand allCommand;
    private String name;

    ValidInput(String name) {
        this.name = name;
    }

    public static void setAllCommand(AllCommand allCommands) {
        allCommand = allCommands;
    }

    public String getName() {
        return name;
    }

    public abstract Operation setOperation();


}
