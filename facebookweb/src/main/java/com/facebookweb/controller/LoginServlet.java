package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookService;
import com.facebookweb.service.FacebookServiceInterface;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("em");
		String password=request.getParameter("pass");
		
		FacebookUser fb=new FacebookUser();
		fb.setEmail(email);
		fb.setPassword(password);
		
	    FacebookServiceInterface fs=new FacebookService();
	    int result=fs.checkloginService(fb);
	    
	   /* PrintWriter out=response.getWriter();
	    if(result>0) {
	    	HttpSession ss=request.getSession(true);
	    	ss.setAttribute("userid", email);
	    	ss.setMaxInactiveInterval(60);
	    	
	    	out.println("welcome "+email);
			out.println("<a href=viewProfileServlet>view profile</a>");
			out.println("<a href=editProfileServlet>edit profile</a>");
			out.println("<a href=SearchProfileServlet>search profile</a>");
			out.println("<a href=DeleteProfileServlet>delete profile</a>");
			out.println("<a href=viewAllProfileServlet>view all profile</a>");
	    }
	    else {
	    	out.println("Invalid id and password <a href=login.html>login again</a>");
	    }
	    */
	    if(result>0) {
	    	HttpSession ss=request.getSession(true);
	    	ss.setAttribute("userid", email);
	    	ss.setMaxInactiveInterval(60);

	    }
	    
	    request.setAttribute("result", result);
	    request.setAttribute("email", email);
	    RequestDispatcher rd=getServletContext().getRequestDispatcher("/loginresult.jsp");
	    rd.forward(request, response);
	    
	    
	}

}
