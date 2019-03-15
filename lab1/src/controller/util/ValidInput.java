package controller.util;

public enum ValidInput {

    SHOW_ALL("1"), SHOW_BY_DEPARTMENT("2"), SHOW_BY_SUBJECT("3"),
    SHOW_BY_FEMALE_DOCENT("4"), EXIT("-q");

    private String name;

    ValidInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
