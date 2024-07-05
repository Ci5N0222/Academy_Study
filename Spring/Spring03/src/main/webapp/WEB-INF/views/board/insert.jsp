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
<script src="/js/board.js"></script>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        height: 100%;
        max-width: 1448px;
        margin: 30px auto;
    }

    .container > h1 {
        text-align: center;
        margin: 50px 0;
    }

    .content-info {
        display: flex;
        flex-direction: column;
        border: 1px solid black;
        margin: 15px 0;
    }
    
    .title {
        height: 50px;
        padding: 15px;
    }

    .content {
        height: 500px;
        padding: 15px;
        overflow-y: auto;
    }

    .btn-box {
        width: 40%;
        margin: auto;
        display: flex;
        justify-content: space-around;
    }

    button {
        width: 80px;
        height: 30px;
        border: none;
        border-radius: 10px;
        background-color: antiquewhite;
        font-weight: 700;
    }

    button:hover {
        cursor:pointer;
    }
    
    .file-list {
    	min-height: 10px;
    	display:flex;
        flex-direction: column;
    }
    .file-input {
    	margin: 3px;
    }
    
    #addFile {
    	width: 100px;
    	padding: 5px;
    	margin-bottom: 5px;
    	margin-left: 5px;
    }
    
    .file-btn {
        margin: 10px;
        display: flex;
        justify-content: end;
    }

</style>

</head>
<body>

    <div class="container">
        <h1>글 쓰 기</h1>
       
        <form action="/board/insertProc" method="post" id="write_form">
	        <div class="content-info">
	            <div class="title" contenteditable="true"id="div_title"></div>
	            <input type="hidden" name="title" id="title"/>
	            <hr />
	            <div id="summernote"></div>
	            <input type="hidden" name="content" id="contents"/>

	            <div class="file-list"></div>
	            <div class="file-btn">
	            	<button type="button" id="addFile">파일 추가하기</button>
	            </div>
	        </div>
	
	        <div class="btn-box">
	            <button type="submit">작성</button>
	            <button type="button" onclick="location.href='/board/list'">목록</button>
	        </div>
        </form>
    </div>

</body>
</html>