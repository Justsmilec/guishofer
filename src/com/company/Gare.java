/*
	Kjo klase eshte ndertuar per te stimuluar nje gare.
	Ne gare do te marrin pjese nje liste me shofere dhe ne fund te gares
	rezultatet merren dhe updatohen te dhenat e shofereve qe moren pjese ne gare.

 */
package com.company;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gare {
	
	public static Date dateOfRace;
	public static ShoferiFormula1[] startRace(List<ShoferiFormula1> shoferiList){
		dateOfRace = new Date();
		System.out.println("Starting game...");
		
		List<Integer> raceRanking = new ArrayList<>();
		int max = shoferiList.size();
		int min = 1;
		while(raceRanking.size() < max) {
			int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

			if(!raceRanking.contains(random_int)) {
				raceRanking.add(random_int);
			    
			}
			
		}
				

		List<ShoferiFormula1> afterRaceList = new ArrayList<>();
		for(int i = 0; i < raceRanking.size();i++) { 
			ShoferiFormula1 shoferToUpdate = shoferiList.get(raceRanking.get(i)-1);
			afterRaceList.add(updateAfterRace(shoferToUpdate, i + 1));
			//FileWriter.updateShoferiOnFile(Constants.SHOFER_FILE_PATH,shoferToUpdate);
		}

		ShoferiFormula1[] newListShofer = new ShoferiFormula1[afterRaceList.size()];
		for(int i = 0; i < afterRaceList.size(); i++) {
			newListShofer[i] = afterRaceList.get(i);
		}
		return newListShofer;
		
	}
	
	
	public static ShoferiFormula1 updateAfterRace(ShoferiFormula1 shoferi, int vendiNeGare) {
		
		if(vendiNeGare == 1 ) {
			shoferi.setSaHereVendi1(shoferi.getSaHereVendi1() + 1);
		} 
		if(vendiNeGare == 2 ) {
			shoferi.setSaHereVendi2(shoferi.getSaHereVendi2() + 1);
		} 
		if(vendiNeGare == 3 ) {
			shoferi.setSaHereVendi3(shoferi.getSaHereVendi3() + 1);
		} 
		
		/* Update points for each shofer */
		shoferi.setNrPikeveShoferit(shoferi.getNrPikeveShoferit() + returnPointsPerRace(vendiNeGare));
		shoferi.setNrGaraveNeSezon(shoferi.getNrGaraveNeSezon() + 1);

		return shoferi;
	}
	
//	1:25 2:18 3:15 4:12 5:10 6:8 7:6 8:4 9:2 10:1

	public static int returnPointsPerRace(int pozicion) {
		
		switch(pozicion) {
		  case 1:
		    return 25;
		  case 2:
		    return 18;
		  case 3:
			return 15;
		  
		  case 4:
			return 12;
		  case 5:
		    return 10;
		  case 6:
		    return 8;
		  case 7:
		    return 6;
		  case 8:
		    return 4;
		  case 9:
		    return 2;
		  case 10:
		    return 1;
		  default:
		    // code block
		  return 0;
		}
		
		

		
	}

}

















