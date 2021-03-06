package com.tadigital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorServiceImpl;

@Repository
public class VendorDaoImp implements VendorDao{
	private NamedParameterJdbcTemplate npjt;
	private static final Logger LOGGER = Logger.getLogger(VendorDaoImp.class);
	
	/*@Autowired
	public VendorDaoImp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		npjt = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean loginProcess(Vendor v) {
		LOGGER.info("loginProcess dao executing");
		String sql = "SELECT * FROM user_info WHERE username = :user_name AND password = :pwd";
		Vendor ven = null;
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("user_name", v.getUname());
		parameters.addValue("pwd", v.getPassword());
		try {
			ven = npjt.queryForObject(sql, parameters, new RowMapper<Vendor>() {
															@Override
															public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
																Vendor vendor = new Vendor();
																vendor.setId(rs.getInt(1));
																vendor.setName(rs.getString(2));
																vendor.setUname(rs.getString(3));
																vendor.setPassword(rs.getString(4));
																return vendor;
															}
			});
		} catch(EmptyResultDataAccessException erdae) {
			erdae.printStackTrace();
		}
		LOGGER.info("loginProcess dao finishing");
		return ven!=null;
	}
	
	public boolean registerVendor(Vendor v) {
		LOGGER.info("registerVendor dao executing");
		String sql = "INSERT INTO user_info(name,username,password) VALUES(:name,:user_name,:pwd);";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("name", v.getName());
		parameters.addValue("user_name", v.getUname());
		parameters.addValue("pwd", v.getPassword());
		
		int rows = npjt.update(sql, parameters);
		
		LOGGER.info("registerVendor dao finishing");
		return rows!= 0;
	}

	@Override
	public List<Vendor> getVendors() {
		LOGGER.info("getVendors dao executing");
		String sql = "SELECT * FROM user_info";
			
		
		List<Vendor> list =  npjt.query(sql, new RowMapper<Vendor>() {
			@Override
			public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor v = new Vendor();
				v.setId(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setUname(rs.getString(3));
				v.setPassword(rs.getString(4));
				return v;
			}
		});
		
		LOGGER.info("getVendors dao finishing");
		return list;
	}

	@Override
	public List<Vendor> deleteVendor(int vid) {
		LOGGER.info("deleteVendor dao executing");
		String sql = "DELETE from user_info WHERE id = :vid";
		List<Vendor> list = null;
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("vid", vid);
		
		int rows = npjt.update(sql, parameters);
		if(rows != 0) {
			sql = "SELECT * FROM user_info";
			list =  npjt.query(sql, new RowMapper<Vendor>() {
				public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
					Vendor v = new Vendor();
					v.setId(rs.getInt(1));
					v.setName(rs.getString(2));
					v.setUname(rs.getString(3));
					v.setPassword(rs.getString(4));
					return v;
				}
			});
		}
		LOGGER.info("deleteVendor dao finishing");
		return list;
	}

	@Override
	public Vendor editVendor(int vid) {
		LOGGER.info("editVendor dao executing");
		String sql = "SELECT * FROM user_info WHERE id = :vid";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("vid", vid);
		
		Vendor v = new Vendor();
		try {
			v = npjt.queryForObject(sql, parameters, new RowMapper<Vendor>() {
				@Override
				public Vendor mapRow(ResultSet rs, int numRow) throws SQLException {
					Vendor vendor = new Vendor();
					vendor.setId(rs.getInt(1));
					vendor.setName(rs.getString(2));
					vendor.setUname(rs.getString(3));
					vendor.setPassword(rs.getString(4));
					return vendor;
				}
			});
		}catch(EmptyResultDataAccessException erdae) {
			erdae.printStackTrace();
		}
		LOGGER.info("editVendor dao finishing");
		return v;
	}

	@Override
	public boolean updateVendor(Vendor v) {
		LOGGER.info("updateVendor dao executing");
		String sql = "UPDATE user_info SET name= :name, username = :user_name WHERE id= :vid";
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("name", v.getName());
		parameters.addValue("user_name", v.getUname());
		parameters.addValue("vid", v.getId());
		
		int rows = npjt.update(sql, parameters);
		
		LOGGER.info("updateVendor dao finishing");
		return rows != 0;
	}
}
