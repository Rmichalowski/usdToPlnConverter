package org.michalowski.DTO;

import org.michalowski.UTILS.Converter;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "priceUSD")
    private double priceUSD;
    @Column(name = "pricePLN")
    private double pricePLN;
    @Column(name = "postingDate")
    private LocalDate postingDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "shoppingCartID")
    private ShoppingCart shoppingCartID;

    public Computer() {
    }

    public Computer(String name, double price, LocalDate postingDate ) {
        this.name = name;
        this.priceUSD = price;
        this.postingDate = postingDate;
        pricePLN = Converter.convertUsdToPln(price, postingDate);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCartID;
    }

    public void setShoppingCart(ShoppingCart shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


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
