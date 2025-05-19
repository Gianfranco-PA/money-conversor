package org.gianfranco.controller;

import org.gianfranco.model.entity.Conversion;
import org.gianfranco.view.Request;
import org.gianfranco.view.ConversionResult;

public class ConversionResultController implements Controller{

    private static ConversionResultController instance;

    public static ConversionResultController getInstance(){
        if (instance == null) instance = new ConversionResultController();
        return instance;
    }

    private ConversionResult conversionResult;
    private Conversion conversion;

    private ConversionResultController() {
    }


    public Conversion getConversion() {
        return conversion;
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    @Override
    public void run() {
        if (conversion == null) throw new RuntimeException("Conversion no inicializada");
        conversionResult = new ConversionResult();

        double value = Request.doubleResponse(
                "Introduzca el valor a convertir:",
                "Por favor, introducir un valor adecuado",
                s -> s.matches("\\d+(\\.\\d+)?"));
        conversion.setAmount(value);

        conversionResult.body(conversion);

        Request.stringResponse("Presione enter para continuar...");
    }
}
