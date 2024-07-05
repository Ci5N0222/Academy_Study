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
			<form class="board-contents" action="/board/update" method="post" id="write_form">
				<input type="hidden" name="seq" id="seq" value="${ dto.seq }"/>
				<div class="board-contents-title">
					<input type="text" id="title" name="title" value="${ dto.title }" readonly>
				</div>
				<div class="board-contents-board">
					<div class="board-contents-info-box">
						<div>작성자 : ${ dto.writer }</div>
						<div>작성일 : <fmt:formatDate value="${ dto.write_date }" pattern="yyyy-MM-dd" /></div>
					</div>
					<div class="board-contents-form" id="div_contents">${ dto.content }</div>
					<div id="summernote"></div>
	            	<input type="hidden" name="content" id="contents">
					<div class="board-contents-under-box">
						<div class="board-contents-files">
							file-example01.exe
						</div>
						<div class="board-contents-board-btn">
						<c:if test="${ dto.writer eq loginID}">
				            <button type="button" id="edit-btn" onclick="editContents()">수정</button>
				            <button type="button" id="del-btn" onclick="deleteContents(${ dto.seq })">삭제</button>
				            <button type="submit" id="success-btn">확인</button>
				            <button type="button" id="cancle-btn" onclick="location.reload()">취소</button>
				        </c:if>
			            <button type="button" id="list-btn" onclick="location.href='/board/list'">목록</button>
						</div>
					</div>
					
				</div>
			</form>
		</main>
		
		<!-- board reply -->
		<main class="board-main">
			<!-- board reply insert -->
			<section class="board-reply">
				<div class="board-reply-title">댓글작성</div>
				<div class="board-reply-info">
					<div class="board-reply-writer-avater">
						<img src="/images/bg-01.jpg" alt="basic image">
					</div>
					<div class="board-reply-writer">${loginID}</div>
				</div>
				<div class="board-reply-contents">
					<div class="board-reply-contents-board" contenteditable="true">내용</div>
					<div class="board-reply-contents-btn">
						<button onclick="replyInsert()">작성하기</button>
					</div>
				</div>
			</section>
		</main>
		
		<!-- board reply -->
		<main class="board-main" id="reply-list-binding">
			
		</main>
	</div>

</body>
</html>