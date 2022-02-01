package com.company;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Zgjedhja1 {



	public static JPanel createTable(){
		TestMain test = new TestMain();
		ShoferiFormula1[] shofer = test.loadShofer(test.returnNumberOfLinesOfFile());

		//mban emrat e kolonave
		String[] columnsNames= {"Emri","Pozicioni","Ekipi","Sa here vendi 1", "Sa here vendi 2",
				"Sa here vendi 3","Nr.pikeve","Nr.Garave pjesmarres"};

		//mban te dhenat e shofereve ne 2d array ku si nr rreshtash do jete nr shofereve dhe
		//si nr kolonave do jete sa llojet e te dhenave
		String[][] shoferData = new String[test.returnNumberOfLinesOfFile()][8];

		//vendosja e te dhenave te shofereve si string
		for(int i = 0; i < shoferData.length; i++ ) {

			shoferData[i][0] = shofer[i].getEmriShoferit();
			shoferData[i][1] = Integer.toString(shofer[i].getPozicioniShoferit());
			shoferData[i][2] = shofer[i].getEkipiShoferit();
			shoferData[i][3] = Integer.toString(shofer[i].getSaHereVendi1());
			shoferData[i][4] = Integer.toString(shofer[i].getSaHereVendi2());
			shoferData[i][5] = Integer.toString(shofer[i].getSaHereVendi3());
			shoferData[i][6] = Integer.toString(shofer[i].getNrPikeveShoferit());
			shoferData[i][7] = Integer.toString(shofer[i].getNrGaraveNeSezon());


		}


		TableModel model = new DefaultTableModel(shoferData,columnsNames);
		JTable table = new JTable(model);

		JPanel panel = new JPanel();
		panel.add(new JScrollPane(table));
		return panel;
	}

	
	
}
