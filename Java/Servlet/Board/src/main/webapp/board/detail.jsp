<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
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
    
    #div_title {
    	display: none;
    }
    
    #success-btn, #cancle-btn {
   		display: none;
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
	
	const editContents = () => {
		$('h1').html("글 수정")
		$('#div_title, #success-btn, #cancle-btn').css({"display" : "block"});
		$('#writerInfo, #edit-btn, #del-btn, #list-btn').css({"display" : "none"});
		
		$('#div_title, #div_contents').attr("contenteditable", "true");
	}
	
	const deleteContent = (idx) => {
		location.href="/delete.board?idx="+idx;
	}

</script>

</head>
<body>

    <div class="container">
        <h1>${ dto.title }</h1>
       
        <form action="/update.board" method="post" id="write_form">
        	<input type="hidden" name="seq" id="seq" value="${ dto.seq }"/>
	        <div class="content-info">
	        	<div class="title" id="writerInfo">작성자 : ${ dto.writer }　　　　 조회수 : ${ dto.view_count } 　　　　 작성일 : <fmt:formatDate value="${ dto.write_date }" pattern="yyyy-MM-dd" /></div>
	            <div class="title" contenteditable="false" id="div_title">${ dto.title }</div>
	            <input type="hidden" name="title" id="title"/>
	            <hr />
	            <div class="content" contenteditable="false" id="div_contents">${ dto.contents }</div>
	            <input type="hidden" name="contents" id="contents" />
	        </div>
	
	        <div class="btn-box">
	        <c:if test="${ dto.writer eq loginID}">
	            <button type="button" id="edit-btn" onclick="editContents()">수정</button>
	            <button type="button" id="del-btn" onclick="deleteContent(${ dto.seq })">삭제</button>
	            <button type="submit" id="success-btn">확인</button>
	            <button type="button" id="cancle-btn" onclick="location.href='/detail.board?id=${dto.seq}'">취소</button>
	        </c:if>
	            <button type="button" id="list-btn" onclick="location.href='/list.board'">목록</button>
	        </div>
        </form>
        
    </div>

</body>
</html>