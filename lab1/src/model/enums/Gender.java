package model.enums;

public enum Gender {

    MALE("male"), FEMALE("female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
