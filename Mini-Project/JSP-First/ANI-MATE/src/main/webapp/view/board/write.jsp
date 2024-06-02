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
<script src="/js/board.js"></script>
</head>
<body>
	<!-- Navbar -->
   	<%@ include file="/view/include/header.jsp" %>
   	
   	<div style="height: 140px;"></div>
   	
  
   	<div class="container">
   	 	<h2>글쓰기</h2>
   		<div id="summernote"></div>
   	</div>
   	
   	<form action="" method="post" id="boardWriteForm">
   		<input type="hidden" name="contents" id="contents" value="">
   		<button type="submit">글쓰기</button>
   		<button type="button" onclick="location.href='/view/board/list.jsp'">취소</button>
   	</form>
   	
   	<script>
   	
   	$("#boardWriteForm").on("submit", () => {
   		$('#contents').val($("#summernote").summernote('code'));
   		
   		alert($("#summernote").summernote('code'));
   		
   		if($('#contents').val() === ""){
   			alert("작성된 내용 없음");
   			return false;
   		}
   		
   		alert($('#contents').val());
   		
   		return false;
   		
   	});
   	
   	</script>
   	
</body>
</html>