package org.gianfranco.view;

import org.gianfranco.model.entity.Currency;

import java.util.List;

public class CurrencyChoice {

    public void body(List<Currency> currencies, Currency selectedCurrency) {
        System.out.println("==========================================");
        System.out.println("========== Elección de divisas ===========");
        System.out.println("==========================================");
        if (selectedCurrency != null) {
            System.out.println("-- Divisa origen:" + selectedCurrency + " --");
        } else {
            System.out.println("-- Divisa origen --");
        }
        int i = 1;
        for (Currency currency : currencies) {
            System.out.println((i++) + "). " + currency);
        }

        System.out.println(i + "). Retroceder");
    }
}
