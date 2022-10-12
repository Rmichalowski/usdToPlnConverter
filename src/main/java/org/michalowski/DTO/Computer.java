package org.michalowski.DTO;

import org.michalowski.UTILS.Converter;

import java.time.LocalDate;

public class Computer {

    private String name;
    private double priceUSD;
    private double pricePLN;
    private LocalDate postingDate;

    public Computer() {
    }

    public Computer(String name, double price, LocalDate postingDate) {
        this.name = name;
        this.priceUSD = price;
        this.postingDate = postingDate;
        pricePLN = Converter.convertUsdToPln(price, postingDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceUSD() {
        Math.round(priceUSD);
        return priceUSD;
    }

    public void setPriceUSD(double price) {
        this.priceUSD = price;
    }

    public double getPricePLN() {
        //return pricePLN;
        return ((double)Math.round(pricePLN*100)/100);
    }

    public void setPricePLN(double pricePLN) {
        this.pricePLN = pricePLN;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    @Override
    public String toString() {
        return "-" + name + " - kwota" + priceUSD + " USD.";
    }

    public StringBuilder toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("    " +"<komputer>\n");
        xml.append( "    " + "    " + "<nazwa>" + getName() + "</nazwa>\n");
        xml.append("    " + "    " + "<data_ksiegowania>" + getPostingDate() + "</data_ksiegowania>\n");
        xml.append("    " + "    " + "<koszt_USD>" + getPriceUSD() + "</koszt_USD>\n");
        xml.append("    " + "    " + "<koszt_PLN>" + getPricePLN() + "</koszt_PLN>\n");
        xml.append("    " +"</komputer>\n");
        return xml;
    }
}
