<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign-Up Form</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- kakao postcode -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
	
     body {
         margin: 0px auto;
         text-align: center;
     }

     .container {
         display: flex;
         width: 600px;
         margin: 20px auto;
         text-align: left;
     }

     .input-form {
         width: 100%;
     }

     .input-form > label {
         text-align: left;
         display: inline-block;
         width: 120px;
         padding: 5px;
     }

     .input-form > input {
         padding: 5px;
         margin: 15px;
         width: 300px;
     }

     button {
         border: none;
         background-color: rgb(86, 86, 184);
         color: white;
         font-weight: 700;
         padding: 7px 10px;
         border-radius: 5px;
     }

     button:hover {
         cursor: pointer;
     }

     #pwCheck {
         margin: 0;
         margin-bottom: 10px;
         text-align: center;
         color: green;
         font-weight: 700;
     }

     #idCheck {
         margin: 0;
         margin-bottom: 10px;
         text-align: center;
         color: green;
         font-weight: 700;
     }


     #warn {
         text-align: left;
         color: red;
         border: 1px solid black;
         padding: 0 5px;
     }

	.btn-box {
		display: flex;
	    justify-content: center;
	    align-items: center;
	    margin: 20px auto;
	}
	
	.btn-box > button {
		margin: 10px;
	}

  </style>

<script>

        // 중복 확인
        var idChecking = false;
        var duplicateId = "";

        // 패스워드 키업
        let pwCheking = false;

        // ID 정규표현식
        let regexId = /^[a-zA-Z0-9_]{8,}$/;

        // 패스워드 정규 표현식
        // let regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,}$/;
        let regexPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$/;

        // 이름 정규표현식
        let regexName = /^[가-힣]{2,5}$/;

        // 전화번호 정규표현식
        let regexPhone = /^010-?[0-9]{4}-?[0-9]{4}$/;

        // 이메일 정규표현식
        let regexEmail = /^[a-zA-Z0-9]+?@[a-zA-Z]+?\.[a-zA-Z]+$/;

        $(() => {

            // 비밀번호, 비밀번호 확인
            $('#pw1, #pw2').on('keyup', () => {
                if($('#pw1').val() === "" || $('#pw2').val() === ""){
                    $('#pwCheck').html(" ");
                    pwCheking = false;

                } else if($('#pw1').val() === $('#pw2').val()) {
                    $('#pwCheck').html("비밀번호 일치!!");
                    $('#pwCheck').css({"color": "green", "display":"block"});
                    pwCheking = true;

                } else {
                    $('#pwCheck').html("비밀번호 불일치!!");
                    $('#pwCheck').css({"color": "red", "display":"block"});
                    pwCheking = false;
                }

                if(pwCheking){
                    if($('#pw2').val().length < 8) {
                        $('#pwCheck').html("비밀번호 짧음!! 8자리 이상 입력 하셈!");
                        $('#pwCheck').css({"color": "black", "display":"block"});
                        pwCheking = false;
                    }
                }
            });

            // 가입하기 버튼 Validation
            $('#joinForm').on('submit', () => {

                if(!idChecking || duplicateId != $('#id').val()){
                    alert("중복확인 하셈");
                    $('#id').focus();
                    return false;
                }

                if(!pwCheking) {
                    alert("비밀번호 확인 하셈");
                    $('#pw1').focus();
                    return false;
                }

                if(!regexPw.test($('#pw1').val())){
                    alert("비밀번호에 알파벳 소문자, 대문자, 숫자가 각각 하나 이상 들어가야 함");
                    $('#pw1').focus();
                    return false;
                }

                if(!regexName.test($('#name').val()) || $('#name').val() === ""){
                    alert("이름 확인하셈");
                    $('#name').focus();
                    return false;
                }

                if(!regexPhone.test($('#phone').val()) && $('#phone').val() !== ""){
                    alert("핸드폰번호 이상함");
                    $('#phone').focus();
                    return false;
                } 

                if(!regexEmail.test($('#email').val()) && $('#email').val() !== ""){
                    alert("이메일 이상함");
                    $('#email').focus();
                    return false;
                }

            });

        });

        // 중복확인
        const idCheck = () => {
            if($('#id').val() === ""){
                $('#idCheck').html(" ");
                idChecking = false;
                $('#id').focus();
                return alert("ID 입력하셈");
            } 

            if(!regexId.test($('#id').val())){
                $('#idCheck').html(" ");
                idChecking = false;
                $('#id').focus();
                return alert("유효하지 않은 ID임");
            } 

            // DB 조회 로직 이후 true 반환해야됨
            window.open("/idCheck.members?id=" + $('#id').val(), "", "width=300, height=200");
            duplicateId =  $('#id').val();
        }

        // 우편번호
        const postcodeFind = () => {
            new daum.Postcode({
                oncomplete: function(data) {
                    
                    // 우편번호
                    $('#pcode').val(data.zonecode);

                    //상세주소
                    $('#address1').val(data.address);
                }
            }).open();
        }

    </script>

</head>
<body>

	<h2>회원가입</h2>
    <div class="container">
        <form class="input-form" action="join.members" method="post" id="joinForm">
            <!-- ID -->
            <label for="id">* 아이디</label>
            <input type="text" id="id" name="id" placeholder="아이디">
            <button type="button" onclick="idCheck()">중복체크</button>

            <!-- Password -->
            <label for="pw1">* 패스워드</label>
            <input type="password" id="pw1" name="pw" placeholder="패스워드 10자리 이상 입력!!"> 
            <label for="pw2">* 패스워드 확인</label>
            <input type="password" id="pw2" name="pw2" placeholder="패스워드 재입력">
            <p id="pwCheck"> </p>

            <!-- 이름 -->
            <label for="name">* 이름</label>
            <input type="text" id="name" name="name" placeholder="이름">

            <!-- 전화번호 -->
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" placeholder="전화번호"> 

            <!-- 이메일 -->
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" placeholder="이메일"> 

            <!-- 우편번호 -->
            <label for="pcode">우편번호</label>
            <input type="text" id="pcode" name="pcode" placeholder="우편번호" readonly>
            <button type="button" onclick="postcodeFind()">검색</button>

            <!-- 주소 -->
            <label for="address1">주소</label>
            <input type="text" id="address1" name="address1" placeholder="주소" readonly>
            
            <!-- 상세 주소 -->
            <label for="address2">상세주소</label>
            <input type="text" id="address2" name="address2" placeholder="상세 주소">

			<div class="btn-box">
				<button type="submit">가입하기</button>
            	<button type="button" onclick="location.href='/index.jsp'">돌아가기</button>
			</div>
			
        </form>
    </div>
	
</body>
</html>