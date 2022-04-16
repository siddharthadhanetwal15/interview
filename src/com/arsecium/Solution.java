package com.arsecium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.*;


import java.net.URL;
import java.net.HttpURLConnection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Result {

    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */

    public static Map<String , Map<String, HoldingData>> dataMap;

    public static double calculateNAV(String date) {
        Double navValue = 0.0;
        if(dataMap == null || dataMap.isEmpty()){
            dataMap = new ConcurrentHashMap<>();
//https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/holding_start - pagination
            String holdingAllApi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
            String holdingResponse  = getApiData(holdingAllApi);
            mapHoldingToResponse(holdingResponse);

            String allPriceAPi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";
            String priceResponse  = getApiData(allPriceAPi);
            mapPriceToResponse(priceResponse);
        }

        String dateKey = date.replaceAll("[\\s\\-()]", "");

        if(dataMap.containsKey(dateKey)){
            Map<String , HoldingData> map = dataMap.get(dateKey);
            for(Map.Entry<String , HoldingData> e : map.entrySet()){
                navValue += e.getValue().getQuantity()*e.getValue().getPrice();
            }
        }


        return navValue;
    }

    public static void mapPriceToResponse(String priceResponse){
        try{
            Gson gson = new GsonBuilder().create();
            PriceData[] r = gson.fromJson(priceResponse , PriceData[].class);

            for (PriceData priceData : r) {
                if(dataMap.containsKey(priceData.getDate()) && dataMap.get(priceData.getDate()).containsKey(priceData.getSecurity() )){
                    System.out.println(priceData.getDate());
                    dataMap.get(priceData.getDate()).get(priceData.getSecurity()).setPrice(priceData.getPrice());

                }
            }


        }catch(Exception ex){
            System.out.println("error in price gson parding =["+ex+"]");
        }
    }

    public static void mapHoldingToResponse(String holdingResponse){
        try{
            Gson gson = new GsonBuilder().create();
            HoldingData[] r = gson.fromJson(holdingResponse , HoldingData[].class);

            for (HoldingData holdingData : r) {
                if(dataMap.containsKey(holdingData.getDate())){
                    dataMap.get(holdingData.getDate()).put(holdingData.getSecurity() ,holdingData);

                }else{
                    Map<String , HoldingData> map = new ConcurrentHashMap<>();
                    map.put(holdingData.getSecurity(), holdingData);
                    dataMap.put(holdingData.getDate(), map);

                }
            }

        }catch(Exception ex){
            System.out.println("error in holding gson parding =["+ex+"]");
        }
    }

    public static String getApiData(String urll){
        try{
            URL url = new URL(urll);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            //  System.out.println("response code ="+responseCode);

            String inline ="";
            Scanner scanner = new Scanner(url.openStream());

            while(scanner.hasNext()){
                inline+= scanner.nextLine();
            }

            scanner.close();

            return inline;

        }catch(Exception e){
            System.out.println("exception code ="+e);
        }
        return "";
    }

    public class PriceData{

        private String date;
        private String security;
        private Double price;


        @Override
        public String toString(){
            return this.date;
        }


        public String getDate(){
            return date;
        }

        public String getSecurity(){
            return security;
        }

        public void setDate(String data){
            this.date = data;
        }

        public void setSecurity(String security){
            this.security = security;
        }


        public Double getPrice(){
            return price;
        }

        public void setPrice(Double price){
            this.price = price;
        }
    }


    public class HoldingData{

        private String date;
        private String security;
        private Integer quantity;
        private Double price;
        private String portfolio;

        @Override
        public String toString(){
            return this.date;
        }


        public String getDate(){
            return date;
        }

        public String getSecurity(){
            return security;
        }
        public Integer getQuantity(){
            return quantity;
        }
        public String getPortfolio(){
            return portfolio;
        }

        public void setDate(String data){
            this.date = data;
        }

        public void setSecurity(String security){
            this.security = security;
        }

        public void setQuantity(Integer quantity){
            this.quantity = quantity;
        }

        public void getPortfolio(String portfolio){
            this.portfolio = portfolio;
        }


        public Double getPrice(){
            return price;
        }

        public void setPrice(Double price){
            this.price = price;
        }


    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String date = bufferedReader.readLine();

        double result = Result.calculateNAV(date);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        short s = 10;
        s = (short) (s*s);


    }
}
