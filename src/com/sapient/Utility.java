package com.sapient;

import com.sapient.model.DetailInput;

import java.util.*;

/**
 * Created by dhanetwa on 8/11/2018.
 */
public class Utility {
    static List parseAmount(List<DetailInput> detailInputList){
        ListIterator<DetailInput> listIterator = detailInputList.listIterator();
        List<DetailInput> updatedList = new ArrayList<>();
        while (listIterator.hasNext()){
            DetailInput detailInput = (DetailInput) listIterator.next();
            String currency = detailInput.getCurrency();
            switch (currency){
                case "INR" :
                    detailInput.setAmount(detailInput.getAmount()/66);
                    break;
                case "SGD" :
                    detailInput.setAmount(detailInput.getAmount()/1.37);
                    break;
                case "HKD" :
                    detailInput.setAmount(detailInput.getAmount()/7.85);
                    break;
            }
            updatedList.add(detailInput);
        }
        return updatedList;
    }
//C:\Users\dhanetwa\Documents\sample_input.csv

    static void countRowsPerCountry(List<DetailInput> detailInputList){
        ListIterator<DetailInput> listIterator1 = detailInputList.listIterator();
        Map<String, Map<String, Integer>> uniqueMap = new HashMap<>();
        Map<String, Integer> genderMap = new HashMap<>();
        Set<String> uniqueCountires = new HashSet<>();
        while (listIterator1.hasNext()){
            DetailInput detailInput = listIterator1.next();
            uniqueCountires.add(detailInput.getCountry());
        }

        for(String country : uniqueCountires){
            ListIterator<DetailInput> listIterator = detailInputList.listIterator();
            int mCounter = 0;
            int fCounter = 0;
            while (listIterator.hasNext()){
                DetailInput detailInput = listIterator.next();
                if(country.equalsIgnoreCase(detailInput.getCountry())){
                    if(detailInput.getGender().equalsIgnoreCase("M")){
                        //mCounter++;
                        if(genderMap.containsKey("M")){
                            genderMap.put("M", genderMap.get("M")+1);
                        }
                        else{
                            genderMap.put("M", 1);
                        }
                    }else{
                        //fCounter++;
                        if(genderMap.containsKey("F")){
                            genderMap.put("F", genderMap.get("F")+1);
                        }
                        else{
                            genderMap.put("F", 1);
                        }
                    }
                }
                uniqueMap.put(country, genderMap);
            }
        }
    }
}
