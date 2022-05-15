package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceInterface;

@RestController
public class UserController {
	@Autowired
	UserServiceInterface fs;
	
    @GetMapping("viewprofile/{id}")
    public User viewProfile(@PathVariable("id") String ss) {
    	User u=new User();
    	u.setEmail(ss);
    	User f=fs.viewProfileService(u);
    	return f;
    }
    
    @GetMapping("viewallprofile")
    public List<User> viewAllProfile(){
    	return fs.viewAllProfileService();
    }
    
    @PostMapping("createprofile")
    public String createProfile(@RequestBody User ff) {
    	int i=fs.createProfileService(ff);
    	if(i>0) {
    		return "Profile Created";
    	}
    	else {
    		return "Profile Not Created";
    	}
    }
    
    @PutMapping("editprofile/{id}")
    public String editProfile(@PathVariable("id") String ss,@RequestBody User ff) {
    	User u=new User();
    	u.setEmail(ss);
    	return fs.editProfileService(u);
    }
    
    @DeleteMapping("deleteprofile/{id}")
    public String deleteProfile(@PathVariable("id") String ss) {
    	User u=new User();
    	u.setEmail(ss);
    	return fs.deleteProfileService(u);
    }
    
    @GetMapping("viewbyname/{name}")
    public List<User> viewByName(@PathVariable("name") String ss) {
    	User u=new User();
    	u.setName(ss);
    	return fs.viewByName(u);
    }
}
