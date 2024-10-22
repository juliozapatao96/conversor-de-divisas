package com.alura.condivisas.utils;

import jdk.jshell.Snippet;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void showMessage(String mensaje) {
        System.out.println(mensaje);
    }

    public String showrMenuUser(){
        showMessage("****************************************************");
        showMessage("************* Conversor de divisas *****************");
        showMessage("****************************************************");
        showMessage(" Ingrese la opción que desees usar:");
        showMessage("1. Validar si el código de una divisa existe.");
        showMessage("2. Realizar una conversión.");
        showMessage("3. Consultar los códigos de divisas soportados.");
        showMessage("4. Salir");
        return scanner.nextLine();
    }

    public String requestCode(boolean typeCode){
        if (typeCode){
            showMessage("Escriba el código de divisa base.");
        }else{
            showMessage("Escriba el código de divisa objetivo o a convertir.");
        }
        return scanner.nextLine().toUpperCase();
    }

    public String requestCode(){
        showMessage("Escriba el código de divisa que desea validar.");
        return scanner.nextLine().toUpperCase();
    }

    public String requestAmount(){
        showMessage("Escriba el monto que desea convertir.");
        return scanner.nextLine();
    }

}
