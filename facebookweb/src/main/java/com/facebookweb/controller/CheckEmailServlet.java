package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckEmailServlet
 */
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String email=request.getParameter("email");
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   if(email.equals("abc@yahoo.com")) {
		   out.println("This email is already taken!");
	   }
	   else {
		   out.println("Valid Email");
	   }
	}

}
