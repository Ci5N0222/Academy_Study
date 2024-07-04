<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>My Page</title>

	<style>
		th, td {
			width: 120px;
			margin: 5px;
			padding: 5px;
			text-align: center;
		}
	
		input {
			width: 150px;
		}
		
		button {
			border: none;
			background-color: white;
			font-size: 20px;
			font-weight: 700;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="3">마이페이지</th>
		</tr>
		<tr>
			<th colspan="2">아이디</th>
			<th>이름</th>
		</tr>
		<tr>
			<td colspan="2">${dto.id}</td>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<form action="/member/update" method="post">
				<td><input type="text" name="name" placeholder="input your name"></td>
				<td><button>Update</button></td>
				<td><button type="button" onclick="location.href='/'">Home</button></td>
			</form>
		</tr>
	</table>
</body>
</html>