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
				<th>카페메뉴 추가하기</th>
			</tr>
			<tr>
				<td><input type="text" name="menu" placeholder="input menu name"></td>
			</tr>
			<tr>
				<td><input type="text" name="price" placeholder="input menu price"></td>
			</tr>
			<tr>
				<td align="center"><button>추가</button> <button type="button" id="back">취소</button></td>
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