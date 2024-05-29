<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
         width: 550px;
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
         width: 250px;
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

	.btn-box1 {
		display: flex;
	    justify-content: center;
	    align-items: center;
	    margin: 20px auto;
	}
	
	.btn-box2 {
		display: none;
	    justify-content: center;
	    align-items: center;
	    margin: 20px auto;
	}
	
	.btn-box1 > button, .btn-box2 > button {
		margin: 10px;
	}
	
	#pcodeSearch {
		display: none;'
	}
	
	input {
		border: none;
	}


  </style>
  
  <script>
  
  	// 정보수정 폼으로 변환
  	const edit = () => {
  		$('.btn-box1').css({"display": "none"});
  		$('.btn-box2').css({"display": "flex"});
  		
  		$('#name').removeAttr("readonly");
  		$('#phone').removeAttr("readonly");
  		$('#email').removeAttr("readonly");
  		$('#zipcode').removeAttr("readonly");
  		$('#address1').removeAttr("readonly");
  		$('#address2').removeAttr("readonly");
  		
  		$('#pcodeSearch').css({"display":"inline-block"});
  		
  		$('input').css({"border": "1px solid black"});
  		
  		$('h2').html("회원정보 수정");
  	}
  	
  	
 	// 우편번호
    const postcodeFind = () => {
        new daum.Postcode({
            oncomplete: function(data) {
                
                // 우편번호
                $('#zipcode').val(data.zonecode);

                //상세주소
                $('#address1').val(data.address);
            }
        }).open();
    }
    
    
 	// 이름 정규표현식
    let regexName = /^[가-힣]{2,5}$/;

    // 전화번호 정규표현식
    let regexPhone = /^010-?[0-9]{4}-?[0-9]{4}$/;

    // 이메일 정규표현식
    let regexEmail = /^[a-zA-Z0-9]+?@[a-zA-Z]+?\.[a-zA-Z]+$/;
  	
  	$(() => {
  		
  	// 가입하기 버튼 Validation
        $('#updateForm').on('submit', () => {

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
  
  </script>
  
</head>
<body>
	<c:choose>
		<c:when test = "${ dto == null }">
			마이페이지 로딩 중 오류 발생<br>
			다시 시도해주세요...
		</c:when>
		
		<c:otherwise>
		
			<h2>My Page</h2>
	    	<div class="container">
		        <form class="input-form" action="/update.members" method="post" id="updateForm">
		            <!-- ID -->
		            <label for="id">아이디</label>
		            <input type="text" id="id" name="id" value="${ dto.id }" readonly>
		            
		            <!-- 이름 -->
		            <label for="name">이름</label>
		            <input type="text" id="name" name="name" value="${ dto.name }" readonly>
		
		            <!-- 전화번호 -->
		            <label for="phone">전화번호</label>
		            <input type="text" id="phone" name="phone" value="${ dto.phone }" readonly> 
		
		            <!-- 이메일 -->
		            <label for="email">이메일</label>
		            <input type="text" id="email" name="email" value="${ dto.email }" readonly> 
		
		            <!-- 우편번호 -->
		            <label for="pcode">우편번호</label>
		            <input type="text" id="zipcode" name="zipcode" value="${ dto.zipcode }"readonly>
		            <button type="button" id="pcodeSearch" onclick="postcodeFind()">검색</button>
		
		            <!-- 주소 -->
		            <label for="address1">주소</label>
		            <input type="text" id="address1" name="address1" value="${ dto.address1 }"readonly>
		            
		            <!-- 상세 주소 -->
		            <label for="address2">상세주소</label>
		            <input type="text" id="address2" name="address2" value="${ dto.address2 }" readonly>
		
		 			<!-- 가입날짜 -->
		            <label for="address2">가입날짜</label>
		            <span style="font-size:14px; margin-left: 20px">
						<fmt:formatDate value="${ dto.join_date }" type="date" dateStyle="full"/>
		            </span>
		            
					<div class="btn-box1">
						<button type="button" onclick="edit()">정보 수정하기</button>
		            	<button type="button" onclick="location.href='/'">돌아가기</button>
					</div>
					<div class="btn-box2">
						<button type="submit">확인</button>
		            	<button type="button" onclick="location.href='/myPage.members'">취소</button>
					</div>
						
		        </form>
		    </div>
		</c:otherwise>
	</c:choose>
</body>
</html>