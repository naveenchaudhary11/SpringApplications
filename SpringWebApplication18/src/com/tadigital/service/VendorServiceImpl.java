package com.tadigital.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tadigital.controllers.LoginController;
import com.tadigital.dao.VendorDao;
import com.tadigital.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	private static final Logger LOGGER = Logger.getLogger(VendorServiceImpl.class);
	private VendorDao vd;
	
	@Autowired
	public VendorServiceImpl(VendorDao vd) {
		this.vd = vd;
	}


	public boolean loginVendor(Vendor v) {
		LOGGER.info("loginVendor Service executing");
		boolean b = vd.loginProcess(v);
		LOGGER.info("loginVendor Service finishing");
		return b;
	}

	@Override
	public boolean registerVendor(Vendor v) {
		LOGGER.info("registerVendor Service executing");
		Boolean b = vd.registerVendor(v);
		LOGGER.info("registerVendor Service finishing");
		return b;
	}


	@Override
	public List<Vendor> getVendors() {
		LOGGER.info("getVendors Service executing");
		List<Vendor> list = vd.getVendors();
		LOGGER.info("getVendors Service finishing");
		return list;
	}


	@Override
	public List<Vendor> deleteVendor(int vid) {
		LOGGER.info("deleteVendor Service executing");
		List<Vendor> list =  vd.deleteVendor(vid);
		LOGGER.info("deleteVendor Service finishing");
		return list;
	}


	@Override
	public Vendor editVendor(int vid) {
		LOGGER.info("editVendor Service executing");
		Vendor v = vd.editVendor(vid);
		LOGGER.info("editVendor Service finishing");
		return v;
	}


	@Override
	public boolean updateVendor(Vendor v) {
		LOGGER.info("updateVendor Service executing");
		Boolean b = vd.updateVendor(v);
		LOGGER.info("updateVendor Service finishing");
		return b;
	}
}
