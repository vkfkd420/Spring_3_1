<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container mt-2">
		<h2 class="mt-4">Member Join Page</h2>

		<form action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" name="id">
			</div>
			<!--  id는 6글자 이상-->
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw" name="pw">
				<!-- pw는 8글자 이상 -->
			</div>
			<div class="form-group">
				<label for="pw">Password</label> <input type="password"
					class="form-control" id="pw2" name="pw">
				<!--  pw 두개는 일치 -->
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<!--  비어잇으면  X -->

			<div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control" id="email" name="email">
			</div>
			<!--  비어잇으면  X -->
			<div class="form-group">
				<label for="phone">Phone</label> <input type="text"
					class="form-control" id="phone" name="phone">
			</div>
			<!--  비어잇으면  X -->
			<button type="submit" class="btn btn-primary">Submit</button>
			<input type="button" value="JOIN" class="btn btn-primary">
		</form>
	</div>
</body>
</html>