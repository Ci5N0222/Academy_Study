/**
 *  Exam01
 *  Front-End 대표 언어 3가지
 *  HTML / CSS / JavaScript
 *  
 *  JavaScript ( Live Script, ECMA Script ) 
         - 정적 페이지 구성용도의 HTML/CSS를 보완하여 동적 기능을 부여할 수 있는 언어
         - External, Internal, inline 형식으로 사용
        Standard Library ( 내장형 라이브러리 )
         - JavaScript 내장 라이브러리는 Browser로 부터 제공되며 크게 3개 카테고리로 나누어 사용한다.
         1. BOM ( Browser Object Model ): Browser 관련 기능들을 모아둔 카테고리
         2. DOM ( Document Object Model ): 문서영역 관련 기능들을 모아둔 카테고리
         3. JavaScript Library:  날씨, 수학, 형식등에 관련된 브라우저와 관계없는 기능 집합 카테고리
 */

// Browser에 메세지 쓰기      
document.write("Hello JS");

// 알람 창
alert("Hello World");

// 컨펌 창
if(confirm("확인 or 취소")){
    alert("확인을 눌렀습니다.");
} else {
    alert("취소를 눌렀습니다.");
}

// 입력창으로 메세지 받기
const message = prompt("하고 싶은 말을 입력하세요!");
alert(message);

