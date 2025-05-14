package org.gianfranco;

import org.gianfranco.controller.ConsoleController;
import org.gianfranco.controller.Controller;
import org.gianfranco.model.repository.CurrencyConverterRepository;
import org.gianfranco.model.repository.exchange.rate.ExchangeRateAPI;
import org.gianfranco.view.Initial;

public class Main {
    public static void main(String[] args) {

        //CurrencyConverterRepository repository = new ExchangeRateAPI();
        //repository.getCurrencyCodes().forEach(System.out::println);

        Controller controller = new ConsoleController();
        controller.run();
    }
}