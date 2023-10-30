<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>
<%@page import="com.aurionpro.entity.UserTable"%>

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

	<div class="container mt-5">
		<h2 class="mb-5 text-center">Add Bank Details</h2>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
					<th>Password</th>
				</tr>
			</thead>


			<tbody>
				<%
				List<UserTable> std = (ArrayList<UserTable>) request.getAttribute("list");
				for (UserTable s : std) {
				%>
				<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getFirstname()%></td>
					<td><%=s.getLastname()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getRole()%></td>
					<td><%=s.getPassword()%></td>
				</tr>
				<!-- Add more rows for additional customers -->
				<%
				}
				%>
			</tbody>
		</table>

		<form action="AddBankController" class="mt-5">
			<div class="mb-5 col-6 mx-auto">
				<label for="formGroupExampleInput" class="form-label">
					Account Number</label>
				<%
				Random random = new Random();

				// Generate a random 10-digit number
				long accountno = (long) (random.nextDouble() * 9_000_000_000L + 1_000_000_000L);
				
				int id=0 ;	
				List<UserTable> list = (ArrayList<UserTable>) request.getAttribute("list");
				
				for (UserTable s : list) {
					 id = s.getId();
				}
				
				HttpSession sessionId = request.getSession();  
		        session.setAttribute("id",id);
				
				System.out.println(id);

		
				%>
				
				<input type="text" value=<%= accountno %> readonly class="form-control"
					name="accountno">
				
			</div>
				<button type="submit" class="btn btn-primary btn-sm offset-5">Submit</button>
			
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>