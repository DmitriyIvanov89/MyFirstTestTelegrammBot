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

    @Override
    public String toString() {
        return "Test rate string";
    }

    public class Rate {

        private Currency Currency;
        private double amount;

        public Rate(Currency Currency, double amount) {
            this.Currency = Currency;
            this.amount = amount;
        }

        public Currency getCurrency() {
            return Currency;
        }

        public void setCurrency(Currency Currency) {
            this.Currency = Currency;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
