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
				alert("제목을 입력하세요.");
				return false;
			}
			if(content.trim() === "") {
				alert("내용을 입력하세요.");
				return false;
			}

			return true;
		}		
		
	</script>

	글쓰기 <br />
	<form action="/board" method="POST" onsubmit="return validation()">
		<input type="text" id="board_title" name="board_title" placeholder="제목 입력"> <br />
		<input type="text" id="board_content" name="board_content" placeholder="내용 입력"> <br />
		<button type="submit">등록</button>
		<button type="button" onClick="location.href='/board'">취소</button>
	</form>
</body>
</html>