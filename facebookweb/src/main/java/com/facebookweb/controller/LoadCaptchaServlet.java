package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadCaptchaServlet
 */
public class LoadCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=(int)((Math.random())*10000);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<input type=text id=c1  value="+i+"><input type=button value=refresh onclick=loadCaptcha()>");
		out.println("enter above value <input type=text id=c2 onblur=validateCaptcha()>");
	}

}
