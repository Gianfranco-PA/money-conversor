package org.gianfranco.model.entity;

public class Conversion {

    private Currency base;
    private Currency target;
    private double rate = 0.;
    private double amount = 0.;
    private double result = 0.;

    public Conversion(Currency base, Currency target, double rate) {
        this.base = base;
        this.target = target;
        this.rate = rate;
    }

    public Conversion(Currency base, Currency target, double rate, double amount, double result) {
        this.base = base;
        this.target = target;
        this.rate = rate;
        this.amount = amount;
        this.result = result;
    }

    public Currency getBase() {
        return base;
    }

    public void setBase(Currency base) {
        this.base = base;
    }

    public Currency getTarget() {
        return target;
    }

    public void setTarget(Currency target) {
        this.target = target;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        this.result = amount * rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        this.result = amount * rate;
    }

    public double getResult() {
        return result;
    }
}
