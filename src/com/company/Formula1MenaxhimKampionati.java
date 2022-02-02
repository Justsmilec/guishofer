package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.util.stream.Collectors;

public class Formula1MenaxhimKampionati implements MenaxhimKampionati {

	private int nrShofereve;

	
	public Formula1MenaxhimKampionati(int nrShofereve) {
		this.nrShofereve = nrShofereve;
	}

	public Formula1MenaxhimKampionati() {

	}

	public int getNrShofereve() {
		return nrShofereve;
	}

	public void setNrShofereve(int nrShofereve) {
		this.nrShofereve = nrShofereve;
	}
	public void menu() {
		System.out.println("  \n\n\n\n\n\n     							MENU				                                   "
				+ "\n		||=============================================================================================||"
				+ "\n		||1-Shtoni nje shofer te ri ne kampionat ne nje skuader unike.                                 ||"
				+ "\n		||2-Fshini nje shofer dhe skuadren ne te cilen ai ben pjese.                                   ||"
				+ "\n		||3-Ndryshoni nje shofer ne nje skuader ekzistuese.                                            ||"
				+ "\n		||4-Shfaqni statistikat e nje shoferi.                                                         ||"
				+ "\n		||5-Shfaqni Tabelen e Shofereve Te Formules 1.                                                 ||"
				+ "\n		||6-Shtoni nje gare te perfunduar duke modifikuar statistikat e shofereve perkates pas gares.  ||"
				+ "\n		||7-Ruani te dhenat e shofereve ne file.                                                       ||"
				+ "\n		||8-Rikuperimi i gjendjes se meparshme.                                                        ||"
				+ "\n		||0-Dilni nga programi.                                                                        ||"
				+ "\n		||=============================================================================================||");
	}



	//B
	public void shtimShoferi(ShoferiFormula1[] shoferList) {
		Scanner input = new Scanner(System.in);

		List<ShoferiFormula1> actualShoferiList = new ArrayList<ShoferiFormula1>();
		for(int i = 0;i < shoferList.length; i++){
			actualShoferiList.add(shoferList[i]);
		}
		System.out.println("Ju lutem jepni numrin e shofereve qe do te marrin pjese ne kampionat paraprakisht: ");
		int nrShofereve = input.nextInt();
		// vektori shoferLista do te mbaje te dhenat e shofereve
		ShoferiFormula1[] shofer = new ShoferiFormula1[nrShofereve];

		String emri, ekipi;
		int pozicioni;

		// marr te statistikat e shoferit
		for (int i = 0; i < shofer.length; i++) {

			System.out.println("Te dhenat per shoferin " + (i + 1) + ": \n");
			System.out.println("Emri:");
			emri = input.next();

			System.out.println("Pozicioni aktual: ");
			pozicioni = input.nextInt();

			System.out.println("Ekipi: ");
			ekipi = input.next();
			/*
			Check if ekipi is not linked to any other shofer
			 */
			boolean checkEkip = Helper.checkIfEkipIsNotSetToShofer(ekipi, Arrays.asList(shoferList.clone()));
			while(checkEkip){
				System.out.println("Jepni perseri emrin e ekipit: ");
				ekipi = input.next();
				checkEkip = Helper.checkIfEkipIsNotSetToShofer(ekipi,Arrays.asList(shoferList.clone()));
			}
			// i vendos te dhenat tek shoferi perkates
			nrShofereve++;
			shofer[i] = new ShoferiFormula1(null,emri, pozicioni, ekipi);
			actualShoferiList.add(shofer[i]);
		}
		//Pasi kemi shoferet e ri te shtuar bejn save ate ne file.
		ShoferiFormula1[] newListShofer = new ShoferiFormula1[actualShoferiList.size()];
		for(int i = 0; i < actualShoferiList.size(); i++) {
			newListShofer[i] = actualShoferiList.get(i);
		}
		this.ruajtjeNeFile(newListShofer);

	}

