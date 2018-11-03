package com.tadigital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao{
	Connection con = null;
	Statement stmt = null;
	
	@Override
	public boolean loginProcess(Vendor v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "SELECT * FROM user_info WHERE username = '" + v.getUname() + "' AND password = '" + v.getPassword() + "'";
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean registerVendor(Vendor v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "SELECT * FROM user_info WHERE username = '" + v.getUname() + "' AND password = '" + v.getPassword() + "'";
			System.out.println(sql);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		return false;
	}
}
