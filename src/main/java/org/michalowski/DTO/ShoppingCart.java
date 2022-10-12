package org.michalowski.DTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


public class ShoppingCart {

    List<Computer> computers;

    double totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(List<Computer> computers) {
        this.computers = computers;
        for (Computer computer : computers){
            totalPrice += computer.getPrice();
        }
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
        totalPrice += computer.getPrice();
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
        totalPrice -= computer.getPrice();
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<faktura>\n");

        for (Computer computer : computers){
            xml.append(computer.toXML());
        }

    }

}
