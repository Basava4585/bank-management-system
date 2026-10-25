package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display; 
public class Login extends JFrame implements ActionListener{
	JButton login,signup,clear;
	JTextField cardField;
	JPasswordField pinField;
	Login(){
		setTitle("Automated Teller Machine");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10, 100,100);
		add(label);
		getContentPane().setBackground(Color.white);
		JLabel t1 = Display.createText("Welcome to ATM",38,200,40,400,40);
		add(t1);
		JLabel t2 = Display.createText("Card No:",28,120,150,150,30);
		add(t2);
		JLabel t3 = Display.createText("PIN:",28,120,220,150,30);
		add(t3);
		
		cardField = Display.createTextField(300,150, 230, 30);
		add(cardField);
		pinField = new JPasswordField();
		pinField.setBounds(300,220, 230, 30);
		pinField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinField);
		
		login = Display.createButton("Login", 300, 300, 100, 30);
		login.addActionListener(this);
		add(login);
		clear = Display.createButton("Clear", 430, 300, 100, 30);
		clear.addActionListener(this);
		add(clear);
		signup = Display.createButton("Sign Up", 300, 350, 230, 30);
		signup.addActionListener(this);
		add(signup);
		
		setLayout(null);
		setSize(800,480);
		setVisible(true);
		setLocation(350, 200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardField.setText("");
			pinField.setText("");
		}
		else if(e.getSource()==login) {
			String cardNo=cardField.getText();
			String pinNo=pinField.getText();
			String pin = Dao.getPin(cardNo);
			if(pinNo.equals(pin)) {
				setVisible(false);
				new Transactions(cardNo).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Incorrect Pin or Card No");
			}
			
			
			
		}
		else if(e.getSource()==signup){
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		
	}
}
