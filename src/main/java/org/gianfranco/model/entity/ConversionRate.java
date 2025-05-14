package org.gianfranco.model.entity;

public class ConversionRate {

    private Currency base;
    private Currency target;
    private double conversionRate;

    public ConversionRate(Currency base, Currency target, double conversionRate) {
        this.base = base;
        this.target = target;
        this.conversionRate = conversionRate;
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

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
