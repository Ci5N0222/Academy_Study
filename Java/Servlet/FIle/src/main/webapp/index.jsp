<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

	<form action="upload.file" method="post" enctype="multipart/form-data">
		<input type="text" placeholder="메세지" name="message"><br /><br />
		<div class="file-box">
			첨부파일1 : <input type="file" name="file1"><br />
			첨부파일2 : <input type="file" name="file2"><br />
			첨부파일3 : <input type="file" name="file3"><br /><br />
		</div>
		<button>등록</button>
		
	</form>
	
	<fieldset>
		<legend>File List</legend>
		<div id="filelist">
			<c:if test="${ list.size() != 0 }">
				<c:forEach var="list" items="${ list }">
					<p>${list.seq}. ${list.oriname}</p>
				</c:forEach>
			</c:if>
			<c:if test="${ list.size() == 0 }">
				첨부파일 없음
			</c:if>
			
		</div>
	</fieldset>
	
	<a href="/list.file">
		<button>파일 목록 불러오기</button>
	</a>
	
</body>
</html>