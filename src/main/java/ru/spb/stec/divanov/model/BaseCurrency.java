package ru.spb.stec.divanov.model;

public enum BaseCurrency {

    BTC("BTC"),
    ETH("ETH");

    private final String name;

    BaseCurrency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
