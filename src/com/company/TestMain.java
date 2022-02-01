package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class TestMain {
	static Scanner input = new Scanner(System.in);


	//metode qe kthen vektor objektesh te klases ShoferiFormula1
	public static ShoferiFormula1[] loadShofer(int nrShofereve){

		ShoferiFormula1[] shofer = new ShoferiFormula1[nrShofereve];


		//variablat qe mbajne te dhenat e shofereve e shofereve
		String emri,ekipi,id;
		int pozicioni,SaHereVendi1,SaHereVendi2,SaHereVendi3,nrPikeveShoferit,nrGaraveNeSezon;
		int index = 0; //numerues i rreshtave te file deri sa te arrihet fundi i file
		try {

			//pointeri i file-it
			File file = new File("ListaShofer.txt");  //stringa qe kalon si argument eshte path i file
			Scanner scan = new Scanner(file);

			while(scan.hasNextLine()) {

				//perdor metoden e klases String, split per te dalluar te dhenat qe duhen marre pasi ato jane te ndara me presje ne shoferfile.txt
				String[] data = scan.nextLine().split(",");

				//realizojme ruajtjen e secilit token/element te stringes ne variablat perkatese sipas renditjes
				//Behet dhe konvertimi i stringave ne numra per te dhenat perkatese
				id = data[0];
				emri = data[1];
				pozicioni = Integer.parseInt(data[2]);
				ekipi = data[3];
				SaHereVendi1 = Integer.parseInt(data[4]);
				SaHereVendi2 = Integer.parseInt(data[5]);
				SaHereVendi3 = Integer.parseInt(data[6]);
				nrPikeveShoferit = Integer.parseInt(data[7]);
				nrGaraveNeSezon = Integer.parseInt(data[8]);

				//ruajme te dhenat e shoferit tek indeksi perkates
				shofer[index] = new ShoferiFormula1(id,emri,pozicioni,ekipi);
				shofer[index].statistika(SaHereVendi1, SaHereVendi2, SaHereVendi3, nrPikeveShoferit, nrGaraveNeSezon);

				index++;
			}
			scan.close();
			//kontrollohet nqs file mund te gjendet ne te kundert hedh nje exception
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return shofer;  //kthehet vektori i objekteve te klases ShoferiFormula1

	}

	//metode qe hap file qe duam dhe kthen numrin e rreshtave qe ne kete rast do te tregoje nr e shoferve
	public static int returnNumberOfLinesOfFile(){

		Path path = Paths.get("ListaShofer.txt");
		int lines = 0;
		try {
			lines = (int) Files.lines(path).count();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	//////////main
	public static void main(String[] args) {

		Formula1MenaxhimKampionati f1 = new Formula1MenaxhimKampionati();
		f1.setNrShofereve(returnNumberOfLinesOfFile());  //vendoset nr i shofereve ne baze te rreshtave te file tekst


		while(true) {
			f1.menu(); //afishimi i menuse

			System.out.println("Zgjedhja juaj ne menu:  ");
			int zgjedhja = input.nextInt();

			//kontrolli qe zgjedhja e dhene te jete numer ndermjet 0 dhe 8 nga menuja kryesore
			if(zgjedhja >=1 && zgjedhja <=8) {
				switch(zgjedhja) {
					case 1:
						f1.shtimShoferi(loadShofer(f1.getNrShofereve()));
						f1.setNrShofereve((returnNumberOfLinesOfFile()));
						break;
					case 2: f1.fshirjeShoferi(loadShofer(f1.getNrShofereve()));
						f1.setNrShofereve(returnNumberOfLinesOfFile());
						break;
					case 3: f1.ndryshimShoferi(loadShofer(f1.getNrShofereve()));
						break;
					case 4: f1.shfaqjaStatistikavePerNjeShofer(loadShofer(f1.getNrShofereve()));
						break;
					case 5: f1.shfaqjaTabelesSeShofereve(loadShofer(f1.getNrShofereve()));
						break;
					case 6: f1.shtimiNjeGare_ModifikimIStatistikave(loadShofer(f1.getNrShofereve()));
						break;
					case 7: f1.ruajtjeNeFile(loadShofer(f1.getNrShofereve()));
						break;
					case 8: f1.leximiNgaFile_ndryshimInfoEkzistuesNgaPerdoruesi(loadShofer(returnNumberOfLinesOfFile()));
						break;

				}
			}
			else if(zgjedhja == 0) {
				System.out.println("\nSapo dolet nga programi.");
				break;
			}
		}
	}




}