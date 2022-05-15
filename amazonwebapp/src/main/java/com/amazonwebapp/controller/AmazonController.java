package com.amazonwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amazonwebapp.entity.AmazonUser;
import com.amazonwebapp.service.AmazonServiceInterface;

@Controller
public class AmazonController {
    @Autowired
    AmazonServiceInterface aservice;
    
	@RequestMapping("RegistrationServlet")
	public ModelAndView registerUser(@RequestParam("name") String name,@RequestParam("em") String email,@RequestParam("pass") String password,@RequestParam("add") String address) {
		AmazonUser am=new AmazonUser();
		am.setName(name);
		am.setEmail(email);
		am.setPassword(password);
		am.setAddress(address);
		
		int i=aservice.createProfile(am);
		String s="Profile not created";
		if(i>0) {
			s="Profile Created";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",s);
		mv.setViewName("registrationresult.jsp");
		return mv;
	}
}
