package controller.operations;

import controller.util.AllCommand;

public class Exit implements Operation{

    private AllCommand allCommand;

    public Exit(AllCommand allCommand) {
        this.allCommand = allCommand;
    }

    @Override
    public boolean doOperation() {
        return allCommand.exit();
    }
}
