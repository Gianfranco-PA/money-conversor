package org.gianfranco.view;

import org.gianfranco.view.entity.Shortcut;

import java.util.List;

public class Menu {

    public void show(List<Shortcut> shortcuts){

        System.out.println("==========================================");
        System.out.println("========== Conversor de monedas ==========");
        System.out.println("==========================================");
        System.out.println("OPCIONES:");
        int index = 1;
        System.out.println("==== Accesos directos ====");
        for (Shortcut shortcut : shortcuts) {
            shortcut.display(index++);
        }
        System.out.println("==== Otras operaciones ===");
        System.out.println((index++) + "). Escoger moneda de origen y destino");
        System.out.println((index) + "). Salir");
    }
}