	//B
	public void fshirjeShoferi(ShoferiFormula1[] shofer) {

		Scanner input = new Scanner(System.in);
		String name, ekipi;

		System.out.println("Emri:");
		name = input.next();

		System.out.println("Ekipi: ");
		ekipi = input.next();
		/*Delete by name and ekipi*/
		List<ShoferiFormula1> actualShoferiList = new ArrayList<ShoferiFormula1>();
		for(int i = 0;i < shofer.length; i++){
			actualShoferiList.add(shofer[i]);
		}

		actualShoferiList = actualShoferiList.stream().filter(item ->
				!item.getEkipiShoferit().equals(ekipi) && !item.getEmriShoferit().equals(name)).collect(Collectors.toList());

		//actuar ShoferList is the list after deleting shofer from list
		//save the list on the file.
		/*
			Convert list to array
		 */
		ShoferiFormula1[] newListShofer = new ShoferiFormula1[actualShoferiList.size()];
		for(int i = 0; i < actualShoferiList.size(); i++) {
			newListShofer[i] = actualShoferiList.get(i);
		}

		this.ruajtjeNeFile(newListShofer);

	}

	//B
	public void ndryshimShoferi(ShoferiFormula1[] shofer) {
		Scanner input = new Scanner(System.in);
		String name, ekipi;
		String newName, newEkipi;

		System.out.println("Emri:");
		name = input.next();

		System.out.println("Ekipi: ");
		ekipi = input.next();
		/*Delete by name and ekipi*/
		List<ShoferiFormula1> actualShoferiList = new ArrayList<ShoferiFormula1>();
		for(int i = 0;i < shofer.length; i++){
			actualShoferiList.add(shofer[i]);
		}
		ShoferiFormula1 shoferiToUpdate = actualShoferiList.stream().filter(item ->
				item.getEkipiShoferit().equals(ekipi) && item.getEmriShoferit().equals(name)).findFirst().get();


		if(shoferiToUpdate != null){
			System.out.println("Emri i ri:");
			newName = input.next();

			System.out.println("Ekipi i ri: ");
			newEkipi = input.next();
			boolean checkEkip = Helper.checkIfEkipIsNotSetToShofer(newEkipi,Arrays.asList(shofer.clone()));
			while(checkEkip){
				System.out.println("Jepni perseri emrin e ekipit: ");
				newEkipi = input.next();
				checkEkip = Helper.checkIfEkipIsNotSetToShofer(newEkipi,Arrays.asList(shofer.clone()));
			}
			shoferiToUpdate.setEmriShoferit(newName);
			shoferiToUpdate.setEkipiShoferit(newEkipi);
			actualShoferiList.add(shoferiToUpdate);
		} else{
			System.out.println(" NUK U GJEND ");
		}

		ShoferiFormula1[] newListShofer = new ShoferiFormula1[actualShoferiList.size()];
		for(int i = 0; i < actualShoferiList.size(); i++) {
			newListShofer[i] = actualShoferiList.get(i);
		}
		//Bej updattimin ne file.
		this.ruajtjeNeFile(newListShofer);
	}

	//R
	public void shfaqjaStatistikavePerNjeShofer(ShoferiFormula1[] shofer) {
		for(int i = 0; i<shofer.length; i++) {
			System.out.println("Keto jane statistikat per shoferin: " + shofer[i].getEmriShoferit() + " i ekipit: "
					+ shofer[i].getEkipiShoferit());
			System.out.println("Numri i pikeve: " + shofer[i].getNrPikeveShoferit());
			System.out.println("Pozicioni: " + shofer[i].getPozicioniShoferit());
			System.out.println("Sa here ka qene ne vend te pare: " +shofer[i].getSaHereVendi1());
			System.out.println("Sa here ka qene ne vend te dyte: " +shofer[i].getSaHereVendi2());
			System.out.println("Sa here ka qene ne vend te trete: " +shofer[i].getSaHereVendi3());
			System.out.println("Numri i garave ne sezon: " + shofer[i].getNrGaraveNeSezon());
			System.out.println("");
			System.out.println("		***");
		}
	}

