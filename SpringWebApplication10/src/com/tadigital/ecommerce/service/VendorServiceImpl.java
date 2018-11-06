package com.tadigital.ecommerce.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tadigital.ecommerce.dao.VendorDao;
import com.tadigital.ecommerce.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	
	private VendorDao vd;
	
	@Autowired
	public VendorServiceImpl(VendorDao vd) {
		this.vd = vd;
	}

	@Override
	public boolean loginVendor(Vendor v) {
		return vd.loginProcess(v);
	}


	@Override
	public boolean registerVendor(Vendor v) {
		return vd.registrationProcess(v);
		
	}


	@Override
	public List<Vendor> getAllVendors() {
		return vd.getVendorProcess();
	}


	@Override
	public boolean deleteVendor(String vname) {
		return vd.deleteVendorProcess(vname);
	}

	@Override
	public boolean editVendor(Vendor vendor) {
		return vd.editVendorProcess(vendor);
	}
}
