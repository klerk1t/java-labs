package controller.operations;

import controller.util.AllCommand;

public class ShowByDepartment implements Operation{

    private AllCommand allCommand;

    public ShowByDepartment(AllCommand allCommand) {
        this.allCommand = allCommand;
    }

    @Override
    public boolean doOperation() {
        return allCommand.showByDepartment();
    }
}
