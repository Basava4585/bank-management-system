package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;
import com.sop.bank_management_system.entity.Bank;

public class Withdraw extends JFrame implements ActionListener{
	JTextField amount;
	String card;
	JButton withdraw,back;
	Withdraw(String card) {
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);

		JLabel text = Display.createText("Enter the amount you want to withdraw", 16, 180, 330, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		
		amount = Display.createTextField(180, 380, 300, 25);
		label.add(amount);
		
		withdraw = Display.createButton("withdraw", 355, 485, 150, 30,true);
		label.add(withdraw);
		withdraw.addActionListener(this);
		
		back = Display.createButton("Back", 355, 520, 150, 30,true);
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
		if(e.getSource()==withdraw) {
			long number;
			if(amount.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Enter amount to withdraw");
				number=0;
			}
			else {
			number=Long.parseLong(amount.getText());
			Date date=new Date(System.currentTimeMillis());
			String type="withdraw";
			Bank bank = new Bank();
			bank.setAmount(number);
			bank.setCard(card);
			bank.setDate(date);
			bank.setType(type);
			boolean b = Dao.saveBankDetail(bank);
			boolean b2 = Dao.withdraw(card, number);
			if(b && b2) {
				JOptionPane.showMessageDialog(null,"amount withdrawed: "+ number);
			}
			else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			}
			}
			
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Transactions(card).setVisible(true);
		}
		
	}
}
