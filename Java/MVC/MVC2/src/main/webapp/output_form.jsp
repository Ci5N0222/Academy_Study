<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
</head>
<body>
	
	<button onclick="location.href='/'">Home</button>

	<table border=1 align='center'>
		<tr>
			<th>No.</th>
			<th>Title</th>
			<th>Genre</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<c:forEach var="list" items="${ movieList }">
			<tr>
				<td>${list.id }</td>
				<td>${ list.title }</td>
				<td>${ list.genre }</td>
				<td><button onclick="location.href='/DeleteServlet?id=${ list.id }'">Delete</button></td>
				<td><button onclick="location.href='/UpdateServlet?id=${ list.id }'">Update</button></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>