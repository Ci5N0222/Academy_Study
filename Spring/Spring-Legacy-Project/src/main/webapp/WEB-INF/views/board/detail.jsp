<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	글번호 : ${ dto.board_seq } <br />
	작성자 : ${ dto.board_writer } <br />
	제목 : ${ dto.board_title } <br />
	내용 : ${ dto.board_content } <br />
	작성일 : ${ dto.write_date } <br />
	
	<form action="/board/delete?seq=${ dto.board_seq }" method="POST">
		<button>삭제</button>
	</form>
	<a href="/board"> 목록 </a><br />
	
</body>
</html>