<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

	<c:choose>
		<c:when test="${ loginID != null }">
			<table border="1" align="center">
				<tr>
					<th colspan=3> ${loginID}님 환영합니다 </th>
				</tr>
				<tr>
					<td align="center"><button id="myPage">마이페이지</button></td>
					<td align="center"><button id="logout">로그아웃</button></td>
					<td align="center"><button id="memberOut">회원탈퇴</button></td>
				</tr>
				
			</table>
			<script>
				$('#myPage').on('click', function(){
					location.href="/myPage.members";
				});	
			
				$('#logout').on('click', function(){
					location.href="/signout.members";
				});
				
				$('#memberOut').on('click', function(){
					if(confirm("진짜 삭제함?")){
						location.href="/memberOut.members";
		            } else {
		            	alert("믿고있었다구!!");
		            }
				});
			</script>
		</c:when>
		<c:otherwise>
			<table border="1" align="center">
				<tr>
					<th>Login</th>
				</tr>
				<form action="/signin.members" method="post" id="loginForm">
					<tr>
						<td><input type="text" placeholder="input your id" id="id" name="id" /></td>
					</tr>
					<tr>
						<td><input type="password" placeholder="input your pw" id="pw" name="pw" /></td>
					</tr>
					<tr>
						<td align="center">
							<button>Login</button>
							<button id=signup type="button">Sign-Up</button>
						</td>
					</tr>
				</form>
			</table>
			
			<script>
				$('#signup').on("click", function(){
					location.href = "/members/signup.jsp";
				});
				
				$('#loginForm').on("submit", function(){
					if($('#id').val() == "") {
						alert("ID를 입력하세요");
						$('#id').focus();
						return false;
					}
					if($('#pw').val() == "") {
						alert("Password를 입력하세요");
						$('#pw').focus();
						return false;
					}
				});
			</script>
		</c:otherwise>
	</c:choose>

	
	
</body>
</html>