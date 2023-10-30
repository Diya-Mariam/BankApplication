<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.aurionpro.entity.ViewTransaction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
        body {
            background-image: linear-gradient(to right top, #d16ba5, #e37894, #eb8a87, #eb9e82, #e6b387, #dfc089, #d6cd92, #cbda9f, #b8e4aa, #a0edbc, #83f4d4, #5ffbf1);
        	background-size: cover;
  			background-repeat: no-repeat;
  			background-attachment: fixed;
        }
    </style>
    
</head>
<body>

<div class="container mt-5" >
		<% String heading=String.valueOf(request.getAttribute("heading")); %>
		<h2 class="text-center mt-5 mb-4 "><%= heading %></h2>
	
		<table class="table table-striped mt-5 mb-5">
			<thead>
				<tr>
					<th scope="col">Sender Account Number</th>
					<th scope="col">Receiver Account Number</th>
					<th scope="col">Type</th>
					<th scope="col">Amount</th>
					<th scope="col">Date</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				List<ViewTransaction> list;
				list = (ArrayList<ViewTransaction>) request.getAttribute("listViewTransaction");
				System.out.println(list);

				for (ViewTransaction view : list) {
					System.out.println(view);
					System.out.println(view.getSenderaccNo());
					System.out.println(view.getReceiverAccNo());
					System.out.println(view.getType());
					System.out.println(view.getAmount());
					System.out.println(view.getDate());

				%>
 				<tr> 
					<td>
 						<%=view.getSenderaccNo()%>
 					</td>
					<td> 
 						<%= view.getReceiverAccNo()%>
					</td>
					<td> 
 						<%=view.getType()%>
					</td>					
					<td> 
 						<%=view.getAmount()%>
					</td>
					<td> 
 						<%=view.getDate()%>
					</td>
				</tr> 
				<%
				}
				%>
			</tbody>
		</table>
		
		<%String goTo;
		if(heading.equals("Passbook"))
			{
			 goTo ="CustomerHome.jsp";
			}
			
			else
			{
				goTo="AdminHome.jsp";
			}%>
		<a href=<%=goTo %> class="card-link mt-5 text-dark">Go To
					Home Page</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>