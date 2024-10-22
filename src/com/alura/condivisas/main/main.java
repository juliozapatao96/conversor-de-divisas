package com.alura.condivisas.main;

import com.alura.condivisas.records.PairConversion;
import com.alura.condivisas.services.ApiERService;
import com.alura.condivisas.utils.UserInterface;
import com.alura.condivisas.utils.Validator;

import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        ApiERService apiERService = new ApiERService();
        UserInterface ui = new UserInterface();
        Validator validator = new Validator();
        // Obtener la lista de códigos de divisas
        Map<String, String> currenciesCodes = apiERService.getSupportedCurrencies();

        while (true){
            String option = ui.showrMenuUser();
            if (option.equalsIgnoreCase("4")) {
                break;
            } else if (option.equalsIgnoreCase("3")) {
                ui.showMessage("Divisas soportadas:");
                for (Map.Entry<String, String> entry : currenciesCodes.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else if (option.equalsIgnoreCase("2")) {
                String codeBase = ui.requestCode(true);
                String codeTarget = ui.requestCode(false);
                String amount = ui.requestAmount();

                validator.validateCode(codeBase, currenciesCodes, false);
                validator.validateCode(codeTarget, currenciesCodes, false);

                PairConversion data = apiERService.convertCurrency(codeBase,codeTarget,amount);
                System.out.println(data);
            } else if (option.equalsIgnoreCase("1")) {
                String codeValidate = ui.requestCode();
                validator.validateCode(codeValidate, currenciesCodes, true);
            } else {
                ui.showMessage("Debe ingresar una opción válida. Intente nuevamente.\n");
            }


        }


        // Mostrar los códigos y nombres de divisas
        /*
        System.out.println("Divisas soportadas:");
        for (Map.Entry<String, String> entry : currenciesCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */

    }
}
