package com.tadigital.ecommerce.dao;

import com.tadigital.ecommerce.entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;



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
	
	@Override
	public boolean registrationProcess(Vendor v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "INSERT INTO user_info(username, password) VALUES('" + v.getUname() + "' , '" + v.getPassword() + "')";
			System.out.println(sql);
			stmt = con.createStatement();
			
			int res = stmt.executeUpdate(sql);
			if(res!=0) {
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


	@Override
	public List<Vendor> getVendorProcess() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "SELECT * FROM user_info";
			//System.out.println(sql);
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			List<Vendor> vlist = new ArrayList<>();
			
			while(rs.next()) {
				Vendor v= new Vendor();
				v.setUname(rs.getString(1));
				System.out.println(v.getUname());
				vlist.add(v);
			}
			return vlist;
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
		return null;
		
	}

	@Override
	public boolean deleteVendorProcess(String vname) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "DELETE FROM user_info WHERE username = '" + vname + "' ";
			System.out.println(sql);
			stmt = con.createStatement();
			
			int res = stmt.executeUpdate(sql);
			return true;
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
		
		return true;
	}

	@Override
	public boolean editVendorProcess(Vendor v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercedb", "root", "");
			String sql = "UPDATE user_info  SET password = '" + v.getPassword() + "' WHERE username = '"+v.getUname()+"' ";
			System.out.println(sql);
			stmt = con.createStatement();
			
			int res = stmt.executeUpdate(sql);
			if(res!=0) {
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
