package com.tadigital.ecommerce.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.tadigital.ecommerce.entity.Vendor;
import com.tadigital.ecommerce.service.VendorService;

@Controller
public class VendorController {
	
	private VendorService vs;
	
	@Autowired
	public VendorController(VendorService vs) {
		this.vs = vs;
	}
	

	@RequestMapping(value="/vendorlist")
	public String listVendors(HttpSession session) {
		
		List<Vendor> vlist = vs.getAllVendors();
		session.setAttribute("VENDORS", vlist );
		return "VendorList.jsp";
		
	}
	
	@RequestMapping(value="/vendordelete{vname}")
	public String deleteVendor(@PathVariable String vname, HttpSession session) {
		
		List<Vendor> vlist = (List<Vendor>) session.getAttribute("VENDORS");
        vs.deleteVendor(vname);
        
        int idx = -1;
        for(int i=0;i<vlist.size();i++) {
        	if(vlist.get(i).getUname().equals(vname)) {
        		idx = i;
        		break;
        	}
        }
        
        vlist.remove(idx);
		return "VendorList.jsp";
		
	}
	
	@RequestMapping(value="/vendoredit{vname}")
	public String editVendorForm(@PathVariable String vname, HttpSession session) {
		
		List<Vendor> vlist = (List<Vendor>) session.getAttribute("VENDORS");
        
        
        int idx = -1;
        for(int i=0;i<vlist.size();i++) {
        	if(vlist.get(i).getUname().equals(vname)) {
        		idx = i;
        		break;
        	}
        }
        session.setAttribute("EDITVENDOR", vlist.get(idx));
        
		return "EditVendor.jsp";
		
	}
	
	@RequestMapping(value="/edit")
	public String editVendor(@ModelAttribute Vendor v, HttpSession session) {
		List<Vendor> vlist = (List<Vendor>) session.getAttribute("VENDORS");
		Vendor vedit = (Vendor) session.getAttribute("EDITVENDOR");
		
		vs.editVendor(v);
		int idx = vlist.indexOf(vedit);
		vlist.set(idx, v);		
		
		return "";
	}
}
