<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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

	<div class="mt-5" align="center">
		<h2 class="mb-5">Login Form</h2>
		<form action="LoginController" method="post">
			<table>
				<tr class="mt-3">
					<td>Username</td>
					<td><input type="text" class="form-control" placeholder="Enter Username" name="username"></td>
				</tr>
				<tr class="mt-3">
					<td>Password</td>
					<td><input type="password" class="form-control" placeholder="Enter Password""  name="password"></td>
				</tr>
				<tr class="mt-3">
					<td>Login as (Admin or Customer):</td>
					<td><input type="text" class="form-control" placeholder="(Admin or Customer)" name="loginas"></td>
				</tr>

			</table>

			<div class="mt-4" style="text-align: center;">
				<button class="btn btn-primary">Login</button>
			</div>

		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>