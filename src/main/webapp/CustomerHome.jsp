<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer</title>
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
	
		<h2 class="text-center mt-5 mb-4 ">Customer Home Page</h2>
	<div class="d-flex flex-row justify-content-end mx-5">	
	
	<a href="Login.jsp" class="btn text-dark mx-5 mt-1">
							Logout</a></div>
	<div class="py-2 bg-info mx-auto mt-2 pb-5" style="width:500px;">
	<form action="ViewPassbookController"  method="post">
		<div class="d-flex align-items-center justify-content-center mt-5">
			<button type="submit" class="btn btn-primary" id="btn1" name="btn1">Passbook</button>
			
		</div>
	</form>
	
	<form action="ReceiverAccountNumbers"  method="post">
		<div class="d-flex align-items-center justify-content-center mt-5">
			<button type="submit" class="btn btn-primary btn2" name="btn2">New Transaction</button>
			<%
				
			%>
		</div>
	</form>
	

	<form action="EditProfileFetchData"  method="post">
		<div class="d-flex align-items-center justify-content-center mt-5">
			
			<button type="submit" class="btn btn-primary" name="btn4">Edit Profile</button>

		</div>
	</form>
		</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>