<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�۹�ȣ : ${ dto.board_seq } <br />
	�ۼ��� : ${ dto.board_writer } <br />
	���� : ${ dto.board_title } <br />
	���� : ${ dto.board_content } <br />
	�ۼ��� : ${ dto.write_date } <br />
	
	<form action="/board/delete?seq=${ dto.board_seq }" method="POST">
		<button>����</button>
	</form>
	<a href="/board"> ��� </a><br />
	
</body>
</html>