package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class GUIDritareKryesore implements ActionListener{
	
	public static void main(String[] args) {
		new GUIDritareKryesore();
	}
	
	JButton button1,button2,button3,button4,button5,button6,button7;
	JFrame frame;
	//constructor
	GUIDritareKryesore(){
		
		frame = new JFrame();
		frame.setTitle("FORMULA 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);
		frame.setLayout(new GridLayout(7,1));
 
		button1 = new JButton();
		button1.setText("Tabela dhe statistikat e shofereve ne rend zbrites");
		button1.setFocusable(false);
		frame.add(button1);
		button1.addActionListener(this);
		
		button2 = new JButton("Renditja e tabeles sipas pikeve te shoferit"); //rend zbrites
		frame.add(button2);
		button2.addActionListener(this);
		
	    button3 = new JButton("Renditja sipas numrit me te madh te vendit te pare te fituar ne gara"); //rend zbrites
		frame.add(button3);
		button3.addActionListener(this);
		
		button4 = new JButton("Gjeneroni nje gare");
		frame.add(button4);
		button4.addActionListener(this);
		
		button5 = new JButton("Shtoni modifikime ne gjenerimin e gares");
		frame.add(button5);
		button5.addActionListener(this);
		
		button6 = new JButton("Shfaqja e garave sipas datave");
		frame.add(button6);
		button6.addActionListener(this);
		
		button7 = new JButton("Garat ku ka marr pjese nje shofer");
		frame.add(button7);
		button7.addActionListener(this);
		
		frame.setVisible(true);
		
	}
	
		@Override
	public void actionPerformed(ActionEvent e) {

			if(e.getSource() == button1)
				new Zgjedhja1();
			
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
				new Zgjedhja4();

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
