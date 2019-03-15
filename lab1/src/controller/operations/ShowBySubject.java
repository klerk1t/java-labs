package controller.operations;

import controller.util.AllCommand;

public class ShowBySubject implements Operation{

    private AllCommand allCommand;

    public ShowBySubject(AllCommand allCommand) {
        this.allCommand = allCommand;
    }

    @Override
    public boolean doOperation() {
        return allCommand.showBySubject();
    }
}
