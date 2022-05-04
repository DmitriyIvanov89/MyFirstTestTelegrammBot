package ru.spb.stec.divanov.model;

public class Message {

    private BaseCurrency baseCurrency;
    private Currency currency;
    private Long amount;

    public Message(BaseCurrency baseCurrency, Currency currency, Long amount) {
        this.baseCurrency = baseCurrency;
        this.currency = currency;
        this.amount = amount;
    }

    public BaseCurrency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(BaseCurrency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
