package org.michalowski;

import org.michalowski.DTO.Computer;
import org.michalowski.DTO.ShoppingCart;
import org.michalowski.UTILS.Converter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer("komputer1",345,LocalDate.of(2022,04,04));
        Computer computer2 = new Computer("komputer2",543,LocalDate.of(2022,04,04));
        Computer computer3 = new Computer("komputer3",346,LocalDate.of(2022,04,04));
        ShoppingCart cart = new ShoppingCart(new ArrayList<Computer>(Arrays.asList(computer1,computer2,computer3)));

        System.out.println(cart.getTotalPricePLN() + "PLN");
        //System.out.println(cart.toXML());
        cart.toFileXML();
        //zrobić xml i rozwiązać date ksiegowania
    }
}