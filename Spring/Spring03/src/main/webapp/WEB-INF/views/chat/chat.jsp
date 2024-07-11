<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- Font-Awesome -->
<script src="https://kit.fontawesome.com/a0900b741f.js"
	crossorigin="anonymous"></script>

<style>
* {
	box-sizing: border-box;
	margin: 0;
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

.header {
	height: 80px;
	display: flex;
	flex-direction: column;
}

.header>.form-control {
	flex: 1;
	display: flex;
	justify-content: end;
	margin: 3px;
}

.header>.form-control>button {
	border: none;
	background-color: white;
	font-size: 16px;
}

.header>.form-control>button:hover {
	cursor: pointer;
}

.header>.chat-header {
	flex: 5;
	background-color: skyblue;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.header>.chat-header>.chat-info {
	display: flex;
}

#chat-img {
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 5px 10px;
}

#chat-img>img {
	border-radius: 10px;
}

.chat-room-info {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: start
}

.chat-room-info>#chat-title {
	font-size: 14px;
	font-weight: 700;
}

.chat-room-info>#chat-count {
	font-size: 11px;
	color: gray
}

.header>.chat-header>.chat-btn {
	display: flex;
}

.chat-btn>button {
	margin-right: 5px;
	border: none;
	background-color: transparent;
}

.chat-btn>button:hover {
	cursor: pointer;
}

.output-form {
	flex: 6;
	overflow-y: auto;
	background-image: url(/images/chat-bg.jpg);
	background-size: cover;
	word-break: break-all;
}

.input-form {
	flex: 2;
	display: flex;
	flex-direction: column;
	word-break: break-all;
	overflow: auto;
}

.input {
	flex: 3;
	word-break: break-all;
	overflow: auto;
}

.button-list {
	display: flex;
	justify-content: space-between;
	padding: 5px;
	background-color: #f8f2f2ee;
}

.buttons>button {
	font-size: 16px;
	background-color: transparent;
	border: none;
	padding: 5px;
	margin-right: 3px;
}

.buttons>button:hover {
	cursor: pointer;
}

.button-list>.send-btn {
	width: 60px;
	font-size: 14px;
	background-color: darkgray;
	color: white;
	border: none;
	border-radius: 5px;
	padding: 5px;
}

.button-list>.send-btn:hover {
	cursor: pointer;
}

.chat-form {
	padding: 10px;
}

.chat-form>.writer {
	display: flex;
	justify-content: end;
	align-items: center;
}

.chat-form>.content {
	display: flex;
	justify-content: end;
	align-items: center;
	padding: 4px;
	margin-top: 3px;
}

.chat-form>.content>div {
	background-color: yellow;
	border-radius: 5px;
	padding: 5px 8px;
	max-width: 250px;
}

.chat-form>.unother {
	display: flex;
	justify-content: start;
	align-items: center;
}

.chat-form>.unother>p {
	color: white;
}

.chat-form>.unother-content {
	display: flex;
	justify-content: start;
	align-items: center;
	padding: 4px;
	margin-top: 3px;
}

.chat-form>.unother-content>div {
	background-color: #eee;
	border-radius: 5px;
	padding: 2px 5px;
	max-width: 250px;
}

/* 임시 */
#image {
	background-color: plum;
	width: 25px;
	height: 25px;
	border-radius: 30%;
	margin-right: 5px;
}

.date {
	color: white;
	font-size: 10px;
	margin: 0 5px;
}

.output-form::-webkit-scrollbar {
	width: 5px;
}

.output-form::-webkit-scrollbar-thumb {
	background-color: lightgrey;
}

.output-form::-webkit-scrollbar-track {
	background-color: #eee;
}

.icon-modal {
	display: none;
	flex-direction: column;
	width: 200px;
	height: 300px;
	position: absolute;
	left: -210px;
	bottom: 0;
	margin: auto;
	z-index: 1;
	border: 1px solid black;
}

.emoticon-header {
	flex: 1;
	display: flex;
	justify-content: end;
	align-items: center;
	padding: 3px 6px;
}

.emoticon-header>button {
	border: none;
	background-color: transparent;
}

.emoticon-header>button:hover {
	cursor: pointer;
}

.emoticon-list {
	flex: 2;
	background-color: beige;
	display: flex;
	justify-content: start;
	align-items: center;
}

