<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<head>
	<title>Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${loginID != null }">
			<table border="1" align="center">
				<tr>
					<th colspan="4"> ${loginID}님 환영합니다 </th>
				</tr>
				<tr>
					<td><button type="button" id="board" >게시판</button></td>
					<td><button type="button" id="mypage" >마이페이지</button></td>
					<td><button type="button" id="logout" >로그아웃</button></td>
					<td><button type="button" id="memberDelete" >회원탈퇴</button></td>
				</tr>
			</table>
			
			<script>
				const board = document.querySelector("#board");
				const mypage = document.querySelector("#mypage");
				const logout = document.querySelector("#logout");
				const memberDelete = document.querySelector("#memberDelete");
				
				/** 게시판 이동 **/
				board.addEventListener("click", () => {
					location.href = "/board/list";
				});
				
				/** 마이페이지 이동 **/
				mypage.addEventListener("click", () => {
					location.href = "/member/mypage";
				});
				
				/** 로그아웃 **/
				logout.addEventListener("click", () => {
					$.ajax({
						url: "/member/logout"
					}).done(res => {
						if(res === "ok") location.href = "/";
					});
				});
				
				/** 회원탈퇴 **/
				memberDelete.addEventListener("click", () => {
					$.ajax({
						url: "/member/delete?id=${loginID}"
					}).done(res => {
						if(res === "ok") location.href = "/";
						else alert("회원탈퇴 실패");
					});
				});
				
			</script>
		</c:when>
		
		<c:otherwise>
			<form action="/member/login" method="post" id="loginForm">
				<table border="1" align="center">
					<tr>
						<th>Login</th>
					</tr>
					<tr>
						<td><input type="text" id="id" name="id" placeholder="input your id"></td>
					</tr>
					<tr>
						<td><input type="password" id="pw" name="pw" placeholder="input your password"></td>
					</tr>
					<tr align="center">
						<td>
							<button>Login</button>
							<button type="button" id="loginTest" >Test</button>
							<button type="button" onclick="location.href='/member/join'">Join</button>
						</td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
	

</body>
</html>
