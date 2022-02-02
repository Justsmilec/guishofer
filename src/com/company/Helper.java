package com.company;


import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Helper {



    public static String createId() {
        Clock clock = Clock.systemDefaultZone();
        long milliseconds = clock.millis();
        String uniqueId = "shofer";

        return uniqueId + "-" + milliseconds;
    }

    // Convert Array to List
    public static List<ShoferiFormula1> convertArrayToList(ShoferiFormula1[] list){
        return Arrays.asList(list.clone());
    }

    //Sort list of shofer 'descending'
    public static List<ShoferiFormula1> descendingOrderByPoints(List<ShoferiFormula1> list){
        List<ShoferiFormula1> sortedList = new ArrayList<ShoferiFormula1>();

        for(int i = 0; i < list.size(); i++){
            ShoferiFormula1 shofer = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if(i != j){
                    if(shofer.getNrPikeveShoferit() < list.get(j).getNrPikeveShoferit()){
                        shofer = list.get(j);
                    }
                    if(shofer.getNrPikeveShoferit() == list.get(j).getNrPikeveShoferit()){
                        if(shofer.getSaHereVendi1() < list.get(j).getSaHereVendi1()){
                            shofer = list.get(j);

                        }
                    }
                }
            }
            sortedList.add(shofer);
        }

        return sortedList;

    }

    //Sort list of shofer 'descending'
    public static List<ShoferiFormula1> ascendingOrderByPoints(List<ShoferiFormula1> list){
        List<ShoferiFormula1> sortedList = new ArrayList<ShoferiFormula1>();

        for(int i = 0; i < list.size(); i++){
            ShoferiFormula1 shofer = list.get(i);
            for(int j = 0; j < list.size(); j++){
                if(i != j){
                    if(shofer.getNrPikeveShoferit() > list.get(j).getNrPikeveShoferit()){
                        shofer = list.get(j);
                    }

                    if(shofer.getNrPikeveShoferit() == list.get(j).getNrPikeveShoferit()){
                        if(shofer.getSaHereVendi1() < list.get(j).getSaHereVendi1()){
                            shofer = list.get(j);

                        }
                    }
                }
            }
            sortedList.add(shofer);
        }

        return sortedList;

    }

/*
Return true if ekipi is not linked to any other shofer
 */
    public static boolean checkIfEkipIsNotSetToShofer(String ekipi, List<ShoferiFormula1> actualShoferiList){

       for(int i = 0;i< actualShoferiList.size(); i++){
           if(actualShoferiList.get(i).getEkipiShoferit().equals(ekipi)){
               return true;
           }
       }
       return false;
    }

}
