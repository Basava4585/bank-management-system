package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;
import com.sop.bank_management_system.entity.Bank;

public class MiniStatement extends JFrame implements ActionListener{
	String card;
	JButton back;
	Long balance;
	MiniStatement(String card){
		this.card=card;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		balance=Dao.getAmount(card);
		JLabel text = Display.createText("Your last 5 trasaction are: ", 16, 180, 330, 700, 35);
		text.setForeground(Color.WHITE);
		label.add(text);
		JLabel title = Display.createText("Date         "+ "   Type     "+ " amount", 16, 180, 360, 700, 35);
		title.setForeground(Color.WHITE);
		label.add(title);
		List<Bank> statement = Dao.getMiniStatement(card);
		int i=30;
		for(Bank bank:statement) {
			JLabel record = Display.createText(bank.getDate()+"  "+ bank.getType()+"  "+ bank.getAmount()+"  ", 16, 180, 360+i, 700, 35);
			record.setForeground(Color.WHITE);
			label.add(record);
			i+=30;
		}
		
		
		
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
