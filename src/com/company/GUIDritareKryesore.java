package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDritareKryesore {
	
	public static void main(String[] args) {
		new GUIDritareKryesore();
	}
	
	JButton button1,button2,button3,button4,button5,button6,button7;
	public static JFrame frame;
	//constructor
	GUIDritareKryesore(){
		frame = new JFrame();
		frame.setTitle("FORMULA 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);

		MainPanel mainPanel = new MainPanel();
		frame.add(mainPanel.createMainPanel(frame.getWidth(), frame.getHeight()));
		frame.setVisible(true);
		
	}

	public static void removeComponent(JComponent component){
		GUIDritareKryesore.frame.remove(component);
		GUIDritareKryesore.frame.invalidate();
		GUIDritareKryesore.frame.validate();
		GUIDritareKryesore.frame.repaint();
	}






}
