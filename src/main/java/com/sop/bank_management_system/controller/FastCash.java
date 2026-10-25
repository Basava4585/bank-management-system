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

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;

public class FastCash extends JFrame implements ActionListener{
	JButton rs100,rs200,rs500,rs1000,rs10000,rs5000,exit;
	String card;
	FastCash(String card){
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0, 900,900);
		add(label);
		
		JLabel text = Display.createText("Select Withdrawl Amount",16,210, 330, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		rs100 = Display.createButton("Rs 100", 170,460, 150,30,true);
		rs100.addActionListener(this);
		label.add(rs100);
		
		rs200 = Display.createButton("Rs 200", 355,460, 150,30,true);
		rs200.addActionListener(this);
		label.add(rs200);
		
		rs500 = Display.createButton("Rs 500", 170,495, 150,30,true);
		rs500.addActionListener(this);
		label.add(rs500);
		
		rs1000 = Display.createButton("Rs 1000", 355,495, 150,30,true);
		rs1000.addActionListener(this);
		label.add(rs1000);
		
		rs5000 = Display.createButton("Rs 5000", 170,530, 150,30,true);
		rs5000.addActionListener(this);
		label.add(rs5000);
		
		rs10000 = Display.createButton("Rs 10000", 355,530, 150,30,true);
		rs10000.addActionListener(this);
		label.add(rs10000);
		
	    exit = Display.createButton("Back", 355,565, 150,30,true);
	    exit.addActionListener(this);
		label.add(exit);
		
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(card).setVisible(true);
		}
		else if(e.getSource()==rs100){
			boolean b = Dao.withdraw(card, 100l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 100);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
		}
		else if(e.getSource()==rs200) {
			boolean b = Dao.withdraw(card, 200l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 200);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
			
		}
		else if(e.getSource()==rs500){
			boolean b = Dao.withdraw(card, 500l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 500);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
		}
		else if(e.getSource()==rs1000) {
			boolean b = Dao.withdraw(card, 1000l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 1000);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
			
		}
		else if(e.getSource()==rs5000) {
			boolean b = Dao.withdraw(card, 5000l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 5000);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
			
		}
		else if(e.getSource()==rs10000) {
			boolean b = Dao.withdraw(card, 10000l);
			if(b) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ 10000);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
			
		}
		
	}
}
