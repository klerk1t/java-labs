package controller.operations;

import controller.util.AllCommand;

public class ShowAll implements Operation{

    private AllCommand allCommand;

    public ShowAll(AllCommand allCommand) {
        this.allCommand = allCommand;
    }

    @Override
    public boolean doOperation() {
        return allCommand.showAll();
    }
}
