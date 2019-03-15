package model.enums;

public enum Department {

    ASOIU("asoiu"), AUTS("auts"), OT("ot"), TC("tc");

    private String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
