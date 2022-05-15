package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class SearchProfileServlet1
 */
public class SearchProfileServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("em");
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		List<FacebookUser> fbusers=fs.searchProfileService(fb);
		PrintWriter out=response.getWriter();
		int count=1;
		if(fbusers.size()>0) {
			for(FacebookUser i:fbusers) {
				out.println("<br><p>Details of User"+count);
				out.println("<br>Name is : "+i.getName());
				out.println("<br>Email is: "+i.getEmail());
				out.println("<br>Password is: "+i.getPassword());
				out.println("<br>Address is: "+i.getAddress());
				count+=1;
			}
		}
		else {
			out.println("No users found in the system");
		}
	}

}
