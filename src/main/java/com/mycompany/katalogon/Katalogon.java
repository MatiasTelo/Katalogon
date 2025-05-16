
package com.mycompany.katalogon;

import Entities.Articulo;
import org.hibernate.Session;


public class Katalogon {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.close();

        HibernateUtil.shutdown();

        System.out.println("Articulo guardado con éxito en la base de datos.");
    }
}
