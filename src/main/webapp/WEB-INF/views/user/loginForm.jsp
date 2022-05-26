<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<head>
  <title>Bootstrap Example</title>
  <meta contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" >
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<html>
<body>
	<%@ include file="../layout/header.jsp"%>
	<div class="container">
		<form action="/auth/loginProc" method="post">
			<div class="form-group">
				<label for="username" >Username:</label> 
				<input name="username"  type="text" class="form-control" placeholder="Enter username" id="username">
			</div>

			<div class="form-group">
				<label for="password" >Password:</label>
				<input name="password" type="password" class="form-control" placeholder="Enter password" id="password">
			</div>
			
			<button id="btn-login" class="btn btn-primary">로그인</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
	<br/>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>