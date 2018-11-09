package com.tadigital.service;

import java.util.List;

import com.tadigital.entity.Vendor;

public interface VendorService {
	
	public boolean loginVendor(Vendor v);
	public boolean registerVendor(Vendor v);
	public List<Vendor> getVendors();
	public List<Vendor> deleteVendor(int vid);
	public Vendor editVendor(int vid);
	public boolean updateVendor(Vendor v);
}
