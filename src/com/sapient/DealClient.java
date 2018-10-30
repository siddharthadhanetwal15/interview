package com.sapient;

import com.sapient.model.DetailInput;
import com.sapient.model.DetailOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dhanetwa on 8/10/2018.
 */
public class DealClient {
    public static void main(String[] args) {
        System.out.println("Please enter file location: ");
        Scanner scanner = new Scanner(System.in);
        String fileLocation = scanner.next();
        File file = new File(fileLocation);
        if(!file.exists()){
            System.out.println("No input file present. Exiting");
            System.exit(0);
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String content = "";
            List<DetailInput> detailList = new ArrayList<>();
            int row=0;
            while((content=bufferedReader.readLine())!=null){
//              System.out.println(content);
                if(row != 0) {
                    String[] contentArray = content.split(",");
                    DetailInput detailInput = new DetailInput();
                    detailInput.setCity(contentArray[0]);
                    if(contentArray[1].equalsIgnoreCase("")){
                        detailInput.setCountry(contentArray[0]);
                    }
                    else{
                        detailInput.setCountry(contentArray[1]);
                    }
                    detailInput.setGender(contentArray[2]);
                    detailInput.setCurrency(contentArray[3]);
                    detailInput.setAmount(Double.parseDouble(contentArray[4]));
                    detailList.add(detailInput);
                }
                row++;
            }
            detailList = Utility.parseAmount(detailList);
            Utility.countRowsPerCountry(detailList);
            System.out.println(detailList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
