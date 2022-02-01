package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsCreator implements ActionListener {

    JPanel panel;
    JButton button1,button2,button3,button4,button5,button6,button7;
    public ButtonsCreator(JPanel panel){
        this.panel = panel;
        button1 = new JButton("Zgjedhja1");
        button1.addActionListener(this);
        button2 = new JButton("Zgjedhja2");
        button2.addActionListener(this);
        button3 = new JButton("Zgjedhja3");
        button3.addActionListener(this);
        button4 = new JButton("Zgjedhja4");
        button4.addActionListener(this);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1)
        {
            GUIDritareKryesore.frame.add(Zgjedhja1.createTable());
            GUIDritareKryesore.removeComponent(this.panel);

        }
        else if(e.getSource() == button2) {
            //thirret konstruktori i klases perkatese
        }
        else if(e.getSource() == button2) {
            //thirret konstruktori i klases perkatese
        }
        else if(e.getSource() == button3) {
            new Zgjedhja3();
        }
        else if(e.getSource() == button4) {
            //thirret konstruktori i klases perkatese
        }
        else if(e.getSource() == button5) {
            //thirret konstruktori i klases perkatese
        }
        else if(e.getSource() == button6) {
            //thirret konstruktori i klases perkatese
        }
        else if(e.getSource() == button7) {
            //thirret konstruktori i klases perkatese
        }
    }
}
