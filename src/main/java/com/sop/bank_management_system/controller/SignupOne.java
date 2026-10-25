package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;
import com.sop.bank_management_system.entity.UserDetail;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	long abs;
	JTextField nameField,fnameField , emailField,addressField, cityField,stateField,pinField;
	JRadioButton male,female,married,unmarried,other;
	JButton next;
	JDateChooser dateChooser;
	SignupOne(){
		Random ran = new Random();
		abs = Math.abs((ran.nextLong()%9000L)+1000L);
		JLabel application = Display.createText("APPLICATION FORM NUMBER. "+abs,32,140, 20, 600, 40);
		add(application);
		
		JLabel persoanlDetail = Display.createText("Page 1: Personal Details", 22, 290, 80, 400, 30);
		add(persoanlDetail);
		
		JLabel name = Display.createText("Name: ",20,100,140,100, 30);
		add(name);
		nameField = Display.createTextField(300, 140, 400, 30);
		add(nameField);
		
		JLabel fname = Display.createText("Father's Name: ",20,100,190,200, 30);
		add(fname);
		fnameField = Display.createTextField(300, 190, 400, 30);
		add(fnameField);
		
		JLabel dob = Display.createText("Date of Birth: ",20,100,240,200, 30);
		add(dob);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 30);
		add(dateChooser);
		
		JLabel gender = Display.createText("Gender: ",20,100,290,200, 30);
		add(gender);
		male = Display.createRadioButton("Male", 300, 290, 60, 30);
		add(male);
		female = Display.createRadioButton("Female", 450, 290, 120, 30);
		add(female);
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		JLabel email = Display.createText("Email Address: ",20,100,340,200, 30);
		add(email);
		emailField = Display.createTextField(300, 340, 400, 30);
		add(emailField);
		
		JLabel marital = Display.createText("Marital Status: ",20,100,390,200, 30);
		add(marital);
		married = Display.createRadioButton("Married", 300, 390, 100, 30);
		add(married);
		unmarried = Display.createRadioButton("Unmarried", 450, 390, 100, 30);
		add(unmarried);
		other = Display.createRadioButton("other", 630, 390, 100, 30);
		add(other);
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = Display.createText("Address: ",20,100,440,200, 30);
		add(address);
		addressField = Display.createTextField(300, 440, 400, 30);
		add(addressField);
		
		JLabel city = Display.createText("City: ",20,100,490,200, 30);
		add(city);
		cityField = Display.createTextField(300, 490, 400, 30);
		add(cityField);
		
		JLabel state = Display.createText("State: ",20,100,540,200, 30);
		add(state);
		stateField = Display.createTextField(300, 540, 400, 30);
		add(stateField);
		
		JLabel pincode = Display.createText("Pin Code: ",20,100,590,200, 30);
		add(pincode);
		pinField = Display.createTextField(300, 590, 400, 30);
		add(pinField);
		
		next = Display.createButton("Next", 620, 660, 80, 30);
		add(next);
		next.addActionListener(this);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setSize(850,800);
		setLocation(350, 10);
		setVisible(true);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		UserDetail user = new UserDetail();
		user.setAddress(addressField.getText());
		user.setAppno((int)abs);
		user.setCity(cityField.getText());
		user.setDob(new Date(dateChooser.getDate().getTime()));
		user.setEmail(emailField.getText());
		user.setFatherName(fnameField.getText());
		String gender=null;
		if(male.isSelected()) {
			gender="male";
		}
		else if(female.isSelected()) {
			gender="female";
		}
		user.setGender(gender);
		String marital=null;
		if(married.isSelected()) {
			marital="married";
		}
		else if(unmarried.isSelected()) {
			marital="unmarried";
		}
		else if(other.isSelected()) {
			marital="other";
		}
		user.setMarital(marital);
		user.setName(nameField.getText());
		user.setState(stateField.getText());
		try {
			user.setPincode(Integer.parseInt(pinField.getText()));
		}catch(NumberFormatException e1) {
			e1.printStackTrace();
		}
		boolean b = Dao.saveDetail(user);
		if(b) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data not inserted");
		}
		setVisible(false);
		new SignupTwo(abs).setVisible(true);
	}

}