package com.instagram.controller;

import java.util.List;
import java.util.Scanner;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;


public class InstagramController implements InstagramControllerInterface {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		InstagramServiceInterface is=new InstagramService();
		int i=is.createProfileService(iu);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void vieweProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to view profile");
		String email=sc.next();
		
		InstagramUser iu=new InstagramUser();
		iu.setEmail(email);
		
		InstagramServiceInterface is=new InstagramService();
		InstagramUser w=is.viewProfileService(iu);
		
		if(w!=null) {
			System.out.println("Name is "+w.getName());
			System.out.println("Password is "+w.getPassword());
			System.out.println("Email is "+w.getEmail());
			System.out.println("Address is "+w.getAddress());
		}
	}
	
	public void editProfile() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.next();
		
		System.out.println("Enter the email");
		String email=sc.next();
		
		System.out.println("Enter the password");
		String password=sc.next();
		
		System.out.println("Enter the address");
		String address=sc.next();
		
		InstagramUser fb=new InstagramUser();
		fb.setName(name);
		fb.setEmail(email);
		fb.setPassword(password);
		fb.setAddress(address);
		
		
	    InstagramServiceInterface ip=new InstagramService();
		int result =ip.editProfileService(fb);
		if(result==0) {
			System.out.println("Action cannot be completed");
		}
		else {
			System.out.println("Profile edited successfully");
		}
	}
	
	public void deleteProfile() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to delete profile");
		String email=sc.next();
		InstagramUser fb=new InstagramUser();
		fb.setEmail(email);
		InstagramServiceInterface fu=new InstagramService();
		int result=fu.deleteProfile(fb);
		if(result==0) {
			System.out.println("Deletion Failed");
		}
		else {
			System.out.println("Profile Deleted");
		}
	}
	
	public void searchProfile() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name to search the profile");
		String name=sc.next();
		InstagramUser fb=new InstagramUser();
		fb.setName(name);
		InstagramServiceInterface fu=new InstagramService();
		List<InstagramUser> w=fu.searchProfile(fb);
		if(w.isEmpty()) {
			System.out.println("No such Profile");
		}
		else {
		for(InstagramUser user:w) {
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Address is "+user.getAddress());
		}
		}
}
	public void viewAllProfile() {
		InstagramServiceInterface fu=new InstagramService();
		List<InstagramUser> w=fu.viewAllProfile();
		if(w.isEmpty()) {
			System.out.println("No profiles to view");
		}
		else {
		for(InstagramUser user: w) {
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Address is "+user.getAddress());
		}
		}
	} 
}











