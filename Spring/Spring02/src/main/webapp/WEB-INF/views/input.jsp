<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/inputProc" method="post">
		<table border="1" align="center">
			<tr>
				<th>Input</th>
			</tr>
			<tr>
				<td><input type="text" name="writer" placeholder="input your name"></td>
			</tr>
			<tr>
				<td><input type="text" name="message" placeholder="input message"></td>
			</tr>
			<tr>
				<td align="center"><button>제출</button> <button type="button" id="back">뒤로가기</button></td>
			</tr>
		</table>
	</form>
	
	<script>
		document.querySelector("#back").addEventListener("click", () => {
			location.href = "/";	
		});
		
	</script>
	
</body>
</html>