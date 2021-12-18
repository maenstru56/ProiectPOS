package com.base;

import entity.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ConsoleView view = new ConsoleView(new Store("Lidl", "Str. Rusciorului", new ProductCatalog()), new Controller());
        //view.start();

        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();


        CategoryEntity p1 = em.find(CategoryEntity.class, 103);



        em.getTransaction().begin();
        em.remove(p1);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
