package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class viewProfileServlet
 */
public class viewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		Object oo=ss.getAttribute("userid");
		String email=oo.toString();
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		FacebookUser ff=fs.viewProfileService(fb);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(ff!=null) {
			out.println("Name is: "+ff.getName());
			out.println("Email is: "+ff.getEmail());
			out.println("Password is: "+ff.getPassword());
			out.println("Address is: "+ff.getAddress());
		}
		else {
			out.println("Error in getting details <a href=login.html>Sign In</a>");
		}
		
	}

}
