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
import javax.servlet.http.HttpSession;

import com.aurionpro.entity.CustomerConnection;
import com.aurionpro.entity.EditProfile;


@WebServlet("/EditProfileFetchData")
public class EditProfileFetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditProfileFetchData() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session1 = request.getSession(false); 
		String username = (String) session1.getAttribute("username");
		System.out.println(username);
		
		List<EditProfile> list=CustomerConnection.fetchProfileData(username);
		System.out.println(list);
		 
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("EditProfile.jsp");
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
