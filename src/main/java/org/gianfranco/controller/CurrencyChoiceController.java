package org.gianfranco.controller;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.entity.Currency;
import org.gianfranco.model.repository.CurrencyConverterRepository;
import org.gianfranco.view.CurrencyChoice;
import org.gianfranco.view.Request;

import java.util.List;

public class CurrencyChoiceController implements Controller{

    private static CurrencyChoiceController instance;

    public static CurrencyChoiceController getInstance(){
        if (instance == null) instance = new CurrencyChoiceController();
        return instance;
    }

    private CurrencyChoice currencyChoice;
    private CurrencyConverterRepository repository;
    private List<Currency> currencies;
    private Conversion conversion;

    private CurrencyChoiceController() {}


    @Override
    public void run() {
        if (repository == null) throw new RuntimeException("Repository no inicializado");

        currencyChoice = new CurrencyChoice();
        conversion = new Conversion();
        currencies = repository.getCurrencyCodes();
        while(true){
            currencyChoice.body(currencies, null);
            int optionBase = Request.intResponse(
                    "Seleccionar la divisa de origen:",
                    "No es posible procesar esa opción",
                    s -> checkFormat(s) != 0);

            if (optionBase == currencies.size() + 1) {
                conversion = null;
                return;
            }

            Currency base = currencies.get(optionBase - 1);
            conversion.setBase(base);

            currencyChoice.body(currencies, base);
            int optionTarget = Request.intResponse(
                    "Seleccionar la divisa de destino:",
                    "No es posible procesar esa opción",
                    s -> checkFormat(s) != 0);

            if (optionTarget == currencies.size() + 1) continue;
            conversion.setTarget(currencies.get(optionTarget - 1));
            return;

        }

    }

    private int checkFormat(String option){
        int optionInt = Integer.parseInt(option);
        if (optionInt > currencies.size() + 2 || optionInt < 1) return 0;
        return optionInt;
    }

    public Conversion getConversion() {
        return conversion;
    }

    public CurrencyConverterRepository getRepository() {
        return repository;
    }

    public void setRepository(CurrencyConverterRepository repository) {
        this.repository = repository;
    }
}
