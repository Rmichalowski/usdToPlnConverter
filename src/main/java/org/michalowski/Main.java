package org.michalowski;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.michalowski.DTO.Computer;
import org.michalowski.DTO.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Computer computer1 = new Computer("komputer1", 345, LocalDate.of(2022, 04, 04));
        Computer computer2 = new Computer("komputer2", 543, LocalDate.of(2022, 04, 04));
        Computer computer3 = new Computer("komputer3", 346, LocalDate.of(2022, 04, 04));

        cart.addComputer(computer1);
        cart.addComputer(computer2);
        cart.addComputer(computer3);

        System.out.println(cart.getTotalPricePLN() + "PLN");
        cart.toFileXML();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cart");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computer1);
        entityManager.persist(computer2);
        entityManager.persist(computer3);
        entityManager.persist(cart);
        entityManager.getTransaction().commit();




    }
}