<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>


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
</head>
<body>
	<div class="container">
		<h1 class="mt-5 text-center">Add Transaction</h1>

		<form action="AddTransactionController" method="post"
			class="row g-3 mt-3">
			<div class="col-md-6 mx-auto">
				<label for="inputPassword" class="col-sm-2 form-label">Type
					of Transaction</label>
				<div class="col-sm-10">
					<input type="text" required class="form-control" name="type"
						placeholder="Enter type of Transaction">
				</div>
			</div>
			<div class="col-6 mx-auto">
				<label for="inputPassword" class="form-label mt-3 mb-2">Receiver
					Account (Only for transfer)</label>
				<div class="col-sm-10">
					<!--   <input type="text" class="form-control" name="receiverAcc" placeholder="Enter Receiver Account (null for debit & credit)">   -->

					<div class="form-group">
						<label for="dropdown" class="mb-3">Select an account number:</label> 
						<select
							class="form-control" id="dropdown" name= "receiverAccNo">
							<option value="null">null</option>
							<c:forEach items="${sessionScope.ReceiverAccNos}" var="value">
								<option value="${value}">${value}</option>
							</c:forEach>
						</select>
					</div>

				</div>
			</div>
			<div class="col-6 mx-auto">
				<label for="staticEmail" class="col-sm-2 col-form-label">Amount</label>
				<div class="col-sm-10">
					<input type="text" required class="form-control" name="amount"
						placeholder="Enter Amount" id="inputPassword">
				</div>
			</div>

			<div class="col-6 items-center mb-3 mx-auto">
				<button type="submit" class="btn btn-primary form-control">Submit</button>
			</div>

		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>