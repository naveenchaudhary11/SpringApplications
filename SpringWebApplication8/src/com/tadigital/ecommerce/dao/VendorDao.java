package com.tadigital.ecommerce.dao;

import java.util.List;

import com.tadigital.ecommerce.entity.Vendor;

public interface VendorDao {
	

	public boolean loginProcess(Vendor v);
	public boolean registrationProcess(Vendor v);
	public List<Vendor> getVendorProcess();
	public boolean deleteVendorProcess(String vname);
	public boolean editVendorProcess(Vendor vendor);
	
}
