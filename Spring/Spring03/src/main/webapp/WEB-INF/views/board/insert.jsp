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

<!-- summernote -->
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/js/board.js"></script>

</head>
<body>

    <div class="board-container">
		<main class="board-main">
	        <h1>글 쓰 기</h1>
	        <form class="board-contents" action="/board/insertProc" method="post" id="write_form" enctype="multipart/form-data">
		        
		        <div class="board-contents-board">
			        <div class="board-insert-title">
		            	<input type="text" name="title" id="title" placeholder="제목을 입력하세요"/>
		            </div>
		            <div id="summernote"></div>
		            <input type="hidden" name="content" id="contents"/>
	
		            <div class="file-list">
		            	<input type="file" name="files" multiple>
		            </div>
		        </div>
		
		        <div class="board-contents-board-btn">
		            <button type="submit">작성</button>
		            <button type="button" onclick="location.href='/board/list'">목록</button>
					
		        </div>
	        </form>
        </main>
    </div>

</body>
</html>