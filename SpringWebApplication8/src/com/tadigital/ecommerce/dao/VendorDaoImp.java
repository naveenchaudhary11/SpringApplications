package com.tadigital.ecommerce.dao;

import com.tadigital.ecommerce.entity.*;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;





@Repository
public class VendorDaoImp implements VendorDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	@Override
	public boolean loginProcess(Vendor v) {
		
			String sql = "SELECT * FROM user_info WHERE username =:uname AND password =:password";
			
			BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(v);

		
			
			boolean status = false;
			Vendor v1;
			try {
				
			
			v1 = namedParameterJdbcTemplate.queryForObject(sql,parameters, new RowMapper<Vendor>() {
				
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
		
		String sql = "INSERT INTO user_info(username, password) VALUES(:uname,:password)";
		boolean status = false;
		
		BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(v);

		int row  = namedParameterJdbcTemplate.update(sql,parameters);
		
		if(row!=0) {
			status = true;
		}
		
		
		
		return status;
	}


	@Override
	public List<Vendor> getVendorProcess() {
		
		String sql = "SELECT * FROM user_info";
		
		List<Vendor> vlist = namedParameterJdbcTemplate.query(sql,  new RowMapper<Vendor>() {
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
		String sql = "DELETE FROM user_info WHERE username =:vuname ";
		boolean status = false;
		

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("vuname", vname);
		int row = namedParameterJdbcTemplate.update(sql,parameters);
		if(row!=0) {
			status = true;
		}
		
		return status;
	}


	@Override
	public boolean editVendorProcess(Vendor v) {
		String sql = "UPDATE user_info  SET password =:uname WHERE username =:password ";
		boolean status=false;
		
		BeanPropertySqlParameterSource parameters = new BeanPropertySqlParameterSource(v);
		int row = namedParameterJdbcTemplate.update(sql,parameters);
		if(row!=0) {
			status = true;
		}

		return status;
	}
	
	
}
