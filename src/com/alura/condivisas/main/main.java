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

        var codeBase = ui.requestCode(true);
        var codeTarget = ui.requestCode(false);
        var amount = ui.requestAmount();

        validator.validateCode(codeBase, currenciesCodes);
        validator.validateCode(codeTarget, currenciesCodes);


        PairConversion data = apiERService.convertCurrency(codeBase,codeTarget,amount);
        System.out.println(data);




        // Mostrar los códigos y nombres de divisas
        /*
        System.out.println("Divisas soportadas:");
        for (Map.Entry<String, String> entry : currenciesCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */

    }
}
