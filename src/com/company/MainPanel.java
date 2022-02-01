package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel  {
    JButton button1,button2,button3,button4,button5,button6,button7;

    JPanel panel;
    public JPanel createMainPanel(int width,int height){
        this.panel = new JPanel();
        panel.setSize(width, height);
        this.setButtons();
        //Set whatever you want to be inside this main panel
        return panel;

    }

    public void setButtons(){
        new ButtonsCreator(this.panel);
    }


}
