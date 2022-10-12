package org.michalowski.DTO;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.util.List;


public class ShoppingCart {

    List<Computer> computers;
    double totalPriceUSD;
    double totalPricePLN;

    public ShoppingCart() {
    }

    public ShoppingCart(List<Computer> computers) {
        this.computers = computers;
        for (Computer computer : computers){
            totalPriceUSD += computer.getPriceUSD();
            totalPricePLN += computer.getPricePLN();
        }
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
        totalPriceUSD += computer.getPriceUSD();
        totalPricePLN += computer.getPricePLN();
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
        totalPriceUSD -= computer.getPriceUSD();
        totalPricePLN -= computer.getPricePLN();
    }

    public double getTotalPricePLN() {
        return totalPricePLN;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public double getTotalPriceUSD() {
        return totalPriceUSD;
    }

    public StringBuilder toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<faktura>\n");

        for (Computer computer : computers){
            xml.append(computer.toXML());
        }

        xml.append("</faktura>\n");
        return xml;
    }

    public void toFileXML() {
        StringBuilder xml = new StringBuilder(toXML());
        System.out.println(xml);

        try {
            //https://docs.oracle.com/javaee/1.4/tutorial/doc/JAXPXSLT4.html
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml.toString())));

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("../usdToPlnConverter/faktura.xml"));
            transformer.transform(source, result);
        }
        catch (Exception e) { }

    }

}
