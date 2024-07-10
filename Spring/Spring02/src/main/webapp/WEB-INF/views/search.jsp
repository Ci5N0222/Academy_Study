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
	<fieldset>
		<legend>SelectByCon</legend>
		<form action="/search">
			<select name="column">
				<option value="writer">작성자</option>
				<option value="message">내용</option>
			</select>
			<input type="text" name="keyword">
			<button>검색</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>SelectByMultiCon</legend>
		<form action="/searchMulti">
			<input type="text" name="writer" placeholder="작성자">
			<input type="text" name="message" placeholder="내용">
			<button>작성</button>
		</form>
	</fieldset>
</body>
</html>