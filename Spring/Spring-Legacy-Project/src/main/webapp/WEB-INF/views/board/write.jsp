<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<script>
		const validation = () => {
			let title = document.querySelector("#board_title").value;
			let content = document.querySelector("#board_content").value;
			
			if(title.trim() === "") {
				alert("������ �Է��ϼ���.");
				return false;
			}
			if(content.trim() === "") {
				alert("������ �Է��ϼ���.");
				return false;
			}

			return true;
		}		
		
	</script>

	�۾��� <br />
	<form action="/board" method="POST" onsubmit="return validation()">
		<input type="text" id="board_title" name="board_title" placeholder="���� �Է�"> <br />
		<input type="text" id="board_content" name="board_content" placeholder="���� �Է�"> <br />
		<button type="submit">���</button>
		<button type="button" onClick="location.href='/board'">���</button>
	</form>
</body>
</html>