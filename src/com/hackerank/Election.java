package com.hackerank;

import java.util.*;

public class Election {
    void prepareMap(){

    }
    public static void main(String[] args) {
        String electionArr[] = {"Victor", "Veronica",
                "Ryan",
                "Dave",
                "Maria",
                "Maria",
                "Farah",
                "Farah",
                "Ryan",
                "Veronica"};
        Map<String, Integer> electionCountMap = new HashMap<>();

        for(int i=0; i<electionArr.length; i++){
            if(electionCountMap.size() != 0 && electionCountMap.get(electionArr[i])!= null && electionCountMap.get(electionArr[i])>=1){
                electionCountMap.put(electionArr[i], electionCountMap.get(electionArr[i]) + 1);
            }else {
                electionCountMap.put(electionArr[i], 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(electionCountMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int count=0;
        for(String key : sortedMap.keySet()){

        }

    }
}
