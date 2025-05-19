package org.gianfranco;

import org.gianfranco.controller.ConsoleController;
import org.gianfranco.model.repository.CacheRepository;
import org.gianfranco.model.repository.exchange.rate.ExchangeRateAPI;

public class Main {
    public static void main(String[] args) {

        //CurrencyConverterRepository repository = new ExchangeRateAPI();
        //repository.getCurrencyCodes().forEach(System.out::println);

        ConsoleController controller = ConsoleController.getInstance();
        controller.setRepository(new CacheRepository(new ExchangeRateAPI()));
        controller.run();
    }
}