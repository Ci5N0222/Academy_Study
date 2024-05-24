<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	state : 1 = insert / 2 = delete / 3 = update
	<c:if test=${ stat == 1 }>영화 목록 추가에</c:if>
	<c:if test=${ stat == 2 }>영화 목록 삭제에</c:if>
	<c:if test=${ stat == 3 }>영화 목록 수정에</c:if>
	실패하였습니다.
</body>
</html>