<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인 결과</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<style>
	table {
		width: 100%
	}
</style>

</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>아이디 중복확인 결과</th>
		</tr>
		<c:choose>
			<c:when test="${result == 0}">
				<tr>
					<td align="center">
						사용 가능한 아이디 입니다.<br /> 사용할꺼임?
					</td>
				</tr>
				<tr>
					<td align="center">
						<button id="use">사용</button>
						<button id="cancle">취소</button>
					</td>
				</tr>
				<script>
					$("#use").on("click", function(){
						opener.window.idChecking = true;
						window.close();
					});
					
					$("#cancle").on("click", function(){
						opener.document.getElementById("id").value = "";
						window.close();
					});
				</script>
				
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center">이미 사용중인 아이디 입니다.<td>
				</tr>
				<tr>
					<td align="center">
						<button id="close">닫기</button>
					</td>
					<script>
						$("#close").on("click", function(){
							opener.document.getElementById("id").value = "";
							window.close();
						});
					</script>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>