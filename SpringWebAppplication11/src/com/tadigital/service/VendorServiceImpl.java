package com.tadigital.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

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
	public boolean registerVendor(Vendor v){
		System.out.println("here");
		Part part = v.getImgPart();
		String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    String fileName = "";
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            fileName = s.substring(s.indexOf('=') + 2, s.length()-1);
	        }
	    }
	    
	    FileOutputStream fos = null;
	    InputStream is = null;
	   
	    try {
	    	File file = new File("D:\\" + File.separator + fileName);
	    	fos = new FileOutputStream(file);
	        is = part.getInputStream();
	
	        int read = 0;
	        final byte[] bytes = new byte[1024];
	
	        while((read = is.read(bytes)) != -1) {
	            fos.write(bytes, 0, read);
	        }
	        v.setImgName(fileName);
	        
	    } catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally {
	    	try {
	    		if (fos != null) {
		            fos.close();
		        }
		        if (is != null) {
		        	is.close();
		        }
			} catch (IOException ioe) {
		        ioe.printStackTrace();
		    }
	    }
	    
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
