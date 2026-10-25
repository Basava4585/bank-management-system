package com.sop.bank_management_system.dao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Display {
	//method to display text
	public static JLabel createText(String name,int textLength, int left,int up,int height,int width) {
		JLabel text = new JLabel(name);
		text.setBounds(left,up,height,width);
		text.setFont(new Font("Osward",Font.BOLD,textLength));
		return text;
	}
	
	//method to create button
	public static JButton createButton(String name,int left,int up,int height,int width) {
		JButton button = new JButton(name);
		button.setBounds(left, up, height, width);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		return button;
	}
	public static JButton createButton(String name,int left,int up,int height,int width,boolean b) {
		JButton button = new JButton(name);
		button.setBounds(left, up, height, width);
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		return button;
	}
	
	//method to create textField
	public static JTextField createTextField(int left,int up,int height,int width) {
		JTextField field = new JTextField();
		field.setBounds(left, up, height, width);
		field.setFont(new Font("Arial",Font.BOLD,14));
		return field;
		
	}
	//method to create radioButton
	public static JRadioButton createRadioButton(String name,int left,int up,int height,int width) {
		JRadioButton button = new JRadioButton(name);
		button.setBounds(left,up,height,width);
		button.setBackground(Color.WHITE);
		return button;
	}
	//method to create dropdown box
	public static JComboBox createDropdown(String var[],int left,int up,int height,int width) {
		JComboBox box = new JComboBox(var);
		box.setBounds(left,up,height,width);
		box.setBackground(Color.WHITE);
		return box;
		
	}
	
	//method to create checkbox
	public static JCheckBox createCheckbox(String name,int left,int up,int height,int width) {
		JCheckBox box = new JCheckBox(name);
		box.setBounds(left,up,height,width);
		box.setFont(new Font("Arial",Font.BOLD,16));
		box.setBackground(Color.WHITE);
		return box;
	}

}
