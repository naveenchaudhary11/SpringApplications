package com.tadigital.ecommerce.service;

import java.util.List;

import com.tadigital.ecommerce.entity.Vendor;

public interface VendorService {
	
	public boolean loginVendor(Vendor v);
	public boolean registerVendor(Vendor v);
	public List<Vendor> getAllVendors();
	public boolean deleteVendor(String vname);
	public boolean editVendor(Vendor vendor);
}
