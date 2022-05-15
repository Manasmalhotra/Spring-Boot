package com.view;

import java.util.Scanner;

import com.controller.Controller;

public class View {
	public static void main(String[] args) {
        String ss="y";
        while(ss.equals("y")) {
		System.out.println("***************Profile Menu************************** ");
		System.out.println("Press 1 for creating profile");
		System.out.println("Press 2 to view profile");
		System.out.println("Press 3 to edit profile");
		System.out.println("Press 4 to delete profile");
		System.out.println("Press 5 to view all profiles");
		
		Scanner obj=new Scanner(System.in);
		int c=obj.nextInt();
		Controller controls=new Controller();
		switch(c) {
		case 1:
			controls.createProfile();
		    break;
		case 2:
			controls.viewProfile();
		    break;
		case 3:
			controls.editProfile();
		    break;
		case 4:
			controls.deleteProfile();
		    break;
		case 5:
			controls.viewAllProfile();
			break;
		}
		
		System.out.println("Do you wish to continue? Press y for yes and n for no");
		ss=obj.next();
       }
	}     
}
