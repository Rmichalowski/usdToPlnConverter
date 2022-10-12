package org.michalowski.UTILS;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

public class Converter {

    public static double convertUsdToPln(double USD, LocalDate date) {
        StringBuilder request = new StringBuilder("http://api.nbp.pl/api/exchangerates/rates/c/usd/" + date + "/?format=json");
        StringBuilder rateString = new StringBuilder(connectToUrl(request));
        double rate = getRate(rateString);
            return USD*rate ;
        }


        public static StringBuilder connectToUrl(StringBuilder request){
            StringBuilder answer = new StringBuilder();
            try {
                URL url = new URL(request.toString());
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                int responseCode = con.getResponseCode();
                if (responseCode != 200) {
                    throw new RuntimeException("Niepowodzenie, kod: " + responseCode);
                } else {
                    Scanner scanner = new Scanner(url.openStream());
                    while (scanner.hasNext()) {
                        answer.append(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
            catch(Exception e){
            }
        return answer;
        }


        public static double getRate (StringBuilder answer){
            JSONParser parser = new JSONParser();
            JSONObject jsonAsnwer = null;
            try {
                jsonAsnwer = (JSONObject) parser.parse(answer.toString());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String temp = jsonAsnwer.get("rates").toString();
            StringBuilder bid = new StringBuilder();

            int index = temp.indexOf("bid") + 5;
            while (!temp.substring(index, index + 1).equals(",")) {
                bid.append(temp.substring(index, index + 1));
                index++;
            }
            double convRate = Double.parseDouble(bid.toString());
            return convRate;
    }

}
