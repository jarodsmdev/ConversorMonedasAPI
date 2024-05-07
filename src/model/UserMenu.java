package model;

import Utils.UtilsMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserMenu {

    String optionUser = "";
    String amount = "";
    Scanner inputUser = new Scanner(System.in);
    ConsultaAPI consulta = new ConsultaAPI();


    public void menu() throws IOException, InterruptedException {
        Integer menuSelector;
        do {
            displayMenu();
            optionUser = inputUser.nextLine();
            if (UtilsMethods.isNumeric(optionUser)) {
                menuSelector = Integer.parseInt(optionUser);
                switch (menuSelector) {
                    case 1:
                        System.out.println("Dólar => Peso argentino");
                        amount = getInputAmount();
                        convertDollarToArgentinePeso(Float.parseFloat(amount));
                        break;
                    case 2:
                        System.out.println("Peso argentino => Dólar");
                        amount = getInputAmount();
                        convertArgentinePesoToDollar(Float.parseFloat(amount));
                        break;
                    case 3:
                        System.out.println("Dólar => Real brasileño");
                        amount = getInputAmount();
                        convertDollarToBrazilianReal(Float.parseFloat(amount));
                        break;
                    case 4:
                        System.out.println("Real brasileño => Dólar");
                        amount = getInputAmount();
                        convertBrazilianRealToDollar(Float.parseFloat(amount));
                        break;
                    case 5:
                        System.out.println("Dólar => peso colombiano");
                        amount = getInputAmount();
                        convertDollarToColombianPeso(Float.parseFloat(amount));
                        break;
                    case 6:
                        System.out.println("Peso colombiano => Dólar");
                        amount = getInputAmount();
                        convertColombianPesoToDollar(Float.parseFloat(amount));
                        break;
                    case 7:
                        exit();
                        break;
                    default:
                        System.out.println("[!] ERROR. Ingrese un valor válido.");
                }
            } else {
                System.out.println("[!] ERROR. Ingrese un valor válido.");
                menuSelector = 0;
            }
        } while (menuSelector <= 0 || menuSelector > 7);
    }

    private void displayMenu() {
        System.out.println("""
                    \n*****************************************************
                    *** Bienvenido al sistema de conversor de Monedas ***
                    *****************************************************
                    
                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasileño
                    4) Real brasileño => Dólar
                    5) Dólar => peso colombiano
                    6) Peso colombiano => Dólar
                    7) Salir
                    [>] Elija una opción Válida: """);
    }

    private String getInputAmount() {
        String amount;
        do {
            System.out.println("[>] Ingrese el monto a convertir: ");
            amount = inputUser.nextLine();
            if (amount.isEmpty() || !UtilsMethods.isNumeric(amount)) {
                System.out.println("[!] Ingrese un valor válido.");
            }
        } while (amount.isEmpty() || !UtilsMethods.isNumeric(amount));
        return amount;
    }

    public void convertDollarToArgentinePeso(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "USD", "ARS");
        menu();
    }

    public void convertArgentinePesoToDollar(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "ARS", "USD");
        menu();
    }

    public void convertDollarToBrazilianReal(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "USD", "BRL");
        menu();
    }

    public void convertBrazilianRealToDollar(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "BRL", "USD");
        menu();
    }

    public void convertDollarToColombianPeso(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "USD", "COP");
        menu();
    }

    public void convertColombianPesoToDollar(float amount) throws IOException, InterruptedException {
        consulta.consultar(amount, "COP", "USD");
        menu();
    }

    public void exit(){
        System.out.println("[!] Saliendo del sistema...");
    }

}
