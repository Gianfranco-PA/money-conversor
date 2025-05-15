package org.gianfranco.controller;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.entity.Currency;
import org.gianfranco.model.repository.CurrencyConverterRepository;
import org.gianfranco.model.repository.exchange.rate.ExchangeRateAPI;
import org.gianfranco.view.ConversionResult;
import org.gianfranco.view.Initial;
import org.gianfranco.view.entity.Shortcut;

import java.util.List;

public class ConsoleController implements Controller {

    @Override
    public void run() {

        CurrencyConverterRepository repository = new ExchangeRateAPI();
        List<Currency> currencies = repository.getCurrencyCodes();
        for (Currency currency : currencies) {
            Shortcut.LIST.forEach(shortcut -> shortcut.activation(currency));
        }
        List<Shortcut> activeShortcuts = Shortcut.LIST.stream().filter(Shortcut::isActive).toList();

        Initial initial = new Initial();
        int optionInt = 0;
        String option;
        initial.body(activeShortcuts);

        while (optionInt == 0) {
            option = initial.request();
            optionInt = checkFormat(option);
            if (optionInt == 0) System.out.println("La opcion no es valida");
        }

        if (optionInt > 0 && optionInt <= activeShortcuts.size()) {
            ConversionResult conversionResult = new ConversionResult();

            Shortcut selectedShortcut = activeShortcuts.get(optionInt-1);
            Conversion conversion = repository.getExchangeRate(selectedShortcut.getCurrencyBase(), selectedShortcut.getCurrencyTarget());

            System.out.println("Introduzca el valor a convertir: ");
            conversion.setAmount(Double.parseDouble(System.console().readLine()));

            conversionResult.body(conversion);
            conversionResult.request();
        }

        if (optionInt == activeShortcuts.size() + 2) System.exit(0);
    }

    public int checkFormat(String option){
        if (option.length() != 1 || !Character.isDigit(option.charAt(0))) return 0;
        int optionInt = Integer.parseInt(option);
        if (optionInt > 6 || optionInt < 1) return 0;
        return optionInt;
    }
}
