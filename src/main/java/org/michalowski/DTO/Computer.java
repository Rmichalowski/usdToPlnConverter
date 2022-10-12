package org.michalowski.DTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Computer {

    @XmlElement
    private String name;

    @XmlElement
    private double price;

    public Computer() {
    }

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "-" + name + " - kwota" + price + " USD.";
    }

    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<komputer>\n");

    }
}
