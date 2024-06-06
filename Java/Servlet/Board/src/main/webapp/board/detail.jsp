<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- summernote -->
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css" />
<script src="/js/board.js"></script>
<script src="/js/reply.js"></script>

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
        min-height: 250px;
        padding: 15px;
        overflow-y: auto;
    }

    .btn-box {
        margin: 10px;
        display: flex;
        justify-content: end;
    }
    
    .btn-box > button {
    	margin-left: 4px;
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
   	
   	.reply-form {
   		display: flex;
   		margin-bottom: 15px;
   		
   	}
   	
   	.reply-form > .reply-input {
   		flex: 4;
   		height: 40px;
   		border-radius: 5px;
   		margin: 2px;
   		padding-left: 3px;
   	}
   	
   	.reply-form > .reply-btn {
   		flex: 1;
   		height: 40px;
   		background-color: skyblue;
        border-radius: 5px;
   		margin: 2px;
   	}

	.reply-board {
		padding: 12px;
	}
	
	.reply-writer {
		font-weight: 700;
		font-size: 16px;
	}
	
	.reply-write_date {
		font-size: 12px;
		color: gray;
		margin-left: 5px;
	}
	
	.reply-contents {
		padding: 10px;
		padding-left: 0;
	}
	
	.reply-btn-box {
		display: flex;
		justify-content: end;
	
	}
	
	.reply-btn-box > button{
		width: 60px;
		height: 30px;
		background-color: lightgrey;
        margin-left: 10px;
	}
	
	.no-reply {
		text-align: center;
		margin-top: 40px;
	}
	
	.reply_success, .reply_cancel {
		display: none;
	}
	
	#summernote {
		display: none;
	}
	
	#files {
		display: flex;
        flex-direction: column;
	}
	
	#files > span {
		margin: 5px;
	}
	
</style>

<script>

	const parent_seq = ${dto.seq};
	const loginID = "${loginID}";
	
	$(() => {
		
		// 게시글 수정 validation
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
		
		
		// 댓글 입력 validation
		$(".reply-form").on("submit", function(){
			if($(".reply-input").val() == ""){
				alert("댓글 내용 없음");
				return false;
			}
		});
		
		
		getReply(parent_seq, loginID);

		
		$(".reply_edit").on("click", function(e){
			console.log(this);
		});
		

	});
	
	// 댓글 목록 ajax
	const getReply = (seq, loginID) => {
		$.ajax({
			url: "/list.reply",
			data: {
				seq
			},
			dataType: "json"
		})
		.done(function(res){
			console.log(res);
			if(res.length === 0){
				let item = "<h2>관심이 필요한 게시글 입니다. 댓글을 남겨주세요</h2>";
				$(".reply-container").append(item);
			} else {
				res.forEach(item => {
					$(".reply-container").append(replyList(item, loginID));
				});
			}
		});
	}
	

	
	// 게시글 수정하기
	const editContents = () => {
		$('h1').html("글 수정")
		$('#div_title, #success-btn, #cancle-btn, #summernote').css({"display" : "block"});
		$('#writerInfo, #edit-btn, #del-btn, #list-btn, #div_contents').css({"display" : "none"});
		
		$('#div_title').attr("contenteditable", "true");
	}
	
	// 게시글 삭제
	const deleteContent = (idx) => {
		location.href="/delete.board?idx="+idx;
	}
	
	// 댓글 삭제
	function deleteReply(seq, parent_seq){
		$.ajax({
			url:"/delete.reply",
			data: {
				seq,
				parent_seq
			},
			dataType: "json"
		})
		.done(function(res){
			console.log("res === ", res);
			if(res > 0){
				$(".reply-container").html("");
				getReply(parent_seq, loginID)
			}
		});
	}

</script>

</head>
<body>

    <div class="container">
        <h1>${ dto.title }</h1>
       
        <form action="/update.board" method="post" id="write_form">
        	<input type="hidden" name="seq" id="seq" value="${ dto.seq }"/>
	        <div class="content-info">
	        	<div class="title" id="writerInfo">작성자 : ${ dto.writer }　　 조회수 : ${ dto.view_count } 　　　작성일 : <fmt:formatDate value="${ dto.write_date }" pattern="yyyy-MM-dd" /></div>
	            <div class="title" contenteditable="false" id="div_title">${ dto.title }</div>
	            <input type="hidden" name="title" id="title"/>
	            <hr />
	            
	            <c:if test="${ files.size() != 0 }">
	            	<div id="files">
		            	<c:forEach var="files" items="${ files }">
		            		<span><a href="/download.file?oriname=${files.oriname}&sysname=${files.sysname}">${ files.oriname }</a></span>
		            	</c:forEach>
		            	<hr />
		            </div>
	            </c:if>
	            
	            <div class="content" contenteditable="false" id="div_contents">${ dto.contents }</div>
	            <input type="hidden" name="contents" id="contents" />
	            <div class="btn-box">
			        <c:if test="${ dto.writer eq loginID}">
			            <button type="button" id="edit-btn" onclick="editContents()">수정</button>
			            <button type="button" id="del-btn" onclick="deleteContent(${ dto.seq })">삭제</button>
			            <button type="submit" id="success-btn">확인</button>
			            <button type="button" id="cancle-btn" onclick="location.href='/detail.board?id=${dto.seq}'">취소</button>
			        </c:if>
		            <button type="button" id="list-btn" onclick="location.href='/list.board'">목록</button>
		        </div>
	        </div>
        </form>
        
        <form class="reply-form" action="/insert.reply" method="post">
        	<input class="reply-input" type="text" name="reply_contents" placeholder=" 댓글을 입력하세요" />
        	<input class="reply-input" type="hidden" name="parent_seq" value=${ dto.seq } />
        	<button class="reply-btn">등록</button>
        </form>
        
        <!-- 댓글 목록 -->
        <div class="reply-container"></div>
        
    </div>

</body>
</html>