<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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

	<div class="container">
		<h2 class="text-center my-5">Add Bank Account</h2>
		
		<form action="SearchCustomerController" method="post">
			<div class="row">
				
				<div class="col-sm-10">
					<input type="text" required class="form-control" name="id"
						placeholder="Search Customers with customer id">
				</div>
				<button type="submit" class="btn btn-primary btn-sm">Submit</button>
				
			</div>
		</form>
	</div>

</body>
</html>