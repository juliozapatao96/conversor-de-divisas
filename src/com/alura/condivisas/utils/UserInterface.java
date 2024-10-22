package com.alura.condivisas.utils;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String requestCode(boolean typeCode){
        if (typeCode){
            mostrarMensaje("Escriba el código de divisa base.");
        }else{
            mostrarMensaje("Escriba el código de divisa objetivo o a convertir.");
        }
        return scanner.nextLine().toUpperCase();
    }

    public String requestAmount(){
        mostrarMensaje("Escriba el monto que desea convertir.");
        return scanner.nextLine();
    }

}
