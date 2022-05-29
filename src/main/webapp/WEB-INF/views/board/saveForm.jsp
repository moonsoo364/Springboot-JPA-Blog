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
				<input type="text" class="form-control" placeholder="Enter title" id="title">
			</div>

			<div class="form-group">
				<textarea class="form-control summernote" rows="5" id="content"></textarea>
			</div>
		</form>
		<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
	</div>
	<script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script src="/js/board.js"></script>
	<br />
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>