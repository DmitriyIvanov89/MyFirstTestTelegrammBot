package ru.spb.stec.divanov.command;

public enum CommandName {

    START("/start"),
    GET("/get"),
    HELP("/help"),
    STOP("/stop"),
    NO("nocommand"),
    GET_TOP_THREE_RATE("/getTop3Rate"),
    GET_TOP_BY_VOLUME("/getTopVolume"),
    GET_TOP_BY_MARKET_CUP("/getTopCup");


    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
