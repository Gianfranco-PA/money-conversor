package org.gianfranco.controller;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.model.repository.CurrencyConverterRepository;
import org.gianfranco.view.entity.Shortcut;

import java.util.List;

public class ConsoleController implements Controller {

    private static ConsoleController instance;

    public static ConsoleController getInstance(){
        if (instance == null) instance = new ConsoleController();
        return instance;
    }

    private MenuController menuController;
    private ConversionResultController conversionResultController;
    private CurrencyConverterRepository repository;

    private ConsoleController() {
    }

    @Override
    public void run() {
        if (repository == null) throw new RuntimeException("Repository no inicializado");

        while(true){
            menuController = MenuController.getInstance();
            menuController.setRepository(repository);
            menuController.run();
            int option = menuController.getOption();
            List<Shortcut> activeShortcuts = menuController.getActiveShortcuts();

            if (option == activeShortcuts.size() + 2) System.exit(0);
            else if (option > 0 && option <= activeShortcuts.size()) {
                Shortcut selectedShortcut = activeShortcuts.get(option-1);
                Conversion conversion = repository.getExchangeRate(selectedShortcut.getCurrencyBase(), selectedShortcut.getCurrencyTarget());
                conversionResultController = ConversionResultController.getInstance();
                conversionResultController.setConversion(conversion);
                conversionResultController.run();
            }else{

            }
        }

    }

    public CurrencyConverterRepository getRepository() {
        return repository;
    }

    public void setRepository(CurrencyConverterRepository repository) {
        this.repository = repository;
    }
}