.emoticon-list>button {
	border: none;
	background-color: transparent;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: 10px;
}

.emoticon-list>button:hover {
	cursor: pointer;
}

.emoticon-info {
	flex: 10;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	align-items: center;
	overflow-y: auto;
}

.emo-btn:hover {
	cursor: pointer;
}

.emoticon-preview {
	display: none;
	flex-direction: column;
	width: 348px;
	height: 120px;
	background-color: lightblue;
	position: absolute;
	bottom: 129px;
	z-index: 3;
	opacity: 0.7;
}

.preview-header {
	display: flex;
	justify-content: end;
	padding: 5px 10px;
}

.preview-header>.preview-cancle {
	border: none;
	background-color: transparent;
	padding: 0;
}

.preview-header>.preview-cancle:hover {
	cursor: pointer;
}

.preview-image {
	display: flex;
	justify-content: end;
	align-items: center;
	margin-right: 8px;
}

.preview-image>img {
	width: 130px;
	height: 80px;
}

.display-flex {
	display: flex;
}
</style>
<script>
		var name = "${loginName}";
   		let emoArray = ["emo-main", "emo1", "emo2", "emo3", "emo4", "emo5"];
   		
	   const emoticon = (emoticon) => {
	       if(emoticon === "x") {
	           $('.emoticon-info').html("이모티콘 목록 없음");
	       } else {
	           $('.emoticon-info').html("");
	           emoArray.forEach((item, i) => {
	               let image = `
	               	<div class="emo-btn">
		               <img src="/images/`+item+`.png" id="`+item+`" width="80" height="50">
	                </div>
	               `;
	               $('.emoticon-info').append(image);
	           });
	       }
	   }
	   
	// 채팅 목록
       const chatList = () => {
       	$.ajax({
       		url: "/chat/list",
       		dataType: "json"
       	}).done(res => {
       		console.log(res.result);
       		if(res.result === "ok"){
       			res.data.forEach(item => {
       				chatListBinding(item, res.user);
       			});
       		}
       	});
       }

       // 채팅 바인딩
       const chatListBinding = (data, user) => {
       	const date = new Date(data.write_date);
           const ap = date.getHours() > 11 ? "오후" : "오전";
           const minutes = date.getMinutes() < 10 ? "0"+date.getMinutes() : date.getMinutes()
           const today = ap +" "+ date.getHours() +" : "+ minutes;
       	
       	let item = "";
       	if(data.sender === user){
       		item = `
       			<div class="chat-form">
       				<div class="writer"></div>
       				<div class="content">
                           <span class="date">`+today+`</span>
                           <div>
                           	<img src"/images/profile.png"">
                               `+data.message+`
                           </div>
                       </div>
                   </div>`
       	} else {
       		item = `
                   <div class="chat-form">
       				<div class="unother">
                       	<div id="image"></div>
                           <p>`+data.sender+`</p>
                       </div>
                       <div class="unother-content">
                           <div class="unother-content-info">
                               <img src"/images/profile.png"">
                               `+data.message+`
                           </div>
                           <span class="date">`+today+`</span>
                       </div>
                   </div>`
       	}
       	
           $('.output-form').append(item);
           $('.output-form').scrollTop($('.output-form')[0].scrollHeight);
       }
   </script>

