package ru.spb.stec.divanov.command;

public enum CommandName {

    START("/start"),
    GET("/gettop10coinsrates"),
    HELP("/help"),
    STOP("/stop"),
    NO("nocommand");

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
