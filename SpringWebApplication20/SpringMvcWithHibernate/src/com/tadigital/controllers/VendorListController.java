package com.tadigital.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorListController {
	
	private VendorService vs;
	
	@Autowired
	public VendorListController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(value = "/vendorlist")
	public String loadVendorList(HttpSession session) {
		List<Vendor> list = vs.getVendors();
		session.setAttribute("VENDOR_LIST", list);
		return "vendorList";
	}
	
	@GetMapping(value = "/delete{vid}")
	public String deleteVendor(@PathVariable int vid, HttpSession session) {
		List<Vendor> vList = (ArrayList<Vendor>)session.getAttribute("VENDOR_LIST");
		vList = (ArrayList<Vendor>)vs.deleteVendor(vid);
		if(vList == null) {
			return "vendorList";
		}
		session.setAttribute("VENDOR_LIST", vList);
		return "vendorList";
	}
	
	@GetMapping(value = "/edit{vid}")
	public String editVendor(@PathVariable int vid, HttpSession session) {
		Vendor v = vs.editVendor(vid);
		if(v == null) {
			return "vendorList";
		}
		session.setAttribute("EDIT_VENDOR", v);
		return "editForm";
	}
	
	@PostMapping(value = "/updateVendor")
	public String updateVendor(HttpServletRequest req,HttpSession session) {
		Vendor v = (Vendor)session.getAttribute("EDIT_VENDOR");
		v.setName(req.getParameter("name"));
		v.setUname(req.getParameter("uname"));
		if(vs.updateVendor(v)) {
			session.setAttribute("EDIT_VENDOR", v);
			List<Vendor> list = vs.getVendors();
			session.setAttribute("VENDOR_LIST", list);
			return "vendorList";
		}
		return "editForm";
	}
}
