package com.dsc;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataModifier {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\dhanetwa.CORPDOM\\IPEDL.csv";
        DataModifier dataModifier = new DataModifier();
        List<AELog> users = new ArrayList<>();
        users = dataModifier.extractData(file);
        users = dataModifier.modifyData(users);
        dataModifier.writeToCSV(users);
    }

    void writeToCSV(List<AELog> data) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\dhanetwa.CORPDOM\\IPEDL_Out.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(AELog aeLog : data){
            String line = aeLog.getUsername() + "," + aeLog.getDisabled()  + "," + aeLog.getPermissionName() + "," + aeLog.getAccountType() + ","+ aeLog.getAction() + ","+ (aeLog.getDatetime() instanceof String ? aeLog.getDatetime() : new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(aeLog.getDatetime())) + ","+ aeLog.getAdminUsername() + "\n";
            fileWriter.write(line);
        }
        fileWriter.close();
    }

    List<AELog> modifyData(List<AELog> data){
        List<AELog> modifiedData = new ArrayList<>();
        for(int i=0; i<data.size() - 1; i++){
            AELog curr = data.get(i);
            AELog next = data.get(i+1);
            Date nextSecDate = null;
            if(i != 0) {
                int currSec = ((Date) curr.getDatetime()).getSeconds();
                nextSecDate = (Date) ((Date) curr.getDatetime()).clone();
                nextSecDate.setSeconds(currSec - 1);
            }
            if(!curr.getAccountType().equals(next.getAccountType())){ // remove account type change
                if(curr.getUsername().equals(next.getUsername()) && curr.getDatetime().equals(next.getDatetime())) {
                    i++;
                    continue;
                }
            }
            else{
                if(curr.getUsername().equals(next.getUsername()) && (curr.getDatetime().equals(next.getDatetime()) || next.getDatetime().equals(nextSecDate)) && curr.getAccountType().equals(next.getAccountType()) && curr.getPermissionName().equals(next.getPermissionName())){ // remove account disable users
                    if((curr.getDisabled().equals("No") && next.getDisabled().equals("Yes")) && (curr.getAction().equals("Yes") && next.getAction().equals("No"))) {
                        i++;
                    }
                    else if((curr.getDisabled().equals("Yes") && next.getDisabled().equals("No")) && (curr.getAction().equals("Yes") && next.getAction().equals("No"))) {
                        i++;
                    }
                }
            }
            modifiedData.add(curr);
            if(i == data.size()-2){
                modifiedData.add(next);
            }
        }

        return modifiedData;
    }
    List<AELog> extractData(String file){
        List<AELog> users = new ArrayList<>();
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String arr[];
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\"","");
                AELog aeLog = new AELog();
                arr = line.split(",");
                aeLog.setUsername(arr[0]);
                aeLog.setDisabled(arr[1]);
                aeLog.setPermissionName(arr[2]);
                aeLog.setAccountType(arr[3]);
                aeLog.setAction(arr[4]);
                if(count != 0) {
                    Date inputData = ((Date)new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(arr[5]));
                    aeLog.setDatetime(inputData);
                }else{
                    aeLog.setDatetime(arr[5]);
                }
                aeLog.setAdminUsername(arr[6]);
                users.add(aeLog);
                count++;
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //users.remove(0);
        return users;
    }
}
