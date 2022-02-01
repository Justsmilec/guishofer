package com.company;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class Zgjedhja3 {

    public static void main(String[] args) {
        new Zgjedhja3();
    }

    public static ShoferiFormula1[] RenditjaSipasVendit1(ShoferiFormula1[] shofer) {

        ShoferiFormula1 temp;

        for(int i=0;i<shofer.length;i++) {
            for(int j=i+1; j<shofer.length;j++) {
                if(shofer[j].getSaHereVendi1() > shofer[i].getSaHereVendi1()) {
                    temp = shofer[i];
                    shofer[i] = shofer[j];
                    shofer[j] = temp;
                }
            }
        }

        return shofer;
    }


    JFrame frame;
    JTable table;

    Zgjedhja3(){
        frame = new JFrame();
        frame.setTitle("Tabela e shofereve");
        //frame.setBackgroundColor()
        TestMain test = new TestMain();
        ShoferiFormula1[] shofer = test.loadShofer(test.returnNumberOfLinesOfFile());
        ShoferiFormula1[] shoferRenditur = RenditjaSipasVendit1(shofer);

        //mban emrat e kolonave
        String[] columnsNames= {"Emri","Pozicioni","Ekipi","Sa here vendi 1", "Sa here vendi 2",
                "Sa here vendi 3","Nr.pikeve","Nr.Garave pjesmarres"};

        //mban te dhenat e shofereve ne 2d array ku si nr rreshtash do jete nr shofereve dhe
        //si nr kolonave do jete sa llojet e te dhenave
        String[][] shoferData = new String[test.returnNumberOfLinesOfFile()][8];



        //vendosja e te dhenave te shofereve si string
        for(int i = 0; i < shoferData.length; i++ ) {

            shoferData[i][0] = shoferRenditur[i].getEmriShoferit();
            shoferData[i][1] = Integer.toString(shoferRenditur[i].getPozicioniShoferit());
            shoferData[i][2] = shoferRenditur[i].getEkipiShoferit();
            shoferData[i][3] = Integer.toString(shoferRenditur[i].getSaHereVendi1());
            shoferData[i][4] = Integer.toString(shoferRenditur[i].getSaHereVendi2());
            shoferData[i][5] = Integer.toString(shoferRenditur[i].getSaHereVendi3());
            shoferData[i][6] = Integer.toString(shoferRenditur[i].getNrPikeveShoferit());
            shoferData[i][7] = Integer.toString(shoferRenditur[i].getNrGaraveNeSezon());


        }


        TableModel model = new DefaultTableModel(shoferData,columnsNames);
        JTable table = new JTable(model);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(table));

        frame.add(panel);
        frame.setSize(1000,400);
        frame.setVisible(true);
    }
}
