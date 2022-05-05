package ru.spb.stec.divanov.model;

import java.util.List;

public class BaseRate {

    private BaseCurrency baseCurrency;
    private List<Rate> rates;

    public BaseRate(BaseCurrency baseCurrency, List<Rate> rates) {
        this.baseCurrency = baseCurrency;
        this.rates = rates;
    }

    public BaseCurrency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(BaseCurrency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public class Rate {

        private Currency currency;
        private double amount;

        public Rate(Currency currency, double amount) {
            this.currency = currency;
            this.amount = amount;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
