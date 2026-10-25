package com.sop.bank_management_system.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sop.bank_management_system.dao.Dao;
import com.sop.bank_management_system.dao.Display;
import com.sop.bank_management_system.entity.UserAdditionalDetail;

public class SignupTwo extends JFrame implements ActionListener{
	JTextField panField, aadharField,pinField;
	JComboBox religionField,categoryField,incomeField,eduField, occupationField;
	JRadioButton citizenYes,citizenNo,accountYes,accountNo;
	JButton next;
	long abs;
	SignupTwo(long abs){
		this.abs=abs;
		JLabel persoanlDetail = Display.createText("Page 2: Additional Details", 22, 290, 80, 400, 30);
		add(persoanlDetail);
		
		JLabel religion = Display.createText("Religion: ",20,100,140,100, 30);
		add(religion);
		String varReligion[]= {"Hindu","Sikh","Muslim","Christian","other"};
		religionField = Display.createDropdown(varReligion,300, 140, 400, 30);
		add(religionField);
		String varCategory[]= {"Genral","Obc","Sc","St","Other"};
		JLabel category = Display.createText("Category: ",20,100,190,200, 30);
		add(category);
		categoryField = Display.createDropdown(varCategory,300, 190, 400, 30);
		add(categoryField);
		String varIncome[]= {"Null","<250000","<500000",">1000000"};
		JLabel income = Display.createText("Income: ",20,100,240,200, 30);
		add(income);
		incomeField = Display.createDropdown(varIncome,300, 240, 400, 30);
		add(incomeField);
		
		JLabel edu = Display.createText("Educational",20,100,290,200, 30);
		add(edu);
		JLabel qua = Display.createText("Qualification: ",20,100,315,200, 30);
		add(qua);
		String varedu[]= {"Non-Gradute","Graduate","Post-Gradute","other"};
		eduField = Display.createDropdown(varedu,300, 310, 400, 30);
		add(eduField);
		
		JLabel occupation = Display.createText("Occupation: ",20,100,390,200, 30);
		add(occupation);
		String varoccu[]= {"Self-employed","Employee","Bussiness","Student","other"};
		occupationField = Display.createDropdown(varoccu,300, 390, 400, 30);
		add(occupationField);
		
		JLabel pan = Display.createText("Pan Number: ",20,100,440,200, 30);
		add(pan);
		panField = Display.createTextField(300, 440, 400, 30);
		add(panField);
		
		JLabel aadhar = Display.createText("Addhar Number: ",20,100,490,200, 30);
		add(aadhar);
		aadharField = Display.createTextField(300, 490, 400, 30);
		add(aadharField);
		
		JLabel citizen = Display.createText("Senior Citizen: ",20,100,540,200, 30);
		add(citizen);
		citizenYes = Display.createRadioButton("Yes",300, 540, 100, 30);
		add(citizenYes);
		citizenNo = Display.createRadioButton("No",410, 540, 400, 30);
		ButtonGroup citizenGroup = new ButtonGroup();
		citizenGroup.add(citizenYes);
		citizenGroup.add(citizenNo);
		add(citizenNo);
		
		JLabel account = Display.createText("Existing Account: ",20,100,590,200, 30);
		add(account);
		accountYes = Display.createRadioButton("Yes",300, 590, 100, 30);
		add(accountYes);
		accountNo = Display.createRadioButton("No",410, 590, 400, 30);
		add(accountNo);
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(accountYes);
		accountGroup.add(accountNo);
		
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
		UserAdditionalDetail user = new UserAdditionalDetail();
		user.setAddharNumber(Long.parseLong(aadharField.getText()));
		user.setAppno((int)abs);
		user.setCategory((String)categoryField.getSelectedItem());
		user.setEducationalQualification((String)eduField.getSelectedItem());
		String accountVal=null;
		if(accountYes.isSelected()) {
			accountVal="Yes";
		}
		else if(accountNo.isSelected()) {
			accountVal="No";
		}
		user.setExistingAccount(accountVal);
		user.setIncome((String)incomeField.getSelectedItem());
		user.setOccupation((String)occupationField.getSelectedItem());
		user.setPanNumber(panField.getText());
		user.setReligion((String)religionField.getSelectedItem());
		String citizenVal=null;
		if(citizenYes.isSelected()) {
			citizenVal="Yes";
		}
		else if(citizenNo.isSelected()) {
			citizenVal="No";
		}
		user.setSeniorCitizen(citizenVal);
		boolean b = Dao.saveAdditionalDetail(user);
		if(b) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data not inserted");
		}
		setVisible(false);
		new SignupThree(abs).setVisible(true);;
	}
}
