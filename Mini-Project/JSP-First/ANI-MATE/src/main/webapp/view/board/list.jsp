<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANI-MATE</title>

<!-- head ( import ) -->
<%@ include file="/view/include/head.jsp" %>

</head>
<body>
	<!-- Navbar -->
   	<%@ include file="/view/include/header.jsp" %>
   	<br /><br /><br /><br /><br /><br /><br />
   	<button onclick="location.href='/view/board/write.jsp'">글쓰기</button>
</body>
</html>