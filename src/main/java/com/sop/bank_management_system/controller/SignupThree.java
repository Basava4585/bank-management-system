package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.sop.bank_management_system.connection.DatabaseManager;
import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;
import com.sop.bank_management_system.entity.AccountDetail;

public class SignupThree extends JFrame implements ActionListener{
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	long abs;
	SignupThree(long abs){
		this.abs=abs;
		JLabel accountDetail = Display.createText("Page 3: Account Details", 22, 280, 40, 400, 40);
		add(accountDetail);
		JLabel accountType = Display.createText("Account Type", 22, 100, 140, 200, 30);
		add(accountType);
		r1 = Display.createRadioButton("Saving Account", 100, 180, 150, 20);
		add(r1);
		r2 = Display.createRadioButton("Fixed deposit Account", 350, 180, 250, 20);
		add(r2);
		r3 = Display.createRadioButton("Current Account", 100, 220, 150, 20);
		add(r3);
		r4 = Display.createRadioButton("Recurring deposit Account", 350, 220, 250, 20);
		add(r4);
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(r1);
		accountGroup.add(r2);
		accountGroup.add(r3);
		accountGroup.add(r4);
		
		JLabel cardNumber = Display.createText("Card Number", 22, 100, 300, 200, 30);
		add(cardNumber);
		JLabel number = Display.createText("XXXX-XXXX-XXXX-4184", 22, 330, 300, 300, 30);
		add(number);
		JLabel cardDetail = Display.createText("Your 16 digit card number", 12, 100, 330, 200, 30);
		add(cardDetail);
		
		JLabel pin = Display.createText("PIN:", 22, 100, 370, 200, 30);
		add(pin);
		JLabel pinNumber = Display.createText("XXXX", 22, 330, 370, 300, 30);
		add(pinNumber);
		JLabel pinDetail = Display.createText("Your 4 digit password", 12, 100, 400, 300, 30);
		add(pinDetail);
		
		JLabel services = Display.createText("Services Required:", 22, 100, 450, 400, 30);
		add(services);
		c1 = Display.createCheckbox("ATM CARD", 100, 500, 200, 30);
		add(c1);
		c2 = Display.createCheckbox("INTERNET BANKING", 350, 500, 200, 30);
		add(c2);
		c3 = Display.createCheckbox("MOBILE BANKING", 100, 550, 200, 30);
		add(c3);
		c4 = Display.createCheckbox("EMAIL ALERT", 350, 550, 200, 30);
		add(c4);
		c5 = Display.createCheckbox("CHEQUE BOOK", 100, 600, 200, 30);
		add(c5);
		c6 = Display.createCheckbox("E-STATEMENT", 350, 600, 200, 30);
		add(c6);
		
		c6 = Display.createCheckbox("I hearby declares that the above entered details are correct ", 100, 680, 600, 30);
		add(c6);
		
		submit=Display.createButton("Submit",250 ,720 ,100 ,30 );
		add(submit);
		submit.addActionListener(this);
		cancel=Display.createButton("Cancel",420 ,720 ,100 ,30 );
		add(cancel);
		cancel.addActionListener(this);
		
		
		setLayout(null);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String account=null;
			if(r1.isSelected()) {
				account="Saving Account";
			}
			else if(r2.isSelected()) {
				account="Fixed deposit Account";
			}
			else if(r3.isSelected()) {
				account="Current Account";
			}
			else if(r4.isSelected()) {
				account="Recurring deposit Account";
			}
			Random ran = new Random();
			String cardNo=""+Math.abs((ran.nextLong()%90000000l) +  5040936000000000l);
			String pinNo=""+Math.abs((ran.nextLong()%9000l) +  1000l);
			String facility="";
			if(c1.isSelected()) {
				facility+=" ATM Card";
			}
			else if(c2.isSelected()) {
				facility+=" Internet Banking";
			}
			else if(c3.isSelected()) {
				facility+=" Mobile Banking";
			}
			else if(c4.isSelected()) {
				facility+=" Email Alert";
			}
			else if(c5.isSelected()) {
				facility+=" Cheque book";
			}
			else if(c6.isSelected()) {
				facility+=" E-Statement";
			}
			AccountDetail detail = new AccountDetail();
			detail.setAccountType(account);
			detail.setAppno((int)abs);
			detail.setCard(cardNo);
			detail.setPin(pinNo);
			detail.setServices(facility);
			if(c6.isSelected()==false) {
				JOptionPane.showMessageDialog(null,"Please select the checkbox");
			}
			else {
				boolean b = Dao.saveAccountDetail(detail);
				Dao.saveLoginDetail(cardNo, pinNo);
				if(b) {
					System.out.println("data is inserted");
					Dao.saveDeposit(cardNo);
					JOptionPane.showMessageDialog(null,"card number: "+cardNo+"\n Pin: "+ pinNo);
					setVisible(false);
					new Login().setVisible(true);;
				}
				else {
					System.out.println("Data is not inserted");
				}
			}
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
		}
	}
}
