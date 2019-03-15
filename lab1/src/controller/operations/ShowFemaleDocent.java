package controller.operations;

import controller.util.AllCommand;

public class ShowFemaleDocent implements Operation{

    private AllCommand allCommand;

    public ShowFemaleDocent(AllCommand allCommand) {
        this.allCommand = allCommand;
    }

    @Override
    public boolean doOperation() {
        return allCommand.showFemaleDocent();
    }
}
