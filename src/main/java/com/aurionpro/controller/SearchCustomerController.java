package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.CustomerConnection;
import com.aurionpro.entity.DbConnection;
import com.aurionpro.entity.UserTable;


@WebServlet("/SearchCustomerController")
public class SearchCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchCustomerController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");

		List<UserTable> name=CustomerConnection.searchCustomer(id);
		
		request.setAttribute("list", name);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("IdCustomerDetails.jsp");
		
		dispatcher.forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}