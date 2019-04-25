package model.enums;

public enum Subjects {

    MATH("math"), OOP("oop"), PHYSIC("physic"),
    COMPUTER_ARCHITECTURE("computer architecture");

    private String name;

    Subjects(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