	//K
	public void shfaqjaTabelesSeShofereve(ShoferiFormula1[] shofer) {


		//shoferList = Helper.descendingOrderByPoints(shoferList);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%17s %20s %20s %15s %10s %10s %10s %10s %10s","ID", "EMRI", "EKIPI", "Pozicioni", "Nr.vendi1", "Nr.vendi2", "Nr.vendi3", "NrPikeve", "NrGarave");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

		for(int i = 0; i < shofer.length; i++){
			shofer[i].afishimiTabeles();
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

	}

	//K+B
	public void shtimiNjeGare_ModifikimIStatistikave(ShoferiFormula1[] shofer) {

		List<ShoferiFormula1> actualShoferiList = new ArrayList<ShoferiFormula1>();
		for(int i = 0;i < shofer.length; i++){
			actualShoferiList.add(shofer[i]);
		}		//ShoferList is the list passed to start the race and to be upodated
		this.ruajtjeNeFile(Gare.startRace(actualShoferiList));
	}

	//R
	public void ruajtjeNeFile(ShoferiFormula1[] shofer)  {

		File file = new File("ListaShofer.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(toString(shofer));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//REI
	public String toString(ShoferiFormula1[] shofer) {
		String finish = "";
		for(int index = 0; index < shofer.length; index++) {    //duhet ndryshuar indeksi
			finish = finish.concat(shofer[index].getId() + ",");
			finish = finish.concat(shofer[index].getEmriShoferit() + ",");
			finish = finish.concat(Integer.toString(shofer[index].getPozicioniShoferit()) + ",");
			finish = finish.concat(shofer[index].getEkipiShoferit() + ",");
			finish = finish.concat(Integer.toString(shofer[index].getSaHereVendi1()) + ",");
			finish = finish.concat(Integer.toString(shofer[index].getSaHereVendi2()) + ",");
			finish = finish.concat(Integer.toString(shofer[index].getSaHereVendi3()) + ",");
			finish = finish.concat(Integer.toString(shofer[index].getNrPikeveShoferit()) + ",");
			finish = finish.concat(Integer.toString(shofer[index].getNrGaraveNeSezon())).concat("\n");

		}
		return finish;
	}

	//MIDJAN
	public void leximiNgaFile_ndryshimInfoEkzistuesNgaPerdoruesi(ShoferiFormula1[] shofer) {


		
		try {
			File fileObj = new File("ListaShofer.txt");

			Scanner objSk = new Scanner(fileObj);
			int index = 0;
			
			while(objSk.hasNextLine()) {

				String[] dataString = objSk.nextLine().split(",");

				//realizojme ruajtjen e secilit token/element te stringes ne variablat perkatese sipas renditjes
				//Behet dhe konvertimi i stringave ne numra per te dhenat perkatese
				
				shofer[index].setId(dataString[0]);
				shofer[index].setEmriShoferit(dataString[1]);
				shofer[index].setSaHereVendi1(Integer.parseInt(dataString[2]));
				shofer[index].setEkipiShoferit(dataString[3]);
				shofer[index].setSaHereVendi1(Integer.parseInt(dataString[4]));
				shofer[index].setSaHereVendi2(Integer.parseInt(dataString[5]));
				shofer[index].setSaHereVendi3(Integer.parseInt(dataString[6]));
				shofer[index].setNrPikeveShoferit(Integer.parseInt(dataString[7]));
				shofer[index].setNrGaraveNeSezon(Integer.parseInt(dataString[8]));
				
				index++;
			}
		} catch (FileNotFoundException e) { //nqs nuk ekziston file per shofer, nuk mund te procedohet, dhe do dali gabim, hidhet exception.
			System.out.println("File nuk gjendet!");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Ndodhi nje gabim!");
		}
		
		
		
		
		
	
	}

}