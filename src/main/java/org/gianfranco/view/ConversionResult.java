package org.gianfranco.view;

import org.gianfranco.model.entity.Conversion;

public class ConversionResult {

    public void body(Conversion conversion){
        String title = "Conversión de " + conversion.getBase().getCode() + " a " + conversion.getTarget().getCode();
        System.out.println("==========================================");
        System.out.println("======== " + title + " =========");
        System.out.println("==========================================");
        System.out.println("Valor a convertir: " + conversion.getAmount());
        System.out.println("Tipo de cambio: " + conversion.getRate());
        System.out.println("Resultado: " + conversion.getResult());
        System.out.println("==========================================");
    }
}
