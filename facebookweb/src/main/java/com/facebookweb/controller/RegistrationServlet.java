package com.facebookweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

import java.io.PrintWriter;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	    int i=fs.createProfileService(fb);
	    request.setAttribute("result", i);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/registrationresult.jsp");
		rd.forward(request, response);
		/*
	    PrintWriter out = response.getWriter();
	    if(i>0) {
	    	out.println("Profile Registered Successfully <a href=login.html>Sign In</a>");
	    }
	    else {
	    	out.println("Profile cannot be registered");
	    }
	    */
	    
	}

}
