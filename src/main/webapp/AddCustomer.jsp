<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Customer</title>
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
<div  class="container">
	<h1 class="mt-5 text-center">Add Customer</h1>
	
	<form action="AddCustomerController" method="post" class="row g-3 mt-3">
  		<div class="col-md-6 mx-auto">
		    <label for="inputPassword" class="col-sm-2 form-label">First Name</label>
		    <div class="col-sm-10">
		      <input type="text" required class="form-control" name="firstname" placeholder="Enter First Name">
		    </div>
		</div>
		 <div class="col-6 mx-auto">
		    <label for="inputPassword" class="col-sm-2 form-label mt-3">Last Name</label>
		    <div class="col-sm-10">
		      <input type="text" required class="form-control" name="lastname" placeholder="Enter Last Name">
		    </div>
		</div>
		 <div class="col-6 mx-auto">
		    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
		   <div class="col-sm-10">
		      <input type="text" required class="form-control" name="email" placeholder="Enter email" id="inputPassword">
		    </div>
	  	</div>
		 <div class="col-6 mx-auto">
		    <label for="inputPassword" class="col-sm-2 col-form-label">Role</label>
		    <div class="col-sm-10">
		      <input type="text" required class="form-control" name="role" placeholder="Enter role" id="inputPassword">
		    </div>
		</div>
		 <div class="col-6  mx-auto">
		    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
		    <div class="col-sm-10">
		      <input type="password" required class="form-control" name="password" placeholder="Enter password" id="inputPassword">
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