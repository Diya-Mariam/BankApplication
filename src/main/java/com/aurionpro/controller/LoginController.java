package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.CustomerConnection;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String loginas = request.getParameter("loginas");
		
		HttpSession session = request.getSession(); // Get or create a session
		session.setAttribute("username", username);

		//System.out.println(username);
		if(loginas.toLowerCase().equals("customer"))
		{
			boolean isPresent = CustomerConnection.checkLogin(username, password, loginas);
			//System.out.println(isPresent);
			if(isPresent)
			{
				RequestDispatcher dispatcher = null;
				HttpSession session4=request.getSession();  
		        session.setAttribute("username",username);  
		        
				dispatcher = request.getRequestDispatcher("CustomerHome.jsp");
				

				dispatcher.forward(request, response);
			}
		}
		else if(loginas.toLowerCase().equals("admin"))
		{
			boolean isPresent = CustomerConnection.checkLogin(username, password, loginas);
			//System.out.println(isPresent);

			if(isPresent)
			{
				RequestDispatcher dispatcher = null;
				
				dispatcher = request.getRequestDispatcher("AdminHome.jsp");
				

				dispatcher.forward(request, response);
			}
			
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer1 = response.getWriter();
			
			writer1.print("Login Failed");
		}
		
		
		writer.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
