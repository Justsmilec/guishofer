package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Ben implements Action Listener per te vendosur nje action ne butonat e shtypur
public class Zgjedhja4 implements ActionListener {
    public static void main(String[] args) {
        new Zgjedhja4();
    }


    JPanel topPanel; //paneli qe do mbaje buttonat startgame and showresultOfRace
    JButton buttonStartGame, buttonShowResultsOfRace;

    JPanel bottomPanel; //paneli qe do te mbaje tabelen e rezulateteve per garen

    /*
    Nese shtyp start game shfaqet dhe butoni show rezultatet. Butoni start game behet Restart Game dhe kur shtypim restart game fshijme butoninin show results
     */
    boolean isVisibleButtonShowResultsOfRace = false; // per te kontrolluar nese e kemi shtypur start game apo jo sepse nuk mund te hapim tabelen e rezultateve pa patur nje gare.

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
    JProgressBar b;
    ShoferiFormula1[] shofer;
    Formula1MenaxhimKampionati f1;
    public Zgjedhja4(){
        frame = new JFrame(); //Krijimi i frames kur shtypim zgjedhja 4
        frame.setTitle("Gjenerimi i gares");
        //frame.setBackgroundColor()
        TestMain test = new TestMain();
        f1 = new Formula1MenaxhimKampionati();
        shofer = test.loadShofer(test.returnNumberOfLinesOfFile());
        ShoferiFormula1[] shoferRenditur = RenditjaSipasVendit1(shofer);

        JPanel panel = new JPanel(new GridLayout(2,0));
        panel.setLayout(null);

        panel.add(this.createTopPanel()); //paneli qe do te kthehet nga metoda createTopPanel shtohet ne panel
        panel.add(this.createBottomPanel());
        frame.add(panel);
        frame.setSize(1000,400);
        frame.setVisible(true);

    }


    //Metoda qe kthen panelin ne header qe do te mbaje 2 butonat
    public JPanel createTopPanel() {
        this.topPanel = new JPanel();
        this.topPanel.setSize(1000,60);

        /*
        Add jButton to startGame
         */
        buttonStartGame = new JButton("Start Game");
        buttonStartGame.setSize(200,20);
        buttonStartGame.addActionListener(this);

        buttonShowResultsOfRace = new JButton("Race Results");
        buttonShowResultsOfRace.setSize(200,20);
        buttonShowResultsOfRace.addActionListener(this);
        buttonShowResultsOfRace.setVisible(isVisibleButtonShowResultsOfRace);


        this.topPanel.add(buttonStartGame);
        this.topPanel.add(buttonShowResultsOfRace);

        return this.topPanel;
    }


    public JPanel createBottomPanel(){
        this.bottomPanel = new JPanel();
        this.bottomPanel.setBounds(0,60,1000,340);

        return this.bottomPanel;
    }

    public ShoferiFormula1[] startGame(){
        List<ShoferiFormula1> actualShoferiList = new ArrayList<ShoferiFormula1>();
        for(int i = 0;i < this.shofer.length; i++){
            actualShoferiList.add(this.shofer[i]);
        }

        //fshin te gjithe komponentet qe ndodhen ne panelin e poshtem, ne rastin tone fshin tabelen e rezulatateve
        this.bottomPanel.removeAll();

        //kontrollojm se kur do te behet startRace dhe kur jo.
        if(!isVisibleButtonShowResultsOfRace){
            f1.ruajtjeNeFile(Gare.startRace(actualShoferiList));
            this.buttonStartGame.setText("Restart Game");
            this.isVisibleButtonShowResultsOfRace = !this.isVisibleButtonShowResultsOfRace;

        } else{
            this.isVisibleButtonShowResultsOfRace = !this.isVisibleButtonShowResultsOfRace;

            this.buttonStartGame.setText("Start Game");
        }

        // Mbas cdo ndyshimi ne panel behet edhe rivalidimi ne menyre qe te updatoje pamjen dhe te merren ndurshimet e reja .

        this.bottomPanel.validate();
        this.bottomPanel.repaint();
        buttonShowResultsOfRace.setVisible(isVisibleButtonShowResultsOfRace);
        return null;
    }

    //Ben shfaqjen e tabeles se rezulateve per garen aktuale dhe daten aktuale
    public void showResultsOfMatch(){
        String[] columnsNames= {"Emri","Pozicioni","Ekipi","Sa here vendi 1", "Sa here vendi 2",
                "Sa here vendi 3","Nr.pikeve","Nr.Garave pjesmarres"};

        //mban te dhenat e shofereve ne 2d array ku si nr rreshtash do jete nr shofereve dhe
        //si nr kolonave do jete sa llojet e te dhenave
        String[][] shoferData = new String[Gare.positions.size()][8];

        //vendosja e te dhenave te shofereve si string
        for(int i = 0; i < shoferData.length; i++ ) {

            shoferData[i][0] = Gare.positions.get(i).getEmriShoferit();
            shoferData[i][1] = ""+(i+1);
            shoferData[i][2] = Gare.positions.get(i).getEkipiShoferit();
            shoferData[i][3] = Integer.toString(Gare.positions.get(i).getSaHereVendi1());
            shoferData[i][4] = Integer.toString(Gare.positions.get(i).getSaHereVendi2());
            shoferData[i][5] = Integer.toString(Gare.positions.get(i).getSaHereVendi3());
            shoferData[i][6] = Integer.toString(Gare.positions.get(i).getNrPikeveShoferit());
            shoferData[i][7] = Integer.toString(Gare.positions.get(i).getNrGaraveNeSezon());


        }

        TableModel model = new DefaultTableModel(shoferData,columnsNames);
        JTable table = new JTable(model);
        table.setPreferredSize(new Dimension(500,500));
        table.setBackground(Color.yellow);
        this.bottomPanel.removeAll();
        if(isVisibleButtonShowResultsOfRace){
            this.bottomPanel.add(new JLabel(Gare.dateOfRace.toString()));
            this.bottomPanel.add(new JScrollPane(table));
        }

        this.bottomPanel.validate();
        this.bottomPanel.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.buttonStartGame){
            //Start game method
            startGame();
        }else if(e.getSource() == this.buttonShowResultsOfRace){
            showResultsOfMatch();
        }
    }
}
