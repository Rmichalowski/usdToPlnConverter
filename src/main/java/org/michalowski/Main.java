package org.michalowski;


import org.michalowski.DTO.Computer;
import org.michalowski.DTO.ShoppingCart;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Tworzenie obiektów z zadania
        ShoppingCart cart = new ShoppingCart();

        Computer computer1 = new Computer("komputer1", 345, LocalDate.of(2022, 04, 04));
        Computer computer2 = new Computer("komputer2", 543, LocalDate.of(2022, 04, 04));
        Computer computer3 = new Computer("komputer3", 346, LocalDate.of(2022, 04, 04));

        cart.addComputer(computer1);
        cart.addComputer(computer2);
        cart.addComputer(computer3);


        System.out.println(cart.getTotalPricePLN() + "PLN");
        //Zapis do XML
        cart.toFileXML();

        //Zapis do bazy danych (użyto bazy danych MYSQL workbench skonfigurowana w resources/META-INF/persistence.xml)
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