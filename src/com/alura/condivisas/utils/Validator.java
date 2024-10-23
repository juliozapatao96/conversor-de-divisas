package com.alura.condivisas.utils;

import java.util.Map;

public class Validator {

    public boolean validateCode(String inputCode, Map<String, String> currenciesCodes, boolean show){
        // Validar si el código ingresado está en el Map
        if (currenciesCodes.containsKey(inputCode)) {
            if (show){
                System.out.println("El código " + inputCode + " es válido. Nombre de la divisa: " + currenciesCodes.get(inputCode));
            }
            return true;
        } else {
            System.out.println("El código " + inputCode + " no es válido. Intente ingresando otro código.");
            return false;
        }
    }

    public void showCurriencies(Map<String, String> currenciesCodes){
        for (Map.Entry<String, String> entry : currenciesCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
