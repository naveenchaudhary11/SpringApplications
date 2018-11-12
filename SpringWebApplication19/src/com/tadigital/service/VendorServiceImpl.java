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
	private VendorDao vendorDaoProxy;
	
	@Autowired
	public VendorServiceImpl(VendorDao vendorDaoProxy) {
		this.vendorDaoProxy = vendorDaoProxy;
	}


	public boolean loginVendor(Vendor v) {
		return vendorDaoProxy.loginProcess(v);
	}

	@Override
	public boolean registerVendor(Vendor v) {
		return vendorDaoProxy.registerVendor(v);
	}


	@Override
	public List<Vendor> getVendors() {
		return vendorDaoProxy.getVendors();
	}


	@Override
	public List<Vendor> deleteVendor(int vid) {
		return vendorDaoProxy.deleteVendor(vid);
	}


	@Override
	public Vendor editVendor(int vid) {
		return vendorDaoProxy.editVendor(vid);
	}


	@Override
	public boolean updateVendor(Vendor v) {
		return vendorDaoProxy.updateVendor(v);
	}
}
