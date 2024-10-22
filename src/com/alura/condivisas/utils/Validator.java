package com.alura.condivisas.utils;

import java.util.Map;

public class Validator {

    public void validateCode(String inputCode, Map<String, String> currenciesCodes){
        // Validar si el código ingresado está en el Map
        if (currenciesCodes.containsKey(inputCode)) {
            System.out.println("El código " + inputCode + " es válido. Nombre de la divisa: " + currenciesCodes.get(inputCode));
        } else {
            System.out.println("El código " + inputCode + " no es válido.");
        }
    }

}
