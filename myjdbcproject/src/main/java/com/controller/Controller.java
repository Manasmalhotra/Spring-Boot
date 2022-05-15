package com.controller;

import java.util.List;
import java.util.Scanner;

import com.entity.User;
import com.service.Service;
import com.service.ServiceInterface;

public class Controller {

	public void createProfile() {
		System.out.println("Enter details to create profile");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name=sc.next();
		System.out.println("Enter your email: ");
		String email=sc.next();
		System.out.println("Enter your address: ");
		String address=sc.next();
		System.out.println("Enter mobile number");
		String mobile=sc.next();
		
		User u=new User();
		u.setName(name);
		u.setEmail(email);
		u.setAddress(address);
		u.setMobile(mobile);
		
		ServiceInterface s=new Service();
		int i=s.createProfileService(u);
		if(i>0) {
			System.out.println("Profile Created Successfully");
		}
		else {
			System.out.println("Some error occurred. Please try again..");
		}
	}

	public void viewProfile() {
		System.out.println("Please enter email");
		Scanner sc=new Scanner(System.in);
		String email=sc.next();
		User u=new User();
		u.setEmail(email);
		ServiceInterface s=new Service();
		User f=s.viewProfileService(u);
		System.out.println("User Details: ");
		System.out.println("Name: "+f.getName());
		System.out.println("Email: "+f.getEmail());
		System.out.println("Address: "+f.getAddress());
		System.out.println("Mobile: "+f.getMobile());
		return;
	}

	public void editProfile() {
		System.out.println("Please enter email");
		Scanner sc=new Scanner(System.in);
		String email=sc.next();
		User u=new User();
		u.setEmail(email);
		ServiceInterface s=new Service();
		User f=s.viewProfileService(u);
		if(f==null) {
			System.out.println("No such user exists");
		}
		else {
			System.out.println("Re-enter the details for tis email for updating record");
			System.out.println("Enter name:");
			u.setName(sc.next());
			System.out.println("Enter address: ");
			u.setAddress(sc.next());
			System.out.println("Enter mobile number: ");
			u.setMobile(sc.next());
			ServiceInterface ss=new Service();
			int i=ss.editProfile(u);
			if(i>0) {
				System.out.println("Profile Edited Successfully");
			}
			else {
				System.out.println("Profile not edited");
			}
		}
	}

	public void deleteProfile() {
		System.out.println("Please enter email");
		Scanner sc=new Scanner(System.in);
		String email=sc.next();
		User u=new User();
		u.setEmail(email);
		ServiceInterface s=new Service();
		int i=s.deleteProfile(u);
		if(i>0) {
			System.out.println("Profile Deleted Successfully");
		}
		else {
			System.out.println("Profile Not Deleted");
		}
		
	}

	public void viewAllProfile() {
		ServiceInterface s=new Service();
		List<User>ll=s.viewAllProfile();
		if(ll.isEmpty()) {
			System.out.println("No user found");
		}
		else {
			int count=1;
			for(User u:ll) {
				System.out.println("Details of user "+count+": ");
				System.out.println("Name: "+u.getName());
				System.out.println("Email: "+u.getEmail());
				System.out.println("Address: "+u.getAddress());
				System.out.println("Mobile Number: "+u.getMobile());
			}
		}
	}

}
