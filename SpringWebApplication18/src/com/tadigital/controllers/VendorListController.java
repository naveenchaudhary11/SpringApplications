package com.tadigital.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tadigital.entity.Vendor;
import com.tadigital.service.VendorService;

@Controller
public class VendorListController {
	private static final Logger LOGGER = Logger.getLogger(VendorListController.class);
	private VendorService vs;
	
	@Autowired
	public VendorListController(VendorService vs) {
		this.vs = vs;
	}

	@RequestMapping(value = "/vendorlist")
	public String loadVendorList(HttpSession session) {
		LOGGER.info("loadVendorList Controller executing");
		List<Vendor> list = vs.getVendors();
		session.setAttribute("VENDOR_LIST", list);
		LOGGER.info("loadVendorList Controller finishing");
		return "vendorList";
	}
	
	@RequestMapping(value = "/delete{vid}")
	public String deleteVendor(@PathVariable int vid, HttpSession session) {
		LOGGER.info("deleteVendor Controller executing");
		List<Vendor> vList = (ArrayList<Vendor>)session.getAttribute("VENDOR_LIST");
		vList = (ArrayList<Vendor>)vs.deleteVendor(vid);
		LOGGER.info("deleteVendor Controller finishing");
		if(vList == null) {
			return "vendorList";
		}
		session.setAttribute("VENDOR_LIST", vList);
		return "vendorList";
	}
	
	@RequestMapping(value = "/edit{vid}")
	public String editVendor(@PathVariable int vid, HttpSession session) {
		LOGGER.info("editVendor Controller executing");
		Vendor v = vs.editVendor(vid);
		if(v == null) {
			LOGGER.info("editVendor Controller finishing");
			return "vendorList";
		}
		LOGGER.info("editVendor Controller finishing");
		session.setAttribute("EDIT_VENDOR", v);
		return "editForm";
	}
	
	@RequestMapping(value = "/updateVendor")
	public String updateVendor(HttpServletRequest req,HttpSession session) {
		LOGGER.info("updateVendor Controller executing");
		Vendor v = (Vendor)session.getAttribute("EDIT_VENDOR");
		v.setName(req.getParameter("name"));
		v.setUname(req.getParameter("uname"));
		if(vs.updateVendor(v)) {
			session.setAttribute("EDIT_VENDOR", v);
			List<Vendor> list = vs.getVendors();
			session.setAttribute("VENDOR_LIST", list);
			LOGGER.info("updateVendor Controller finishing");
			return "vendorList";
		}
		LOGGER.info("updateVendor Controller finishing");
		return "editForm";
	}
}
