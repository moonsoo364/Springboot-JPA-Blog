<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<head>
  <title>Bootstrap Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<html>
<body>
	<%@ include file="../layout/header.jsp"%>
	<div class="container">
		<form>
			<div class="form-group">
				<label for="email">Username:</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
			</div>
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
			</div>
			
					
		</form>
		<button id="btn-save" class="btn btn-primary">회원가입저장</button>
	</div>
	<br/>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
	<script src="/js/user.js"> </script>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>