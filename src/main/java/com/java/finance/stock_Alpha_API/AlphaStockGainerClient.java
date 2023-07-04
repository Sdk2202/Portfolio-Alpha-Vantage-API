package com.java.finance.stock_Alpha_API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class AlphaStockGainerClient {
	
	public static void main(String[] args) {
        try {

            URL url = new URL("https://www.alphavantage.co/query?function=TOP_GAINERS_LOSERS&apikey=X8N115V4N6A1QCIG");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();
               // System.out.println("inline" +inline);
                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //Get the required object from the above created object
                JSONArray arr = (JSONArray) data_obj.get("top_gainers");
                
                //JSONObject obj = (JSONObject) data_obj.get("top_gainers");

                //Get the required data using its key
                //System.out.println(arr.toJSONString());

                //JSONArray arr = (JSONArray) data_obj.get("ticker");

                for (int i = 0; i < arr.size(); i++) {

                    JSONObject new_obj = (JSONObject) arr.get(i);

                        System.out.println("Top gainer: " +  new_obj.get("ticker"));
                        System.out.println("Top gainer Volume: " + new_obj.get("volume"));
                        System.out.println("Top gainer change_amount: " + new_obj.get("change_amount"));
                        
                    }
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	

}
