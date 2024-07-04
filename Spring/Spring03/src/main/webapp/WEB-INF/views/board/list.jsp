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
<title>Board List</title>
	
	<style>
		th, td {
			margin: 5px;
			padding: 5px;
			min-width: 100px;
		}
	</style>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="5">게시판</th>
		</tr>
		<tr>
			<th>No.</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.seq}</td>
				<td>${list.writer}</td>
				<td>${list.title}</td>
				<td>${list.content}</td>
				<td><fmt:formatDate value="${list.write_date}" pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<button onclick="location.href='/board/insert'">글쓰기</button>
		<button onclick="location.href='/'">홈으로</button>
	</div>
	
</body>
</html>