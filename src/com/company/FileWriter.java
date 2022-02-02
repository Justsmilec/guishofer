/*
In this class i have implmented every method for file Handler, save update delete read.

 */
package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {
	
	public static void saveShoferOnFile(String fileName,ShoferiFormula1 shoferi) throws ClassNotFoundException, IOException {
		List<ShoferiFormula1> actualShoferiList = new ArrayList<>();
		try {
			actualShoferiList = readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		actualShoferiList.add(shoferi);

		try (FileOutputStream fos = new FileOutputStream(fileName,false);
			     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			    // write object to file
			    oos.writeObject(actualShoferiList);

			} catch (IOException ex) {
			    ex.printStackTrace();
			}
	}

	public static boolean deleteShoferOnFile(String fileName,List<ShoferiFormula1> actualShoferiList) throws ClassNotFoundException, IOException {

		try (FileOutputStream fos = new FileOutputStream(fileName,false);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// write object to file
			oos.writeObject(actualShoferiList);
			return true;

		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateShoferiOnFile(String fileName, ShoferiFormula1 shoferiToUpdate) throws ClassNotFoundException, IOException {
		List<ShoferiFormula1> actualShoferiList = new ArrayList<>();
		try {
			actualShoferiList = readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ShoferiFormula1 shoferi = actualShoferiList.stream().filter(item -> item.getId().equals(shoferiToUpdate.getId())).findFirst().get();
		if(shoferi != null){
			actualShoferiList.remove(shoferi);
			actualShoferiList.add(shoferiToUpdate);
		}


		try (FileOutputStream fos = new FileOutputStream(fileName,false);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			// write object to file
			oos.writeObject(actualShoferiList);
			return true;

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static List<ShoferiFormula1> readFile(String fileName) throws IOException, ClassNotFoundException{
		List<ShoferiFormula1> shoferiList = new ArrayList<>();

		FileInputStream fis = new FileInputStream(fileName);

        ObjectInputStream readStream = new ObjectInputStream(fis);
        shoferiList = (ArrayList<ShoferiFormula1>) readStream.readObject();
        readStream.close();
		fis.close();
		if(shoferiList != null)
			return shoferiList;
		return new ArrayList<ShoferiFormula1>();
		
	}

}
