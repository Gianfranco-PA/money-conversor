package org.gianfranco.view;

import org.gianfranco.model.entity.Currency;
import org.gianfranco.view.entity.Shortcut;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Initial {

    private Scanner scanner = new Scanner(System.in);

    public void body(List<Shortcut> shortcuts){

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
        System.out.println((index++) + "). Salir");
    }

    public String request(){
        System.out.print("Introduzca la opcion que desea realizar: ");
        return scanner.nextLine();
    }


}
