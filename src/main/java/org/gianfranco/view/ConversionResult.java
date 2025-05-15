package org.gianfranco.view;

import org.gianfranco.model.entity.Conversion;

import java.util.Scanner;

public class ConversionResult {
    private Scanner scanner = new Scanner(System.in);

    public void body(Conversion conversion){
        String title = "Conversión de " + conversion.getBase().getName() + " a " + conversion.getTarget().getName();
        System.out.println("==========================================");
        System.out.println("======== " + title + " =========");
        System.out.println("==========================================");
        System.out.println("Valor a convertir: " + conversion.getAmount());
        System.out.println("Tipo de cambio: " + conversion.getRate());
        System.out.println("Resultado: " + conversion.getResult());
        System.out.println("==========================================");



    }

    public String request(){
        System.out.println("Por favor presione cualquier tecla para continuar");
        return scanner.nextLine();
    }
}
