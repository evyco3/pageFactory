package com.evy.enums;

public enum SubSideBarType {
    ADD_TASK("Add Task"),
    TICKETS("Tickets"),
    DISCUSSIONS("Discussions");

    private final String name;

    private SubSideBarType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
