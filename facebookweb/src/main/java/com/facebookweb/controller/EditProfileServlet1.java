package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class EditProfileServlet1
 */
public class EditProfileServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		FacebookUser fb=new FacebookUser();
	    fb.setName(name);
	    fb.setPassword(password);
	    fb.setEmail(email);
	    fb.setAddress(address);
	    
	    FacebookServiceInterface fs=new FacebookService();
	    int i=fs.editProfileService(fb);
	    PrintWriter out = response.getWriter();
	    if(i>0) {
	    	out.println("Profile Edited Successfully. <a href=login.html>Login again</a>");
	    }
	    else {
	    	out.println("Profile cannot be edited");
	    }
		
	}

}
