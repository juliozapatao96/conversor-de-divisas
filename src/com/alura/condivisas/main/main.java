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
                validator.showCurriencies(currenciesCodes);
            } else if (option.equalsIgnoreCase("2")) {
                try{
                    String codeBase = ui.requestCode(true);
                    boolean resultCodeBase = validator.validateCode(codeBase, currenciesCodes, false);
                    if (!resultCodeBase){continue;}

                    String codeTarget = ui.requestCode(false);
                    boolean resultCodeTarget =validator.validateCode(codeTarget, currenciesCodes, false);
                    if (!resultCodeTarget){continue;}

                    String amount = ui.requestAmount();

                    PairConversion data = apiERService.convertCurrency(codeBase,codeTarget,amount);

                    ui.showMessage("El monto de "+amount+" "+codeBase+" corresponde a "+data.conversion_result()+" "+codeTarget);
                }catch (RuntimeException e){
                    ui.showMessage("Error: "+e.getMessage());
                }
            } else if (option.equalsIgnoreCase("1")) {
                String codeValidate = ui.requestCode();
                validator.validateCode(codeValidate, currenciesCodes, true);
            } else {
                ui.showMessage("Debe ingresar una opción válida. Intente nuevamente.\n");
            }
        }
    }
}
