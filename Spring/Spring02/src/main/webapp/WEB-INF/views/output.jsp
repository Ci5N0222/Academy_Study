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
	<style>
		th, td {
			padding: 3px;
			margin: 3px;
			text-align: center;
		}
		
		th > button {
			border: none;
			background-color: white;
			font-size: 18px;
			font-weight: 800;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th colspan="3">Output List</th>
		</tr>
		<tr>
			<th>No.</th>
			<th>writer</th>
			<th>message</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.seq}</td>
				<td>${list.writer}</td>
				<td>${list.message}</td>
			</tr>
		</c:forEach>
		<tr>
			<form action="/delete" id="delete">
				<td colspan="3">
					<input type="text" id="delete_seq" name="seq" placeholder="input No.">
					<button>Delete</button>
				</td>
			</form>
		</tr>
		<tr>
			<form action="update" id="update">
				<td colspan="3">
					<input type="text" id="update_seq" name="seq" placeholder="input No.">
					<input type="text" id="writer" name="writer" placeholder="input writer">
					<input type="text" id="message" name="message" placeholder="input Message">
					<button>Update</button>
				</td>
			</form>
		</tr>
		<tr>
			<th colspan="3"><button onclick="location.href='/'">Back</button></th>
		</tr>
	</table>
	
	<script>
	
		// delete validation
		document.querySelector("#delete").addEventListener("submit", (e) => {
			seq = document.querySelector("#delete_seq").value;
			if(seq === ""){
				alert("글 번호 입력 필요");
				e.preventDefault();
				return false;
			}
			
			if(isNaN(seq)){	
				alert("글 번호가 숫자 형식이 아님");
				e.preventDefault();
				return false;
			}
		});
		
		// update validation
		document.querySelector("#update").addEventListener("submit", (e) => {
			seq = document.querySelector("#update_seq").value;
			writer = document.querySelector("#writer").value;
			message = document.querySelector("#message").value;
	
			console.log("seq === ", seq);
			console.log("writer === ", writer);
			console.log("message === ", message);
			
			if(seq === ""){
				alert("글 번호 입력 필요");
				e.preventDefault();
				return false;
			}
			
			if(isNaN(seq)){	
				alert("글 번호가 숫자 형식이 아님");
				e.preventDefault();
				return false;
			}
			
			if(writer === "") {
				alert("글 번호 입력 필요");
				e.preventDefault();
				return false;
			}
			
			if(message === "") {
				alert("글 번호 입력 필요");
				e.preventDefault();
				return false;
			}
			
		});
	</script>
</body>
</html>