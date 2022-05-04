package ru.spb.stec.divanov.model;

public enum Currency {

    USD("USD"),
    EUR("EUR"),
    RUB("RUB");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
