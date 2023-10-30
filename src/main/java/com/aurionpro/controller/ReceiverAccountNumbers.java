package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.CustomerConnection;

@WebServlet("/ReceiverAccountNumbers")
public class ReceiverAccountNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReceiverAccountNumbers() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        
		List<Long> ReceiverAccNos =CustomerConnection.findReceiverAccNos();
		//System.out.println(ReceiverAccNos);
		
		HttpSession session=request.getSession();  
        session.setAttribute("ReceiverAccNos", ReceiverAccNos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddTransaction.jsp");
		
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
