package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;

public class BalanceEnquiry extends JFrame implements ActionListener{
	String card;
	JButton back;
	Long balance;
	BalanceEnquiry(String card){
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		balance=Dao.getAmount(card);
		JLabel text = Display.createText("Your curent balance is Rs: "+ balance, 16, 180, 430, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
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
		setVisible(false);
		new Transactions(card).setVisible(true);;
		
	}

}
