package model.enums;

public enum Position {

    ASSISTANT("assistant"), LECTURER("lecturer"), SENIOR_LECTURER("senior lecturer"),
    DOCENT("docent"), PROFESSOR("professor");

    private String name;

    Position(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
