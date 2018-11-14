package com.tadigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tadigital.dao.VendorDao;
import com.tadigital.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	
	private VendorDao vd;
	
	@Autowired
	public VendorServiceImpl(VendorDao vd) {
		this.vd = vd;
	}


	public boolean loginVendor(Vendor v) {
		return vd.loginProcess(v);
	}

	@Override
	public boolean registerVendor(Vendor v) {
		return vd.registerVendor(v);
	}


	@Override
	public List<Vendor> getVendors() {
		return vd.getVendors();
	}


	@Override
	public List<Vendor> deleteVendor(int vid) {
		return vd.deleteVendor(vid);
	}


	@Override
	public Vendor editVendor(int vid) {
		return vd.editVendor(vid);
	}


	@Override
	public boolean updateVendor(Vendor v) {
		return vd.updateVendor(v);
	}
}
