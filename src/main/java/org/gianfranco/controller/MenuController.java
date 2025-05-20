package org.gianfranco.controller;

import org.gianfranco.model.repository.CurrencyConverterRepository;
import org.gianfranco.view.Menu;
import org.gianfranco.view.Request;
import org.gianfranco.view.entity.Shortcut;

import java.util.List;

public class MenuController implements Controller {

    private static MenuController instance;

    private CurrencyConverterRepository repository;
    private Menu menu;
    private int option;
    private List<Shortcut> activeShortcuts;

    private MenuController(){}

    public static MenuController getInstance(){
        if (instance == null) instance = new MenuController();
        return instance;
    }

    @Override
    public void run() {
        if(repository == null) throw new RuntimeException("Repository no inicializado");
        menu = new Menu();
        repository.getCurrencyCodes().forEach(Shortcut::checkActive);
        activeShortcuts = Shortcut.getActiveShortcuts();
        menu.show(activeShortcuts);
        option = Request.intResponse(
                "Indicar la opción escogida:",
                "No es posible procesar esa opción",
                s -> checkFormat(s) != 0);
    }

    private int checkFormat(String option){
        int optionInt = Integer.parseInt(option);
        if (optionInt > activeShortcuts.size() + 2 || optionInt < 1) return 0;
        return optionInt;
    }

    public int getOption() {
        return option;
    }

    public List<Shortcut> getActiveShortcuts() {
        return activeShortcuts;
    }

    public CurrencyConverterRepository getRepository() {
        return repository;
    }

    public void setRepository(CurrencyConverterRepository repository) {
        this.repository = repository;
    }
}
