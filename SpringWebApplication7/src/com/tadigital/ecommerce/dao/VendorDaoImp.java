package com.tadigital.ecommerce.dao;

import com.tadigital.ecommerce.entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class VendorDaoImp implements VendorDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public boolean loginProcess(Vendor v) {
		
			String sql = "SELECT * FROM user_info WHERE username =? AND password =?";
			boolean status = false;
			Vendor v1;
			try {
				
			
			v1 = jdbcTemplate.queryForObject(sql,new Object[] {v.getUname(),v.getPassword()}, new RowMapper<Vendor>() {
				
																							public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException{
																								Vendor vendor = new Vendor();
																								
																								vendor.setUname(rs.getString(1));
																								vendor.setPassword(rs.getString(2));
																								
																								return vendor;
																								
																							}
																						  });
			
			
			}catch (EmptyResultDataAccessException erdae) {
				v1 = null;
				erdae.printStackTrace();
			}
			
			if(v1!=null) {
				status = true;
			}
			return status;
	}


	@Override
	public boolean registrationProcess(Vendor v) {
		
		String sql = "INSERT INTO user_info(username, password) VALUES(?,?)";
		boolean status = false;
		
		int row  = jdbcTemplate.update(sql, v.getUname(),v.getPassword());
		
		if(row!=0) {
			status = true;
		}
		
		
		
		return status;
	}


	@Override
	public List<Vendor> getVendorProcess() {
		
		String sql = "SELECT * FROM user_info";
		
		List<Vendor> vlist = jdbcTemplate.query(sql,  new RowMapper<Vendor>() {
															@Override
															public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
																Vendor vendor = new Vendor();
																
																vendor.setUname(rs.getString(1));
																vendor.setPassword(rs.getString(2));
																
																return vendor;
															}
														  });
		List<Vendor> vlist1 = new ArrayList<>(vlist);
		return vlist1;
	}


	@Override
	public boolean deleteVendorProcess(String vname) {
		String sql = "DELETE FROM user_info WHERE username =? ";
		boolean status = false;
		
		int row = jdbcTemplate.update(sql,vname);
		if(row!=0) {
			status = true;
		}
		
		return status;
	}


	@Override
	public boolean editVendorProcess(Vendor v) {
		String sql = "UPDATE user_info  SET password =? WHERE username =? ";
		boolean status=false;
		
		int row = jdbcTemplate.update(sql,v.getPassword(),v.getUname());
		if(row!=0) {
			status = true;
		}

		return status;
	}
	
	/*

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
		
		
	}*/
}
