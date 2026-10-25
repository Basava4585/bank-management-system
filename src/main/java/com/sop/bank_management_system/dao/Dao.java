package com.sop.bank_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sop.bank_management_system.connection.DatabaseManager;
import com.sop.bank_management_system.entity.AccountDetail;
import com.sop.bank_management_system.entity.Bank;
import com.sop.bank_management_system.entity.UserAdditionalDetail;
import com.sop.bank_management_system.entity.UserDetail;

public class Dao {
	//method to insert all data
	public static boolean saveDetail(UserDetail o) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into signup values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, o.getName());
			pstm.setString(2,o.getFatherName());
			pstm.setDate(3, o.getDob());
			pstm.setString(4, o.getGender());
			pstm.setString(5, o.getEmail());
			pstm.setString(6, o.getMarital());
			pstm.setString(7, o.getAddress());
			pstm.setString(8, o.getCity());
			pstm.setString(9, o.getState());
			pstm.setInt(10, o.getPincode());
			pstm.setInt(11, o.getAppno());
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to insert value in signuptwo table
	public static boolean saveAdditionalDetail(UserAdditionalDetail o) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into signuptwo values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, o.getReligion());
			pstm.setString(2,o.getCategory());
			pstm.setString(3, o.getIncome());
			pstm.setString(4, o.getEducationalQualification());
			pstm.setString(5, o.getOccupation());
			pstm.setString(6, o.getPanNumber());
			pstm.setLong(7, o.getAddharNumber());
			pstm.setString(8, o.getSeniorCitizen());
			pstm.setString(9, o.getExistingAccount());
			pstm.setInt(10, o.getAppno());
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to insert value in signupthree table
	public static boolean saveAccountDetail(AccountDetail o) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into signupthree values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,o.getAccountType());
			pstm.setString(2, o.getCard());
			pstm.setString(3, o.getPin());
			pstm.setString(4, o.getServices());
			pstm.setInt(5, o.getAppno());
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to insert value in login table
	public static boolean saveLoginDetail(String card,String pin) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into login values(?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,card);
			pstm.setString(2, pin);
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to get pin
	public static String getPin(String card) {
		Connection con = DatabaseManager.getConnection();
		String query="select * from login where card=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,card);
			ResultSet res = pstm.executeQuery();
			if (res.next()) {
				String pin =res.getString("pin");
				return pin;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//method to insert data in bank table
	public static boolean saveBankDetail(Bank bank) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into bank values(?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,bank.getCard());
			pstm.setDate(2, bank.getDate());
			pstm.setString(3, bank.getType());
			pstm.setLong(4,bank.getAmount());
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to deposit amount
	public static boolean deposit(String card,Long amount) {
		Connection con = DatabaseManager.getConnection();
		String query="update useramount set amount=? where card=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setLong(1,amount+Dao.getAmount(card));
			pstm.setString(2, card);
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//method to insert amount for first time
	public static boolean saveDeposit(String card) {
		Connection con = DatabaseManager.getConnection();
		String query="insert into useramount values(?,?)";
			
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, card);
			pstm.setLong(2,0);
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to get amount
	public static Long getAmount(String card) {
		Connection con = DatabaseManager.getConnection();
		String query="select * from useramount where card=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,card);
			ResultSet res = pstm.executeQuery();
			if (res.next()) {
				Long amount =res.getLong("amount");
				return amount;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//method to withdraw amount
	public static boolean withdraw(String card,Long amount) {
		Connection con = DatabaseManager.getConnection();
		String query="update useramount set amount=? where card=?";
		if(Dao.getAmount(card)-amount<=0) {
			return false;
		}
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setLong(1,Dao.getAmount(card)-amount);
			pstm.setString(2, card);
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//method to return last 5 transaction
	public static List<Bank> getMiniStatement(String card) {
		Connection con = DatabaseManager.getConnection();
		String query="select * from bank where card=? order by date desc limit 5";
		List<Bank> list=new ArrayList();
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,card);
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				Bank b = new Bank();
				b.setAmount(res.getLong("amount"));
				b.setDate(res.getDate("date"));
				b.setCard(card);
				b.setType(res.getString("type"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//method to change Pin
	public static boolean changePin(String card,String pin) {
		Connection con = DatabaseManager.getConnection();
		String query="update login set pin=? where card=?";

		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,pin);
			pstm.setString(2, card);
			int rows = pstm.executeUpdate();
			return rows>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
