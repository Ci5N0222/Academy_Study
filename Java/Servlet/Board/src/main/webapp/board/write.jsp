<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

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

</style>

<script>
	$(() => {
		
		$("#write_form").on("submit", function(){
			
			$('#title').val($('#div_title').html());
			$('#contents').val($('#div_contents').html());
			
			if($('#title').val() == "" || $('#title').val() == "제목을 입력하세요") {
				alert("제목 입력안함");
				return false;
			}
			
			if($('#contents').val() == "" || $('#contents').val() == "내용을 입력하세요") {
				alert("내용 입력안함");
				return false;
			}
			
		});
		
	});

</script>

</head>
<body>

    <div class="container">
        <h1>글 쓰 기</h1>
       
        <form action="/write.board" method="post" id="write_form">
	        <div class="content-info">
	            <div class="title" contenteditable="true"id="div_title">제목을 입력하세요</div>
	            <input type="hidden" name="title" id="title"/>
	            <hr />
	            <div class="content" contenteditable="true"id="div_contents">내용을 입력하세요</div>
	            <input type="hidden" name="contents" id="contents"/>
	        </div>
	
	        <div class="btn-box">
	            <button type="submit">작성</button>
	            <button type="button" onclick="location.href='/list.board'">목록</button>
	        </div>
        </form>
        
    </div>

</body>
</html>