package main;

import model.ConsultaAPI;
import model.UserMenu;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        UserMenu userMenu = new UserMenu();
        try {
            userMenu.menu();
        } catch (InterruptedException | IOException e) {
            System.out.println("[!] ERROR: " + e.getMessage());
        }

        //ConsultaAPI consulta = new ConsultaAPI();
        //try {
        //    consulta.consultar(2);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
    }
}
