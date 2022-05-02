package ru.spb.stec.divanov.command;

public enum CommandName {

    START("/start"),
    GET("/get"),
    HELP("/help"),
    STOP("/stop");

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