</head>
<body>

	<div class="container">
		<div class="header">
			<div class="form-control">
				<button>-</button>
				<button>□</button>
				<button id="exit" onclick="location.href='/'">x</button>
			</div>
			<div class="chat-header">
				<div class="chat-info">
					<div id="chat-img">
						<img src="/images/bg-moon.jpg" alt="" width="33px">
					</div>
					<div class="chat-room-info">
						<div id="chat-title">
							<i class="fa-solid fa-flag"></i> 우리반
						</div>
						<div id="chat-count">
							<i class="fa-solid fa-user"></i> 21
						</div>
					</div>
				</div>
				<div class="chat-btn">
					<button>
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
					<button>
						<i class="fa-solid fa-phone"></i>
					</button>
					<button>
						<i class="fa-solid fa-video"></i>
					</button>
					<button>
						<i class="fa-solid fa-bars"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="output-form"></div>
		<div class="input-form">
			<div class="input" contenteditable="true"></div>
			<div class="button-list">
				<div class="buttons">
					<button id="icon-btn">
						<i class="fa-regular fa-face-smile"></i>
					</button>
					<button class="icon-btn">
						<i class="fa-regular fa-calendar"></i>
					</button>
					<button class="icon-btn">
						<i class="fa-solid fa-paperclip"></i>
					</button>
					<button class="icon-btn">
						<i class="fa-solid fa-scissors"></i>
					</button>
				</div>
				<button class="send-btn">전송</button>
			</div>

		</div>
		<div class="icon-modal">
			<div class="emoticon-header">
				<button class="emoticon-header-btn">x</button>
			</div>
			<hr>
			<div class="emoticon-list">
				<button onclick="emoticon('x')">X</button>
				<button onclick="emoticon('emo')">
					<img src="/images/emo-main.png" alt="단무지 이모티콘" width="30"
						height="20">
				</button>
			</div>
			<hr>
			<div class="emoticon-info">이모티콘 목록 없음</div>
		</div>
		<div class="emoticon-preview">
			<div class="preview-header">
				<button class="preview-cancle">x</button>
			</div>
			<div class="preview-image"></div>
		</div>
	</div>

	<script>

        chatList();
        
    	let ws = new WebSocket("ws://192.168.1.7/chat");
    	
    	ws.onmessage = (e) => {
    		const data = JSON.parse(e.data);
    		let item = "";
    		const date = new Date();
            const ap = date.getHours() > 11 ? "오후" : "오전";
            const minutes = date.getMinutes() < 10 ? "0"+date.getMinutes() : date.getMinutes()
            const today = ap +" "+ date.getHours() +" : "+ minutes;
    		
    		if(data.sender === name){
    			item = `
    				<div class="chat-form">
	    				<div class="writer"></div>
	    				<div class="content">
		                    <span class="date">`+today+`</span>
		                    <div>
		                    	<img src"/images/profile.png"">
		                        `+data.message+`
		                    </div>
		                </div>
	                </div>`
    		} else {
    			item = `
    	            <div class="chat-form">
    					<div class="unother">
    	                	<div id="image"></div>
    	                    <p>`+data.sender+`</p>
    	                </div>
    	                <div class="unother-content">
    	                    <div class="unother-content-info">
    	                        <img src"/images/profile.png"">
    	                        `+data.message+`
    	                    </div>
    	                    <span class="date">`+today+`</span>
    	                </div>
    	            </div>`
    		}
    		
	        $('.output-form').append(item);
	        $('.output-form').scrollTop($('.output-form')[0].scrollHeight);
	    }
    	
    	$(".input-form").on("keydown", (e) => {
			if(e.key === "Enter") {
				
				let text = "";
             	if($('.preview-image').children().length !== 0) {
                   image = $('.preview-image').html();
                   text += image+"<br>";
               }
             	text += $(".input").html();
             	if(text === "") return false;
             	
             	ws.send(text);
             	
				e.preventDefault();
				$(".input").html("");
				$(".input").focus();
				$('.preview-image').html("");
                $('.emoticon-preview').removeClass("display-flex");
			}
		});
    	
    	$('.send-btn').on('click', (e) => {
    		
			let text = "";
         	if($('.preview-image').children().length !== 0) {
               image = $('.preview-image').html();
               text += image+"<br>"
           }
         	text += $(".input").html();
         	if(text === "") return false;
         	
         	ws.send(text);
             
			e.preventDefault();
			$(".input").html("");
			$(".input").focus();
			$('.preview-image').html("");
            $('.emoticon-preview').removeClass("display-flex");
    	});
    	
        // 이모티콘 모달 활성화 버튼 
        $('#icon-btn').on('click', () => {
        	console.log("이모티콘 모달!");
            $('.icon-modal').toggleClass("display-flex");
        });

        // 이모티콘 모달 비활성화 (X) 버튼
        $('.emoticon-header-btn').on('click', () => {
            $('.icon-modal').toggleClass("display-flex");
        });
        
        // 이모티콘 모달에서 이모티콘 선택시 프리뷰 전달
        $('.emoticon-info').on('click', '.emo-btn', (e) => {
            const getImage = $(e.currentTarget).children()[0];
            $('.emoticon-preview').addClass("display-flex");
            $('.preview-image').html($(getImage).clone());
        });

        // 프리뷰 종료
        $('.preview-cancle').on('click', () => {
            $('.preview-image').html("");
           $('.emoticon-preview').toggleClass("display-flex");
        });
    </script>

</body>
</html>