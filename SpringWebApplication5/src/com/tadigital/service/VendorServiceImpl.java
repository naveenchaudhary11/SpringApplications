package com.tadigital.service;

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
}
