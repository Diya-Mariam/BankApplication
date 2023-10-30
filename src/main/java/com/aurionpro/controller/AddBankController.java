package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.CustomerConnection;


@WebServlet("/AddBankController")
public class AddBankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public AddBankController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String accountno = request.getParameter("accountno");
		
		 HttpSession session=request.getSession(false);  
	     int id=(int) session.getAttribute("id"); 

		CustomerConnection.addBankDetails(id, accountno);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BankAccountAdded.jsp");
		

		dispatcher.forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

