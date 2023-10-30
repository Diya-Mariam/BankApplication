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


@WebServlet("/AddTransactionController")
public class AddTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddTransactionController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session=request.getSession(false);  
        String username=(String) session.getAttribute("username");
        
		String type = request.getParameter("type");
		String receiverAcc = request.getParameter("receiverAccNo");
		String amount = request.getParameter("amount");
		//System.out.println(username);
		
		

		String accNo=CustomerConnection.findSenderAccNo(username);
		
	
		
		CustomerConnection.addTransaction(accNo, type, receiverAcc, amount );
		//CustomerConnection.updateBalance();

		RequestDispatcher dispatcher = null;
		
		dispatcher = request.getRequestDispatcher("TransactionAdded.jsp");
		
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
