
package com.instagram.view;

import java.util.Scanner;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class InstagramView {

	public static void main(String[] args) {
		String ss="y";
		
		while(ss.equals("y")) {
		System.out.println("*******************MAIN MENU**********");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to delete profile");
		System.out.println("press 4 to search profile");
		System.out.println("press 5 to view all profiles");
		System.out.println("press 6 to edit profile");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter choice");
		int ch=sc.nextInt();
		
		InstagramControllerInterface f=new InstagramController();
		
		switch(ch) {
		case 1: f.createProfileController();
			break;
		case 2: f.vieweProfileController();
		break;
			
        case 3:f.deleteProfile();
			   break;
		case 4:f.searchProfile();
		break;
		case 5:f.viewAllProfile();
		       break;
		case 6:f.editProfile();
			   break;
	    default:
	    	   System.out.println("Wrong choice selected");
		}
		System.out.println("continue press y/n");
		ss=sc.next();
		}
		
		

	}

}
