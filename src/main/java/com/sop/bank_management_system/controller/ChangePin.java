package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;

public class ChangePin extends JFrame implements ActionListener{
	JButton back,changePin;
	JTextField pfield,changepfield;
	String card;
	ChangePin(String card){
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		
		JLabel text = Display.createText("Change Your PIN", 16, 270, 330, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		JLabel p = Display.createText("Enter your new Pin", 16, 180, 370, 700, 35);
		p.setForeground(Color.WHITE);
		label.add(p);
		pfield = Display.createTextField(330, 370, 180, 25);
		label.add(pfield);
		
		JLabel changep = Display.createText("Re-Enter your Pin", 16, 180, 410, 700, 35);
		changep.setForeground(Color.WHITE);
		label.add(changep);
		changepfield = Display.createTextField(330, 410, 180, 25);
		label.add(changepfield);
		
		
		changePin = Display.createButton("Change Pin", 355, 530, 150, 30,true);
		label.add(changePin);
		changePin.addActionListener(this);
		
		back = Display.createButton("Back", 355, 565, 150, 30,true);
		label.add(back);
		back.addActionListener(this);

		
		setLayout(null);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(card).setVisible(true);
			
		}
		else if(e.getSource()==changePin){
			String p=pfield.getText();
			String cp = changepfield.getText();
			if(p.equals(cp)) {
				Dao.changePin(card, p);
				JOptionPane.showMessageDialog(null, "Pin has been changed");
			}
			else {
				JOptionPane.showMessageDialog(null, "Your entered pin is mismatch");
			}
		}
	}

}
