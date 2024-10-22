package com.alura.condivisas.modelos;
import java.util.List;

public class ApiResponseC {
    private final String result;
    private final List<List<String>> supported_codes;

    // Constructor
    public ApiResponseC (String result, List<List<String>> supported_codes) {
        this.result = result;
        this.supported_codes = supported_codes;
    }

    // Getters
    public String getResult() {
        return result;
    }

    public List<List<String>> getSupportedCodes() {
        return supported_codes;
    }
}
