
package com.mycompany.katalogon;

import UI.MainMenu;
import org.hibernate.Session;

public class Katalogon {

    public static void main(String[] args) {

        MainMenu pantalla = new MainMenu();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);

        System.out.println("Articulo guardado con éxito en la base de datos.");
    }
}
