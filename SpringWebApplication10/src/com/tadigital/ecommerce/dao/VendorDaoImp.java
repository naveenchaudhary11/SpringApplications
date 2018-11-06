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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;





@Repository
public class VendorDaoImp implements VendorDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName("user_info");
		
	}
	
	
	@Override
	public boolean loginProcess(Vendor v) {
		
			String sql = "SELECT * FROM user_info WHERE username =:vuname AND password =:vpassword";
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("vuname", v.getUname());
			parameters.addValue("vpassword", v.getPassword());

		
			
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
		
		
		boolean status = false;
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("username", v.getUname());
		parameters.addValue("password", v.getPassword());

		int row  = simpleJdbcInsert.execute(parameters);
		
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
		String sql = "UPDATE user_info  SET password =:vuname WHERE username =:vpassword ";
		boolean status=false;
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("vuname", v.getUname());
		parameters.addValue("vpassword", v.getPassword());
		int row = namedParameterJdbcTemplate.update(sql,parameters);
		if(row!=0) {
			status = true;
		}

		return status;
	}
	
	
}
