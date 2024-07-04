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
	<form action="/member/joinProc">
		<table border="1" align="center">
			<tr>
				<th>Join Form</th>
			</tr>
			<tr>
				<td>
					<input type="text" id="id" name="id" placeholder="input your id">
					<div id="result" style="display: none">1</div>
				</td>
			</tr>
			<tr>
				<td><input type="password" name="pw" placeholder="input your password"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="input your name"></td>
			</tr>
			<tr align="center">
				<td>
					<button>Join</button>
					<button type="button" onclick="location.href='/'">Cancel</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		const id = document.querySelector("#id");
		const result = document.querySelector("#result");
		
		id.addEventListener('input', async(e) => {
			let data = {
				id : e.currentTarget.value
			};
			
			if(e.currentTarget.value === ""){
				result.style.display = "none";
			} else {
				$.ajax({
					url: "/member/idcheck",
					data: data,
					dataType: "json"
				}).done(res => {
					if(res){
						result.innerHTML = "이미 사용중인 ID 입니다";
						result.style.color = "red";
						result.style.display = "block";
					} else {
						result.innerHTML = "사용 가능한 ID 입니다.";
						result.style.color = "green";
						result.style.display = "block";
					}
				});
			}
		});
		
		const ajax = async(url, method, body) => {
			let res = await fetch(url, {
			    method: method,
			    headers: {'Content-Type': 'application/json'},
			    body: JSON.stringify(body)
			});
			
			return await res.json();
		}
		
		
	</script>
</body>
</html>