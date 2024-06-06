<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<!-- 
	AJAX ( Asychronous JavaScript And XML )
	* 페이지 전환 또는 데이터 통신 방법
		Anker / location.href / form(submit) / window.open
	* 페이지 전환 없이 데이터 Request 및 Response 하는 기술
		AJAX
 -->

<body>

	<fieldset>
		<legend>단순 요청</legend>
		<button id="ajax01">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax01").on("click", function(){
			$.ajax({
				url:"/exam01.ajax",
			});
			
		});
	</Script>
	
	
	<fieldset>
		<legend>파라미터 전달</legend>
		<button id="ajax02">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax02").on("click", function(){
			$.ajax({
				url:"/exam02.ajax",
				type: "post",
				data: {
					key1 : "Apple",
					key2 : "Melon"
				}
			});
			
		});
	</Script>
	
	
	<fieldset>
		<legend>응답 받아보기</legend>
		<div id="txt"></div>
		<button id="ajax03">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax03").on("click", function(){
			$.ajax({
				url:"/exam03.ajax"
			}).done(function(res){
				// 서버로부터 정상적으로 응답이 돌아왔을 때 실행되는 콜백 함수
				// 서버의 응답 데이터는 콜백 함수의 매개변수로 전달 됨
				$("#txt").html(res);
				console.log("res === ", res);
			});
			
		});
	</Script>
	
	
	<fieldset>
		<legend>배열 데이터 받아보기</legend>
		<button id="ajax04">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax04").on("click", function(){
			$.ajax({
				url:"/exam04.ajax"
			}).done(function(res){
				// 서버로부터 정상적으로 응답이 돌아왔을 때 실행되는 콜백 함수
				// 서버의 응답 데이터는 콜백 함수의 매개변수로 전달 됨
				console.log("res === ", res);
			});
			
		});
	</Script>



	<fieldset>
		<legend>객체 데이터 받아보기</legend>
		<button id="ajax05">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax05").on("click", function(){
			$.ajax({
				url:"/exam05.ajax",
				dataType: "json"
			}).done(function(res){
				console.log("res === ", res);
				console.log("res.title === ", res.title);
			});
			
		});
	</Script>


	<fieldset>
		<legend>객체배열 데이터 받아보기</legend>
		<button id="ajax06">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax06").on("click", function(){
			$.ajax({
				url:"/exam06.ajax",
				dataType: "json"
			}).done(function(res){
				console.log("res === ", res);
				res.forEach(item => console.log("item.title === ", item.title));
				
			});
			
		});
	</Script>
	
	
	<fieldset>
		<legend>임의 객체 데이터 받아보기</legend>
		<button id="ajax07">TEST</button>
	</fieldset>
	
	<Script>
		$("#ajax07").on("click", function(){
			$.ajax({
				url:"/exam07.ajax",
				dataType: "json"
			}).done(function(res){
				console.log("res === ", res);
				
			});
			
		});
	</Script>

</body>
</html>