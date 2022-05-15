package com.Flipkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Flipkart.entity.Customer;
import com.Flipkart.service.FlipkartServiceInterface;

@RestController
public class FlipkartController{
    
	@Autowired
	FlipkartServiceInterface fs;
	
	@GetMapping("viewprofile/{id}")
	public Customer viewProfile(@PathVariable("id") String ss) {
		Customer u=new Customer();
		u.setEmail(ss);
		return fs.viewProfileService(u);
	}
	
	@GetMapping("viewallprofile")
	public List<Customer> viewAllProfile(){
		return fs.viewAllProfileService();
	}
	
	@PostMapping("createprofile")
	public String createProfile(@RequestBody Customer u) {
		int i=fs.createProfileService(u);
		if(i>0) {
			return "Profile Created";
		}
		else {
			return "Profile Not created";		}
	}
	
	@PostMapping("editprofile/{id}")
	public String editProfile(@PathVariable("id") String email,@RequestBody Customer u) {
		Customer c=new Customer();
		c.setEmail(email);
		int i=fs.editProfileService(c);
		if(i>0) {
			return "Profile Edited";
		}
		else {
			return "Profile Not Edited";
		}
	}
	
	@DeleteMapping("deleteprofile/{id}")
	public String deleteProfile(@PathVariable("id") String email) {
		Customer c=new Customer();
		c.setEmail(email);
		return fs.deleteProfileService(c);
		
		
	}
	
}
