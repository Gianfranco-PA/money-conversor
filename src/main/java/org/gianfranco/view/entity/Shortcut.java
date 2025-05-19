package org.gianfranco.view.entity;

import org.gianfranco.model.entity.Currency;

import java.util.List;

public class Shortcut {

    public static final List<Shortcut> LIST = List.of(
            //PEN
            new Shortcut("USD", "PEN"),
            new Shortcut("PEN", "USD"),
            //ARS
            new Shortcut("USD", "ARS"),
            new Shortcut("ARS", "USD"),
            //COP
            new Shortcut("USD", "COP"),
            new Shortcut("COP", "USD"),
            //BRL
            new Shortcut("USD", "BRL"),
            new Shortcut("BRL", "USD")
    );

    public static void checkActive(Currency currency){
        Shortcut.LIST.forEach(shortcut -> shortcut.activation(currency));
    }

    public static List<Shortcut> getActiveShortcuts(){
        return Shortcut.LIST.stream().filter(Shortcut::isActive).toList();
    }

    private Currency currencyBase;
    private Currency currencyTarget;
    private boolean activeBase = false;
    private boolean activeTarget = false;

    private Shortcut(String currencyBase, String currencyTarget) {
        this.currencyBase = new Currency(currencyBase);
        this.currencyTarget = new Currency(currencyTarget);
    }

    public Currency getCurrencyBase() {
        return currencyBase;
    }

    public Currency getCurrencyTarget() {
        return currencyTarget;
    }

    public void activation(Currency currency){
        if(currencyBase.equals(currency)) {
            activeBase = true;
            currencyBase = currency;
        }
        if(currencyTarget.equals(currency)) {
            activeTarget = true;
            currencyTarget = currency;
        }
    }

    public boolean isActive() {
        return activeBase && activeTarget;
    }

    public void display(int index){
        System.out.println(index + "). Convertir de " + currencyBase + " a " + currencyTarget);
    }

}