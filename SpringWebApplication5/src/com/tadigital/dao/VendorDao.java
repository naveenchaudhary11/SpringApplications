package com.tadigital.dao;

import com.tadigital.entity.Vendor;

public interface VendorDao {
	
	public boolean registerVendor(Vendor v);
	public boolean loginProcess(Vendor v);
	
}
