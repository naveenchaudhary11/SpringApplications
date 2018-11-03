package com.tadigital.ecommerce.dao;

import com.tadigital.ecommerce.entity.Vendor;

public interface VendorDao {
	
	public boolean registerVendor(Vendor v);
	public boolean loginProcess(Vendor v);
	
}
