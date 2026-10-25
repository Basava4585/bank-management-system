package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sop.bank_management_system.dao.Display;

public class Transactions extends JFrame implements ActionListener{
	JButton deposit,withdraw,fastcash,miniStatement,pinChange,balanceEnquiry,exit;
	String card;
	Transactions(String card){
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0, 900,900);
		add(label);
		
		JLabel text = Display.createText("Please select your Transaction",16,210, 330, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		deposit = Display.createButton("deposit", 170,460, 150,30,true);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdraw = Display.createButton("Cash Withdrawl", 355,460, 150,30,true);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		fastcash = Display.createButton("Fast Cash", 170,495, 150,30,true);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		miniStatement = Display.createButton("Mini Statement", 355,495, 150,30,true);
		miniStatement.addActionListener(this);
		label.add(miniStatement);
		
		pinChange = Display.createButton("Pin change", 170,530, 150,30,true);
		pinChange.addActionListener(this);
		label.add(pinChange);
		
		balanceEnquiry = Display.createButton("Balance Enquiry", 355,530, 150,30,true);
		balanceEnquiry.addActionListener(this);
		label.add(balanceEnquiry);
		
	    exit = Display.createButton("Exit", 355,565, 150,30,true);
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
			System.exit(0);
		}
		else if(e.getSource()==deposit){
			setVisible(false);
			new Deposit(card).setVisible(true);
		}
		else if(e.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(card).setVisible(true);
			
		}
		else if(e.getSource()==fastcash){
			setVisible(false);
			new FastCash(card).setVisible(true);
		}
		else if(e.getSource()==miniStatement) {
			setVisible(false);
			new MiniStatement(card).setVisible(true);
		}
		else if(e.getSource()==pinChange) {
			setVisible(false);
			new ChangePin(card).setVisible(true);;
		}
		else if(e.getSource()==balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(card).setVisible(true);
		}
		
	}
}
