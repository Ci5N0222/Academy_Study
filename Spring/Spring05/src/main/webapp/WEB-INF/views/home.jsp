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

	<style>
		* {
			box-sizing: border-box;
		}
		
		.container {
            width: 350px;
            height: 600px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            margin: 30px auto;
            border: 1px solid black;
            position: relative;
		}
		
		.messages {
			border: 1px solid black;
			width: 100%;
			height: 85%;
			overflow-y: auto;
		}
	
		.input {
			border: 1px solid black;
			width: 100%;
			height: 15%;
		}
	</style>

</head>
<body>
	<!-- 
		Web Socket : Web Browser 에서 사용하는 Socket 통신 기법
		선 Request → 후 Response 의 규칙에 제한받는 HTTP 제약을 넘어선 기능 구현을 위해 필요함.
	 -->
	 
	<div class="container">
		<div class="messages">
		</div>
		<div class="input" contenteditable="true">
		</div>
	</div>
	
	
	<script>
	
		let ws = new WebSocket("ws://192.168.1.7/chat");
	
		ws.onmessage = (e) => {
			let line = $("<div>");
			let mbox = $("<div>");
			mbox.append(e.data);
			line.append(mbox);
			$(".messages").append(line);
		}
		
		$(".input").on("keydown", (e) => {
			if(e.key === "Enter") {
				let text = $(".input").html();
				e.preventDefault();
				if(text.trim() === "") return false;
				
				ws.send(text);
				$(".input").html("");
				$(".input").focus();
			}
		});
	</script>
	
</body>
</html>