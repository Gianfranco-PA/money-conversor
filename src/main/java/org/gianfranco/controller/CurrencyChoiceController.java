package org.gianfranco.controller;

public class CurrencyChoiceController implements Controller{

    private static CurrencyChoiceController instance;

    public static CurrencyChoiceController getInstance(){
        if (instance == null) instance = new CurrencyChoiceController();
        return instance;
    }

    private CurrencyChoiceController() {}


    @Override
    public void run() {

    }
}
