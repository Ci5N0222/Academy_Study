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
<title>Insert title here</title>
</head>
<body>
	<form action="/board/insertProc">
		<table border="1" align="center">
			<tr>
				<th>Board Insert</th>
			</tr>
			<tr>
				<td><input type="text" name="title" placeholder="input your title"></td>
			</tr>
			<tr>
				<td><input type="text" name="content" placeholder="input your contents"></td>
			</tr>
			<tr align="center">
				<td>
					<button>작성</button>
					<button type="button" onclick="location.href='/'">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>