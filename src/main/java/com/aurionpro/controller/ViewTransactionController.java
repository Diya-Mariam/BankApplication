package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.entity.CustomerConnection;
import com.aurionpro.entity.ViewCustomers;
import com.aurionpro.entity.ViewTransaction;


@WebServlet("/ViewTransactionController")
public class ViewTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewTransactionController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//String id = request.getParameter("id");
		
		List<ViewTransaction> list = CustomerConnection.viewTransaction();
		//System.out.println(list);

		request.setAttribute("listViewTransaction", list);
		request.setAttribute("heading", "Transaction History");
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTransaction.jsp");
		
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}