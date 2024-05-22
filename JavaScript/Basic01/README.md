## JavaScript

### Front-End 대표 언어 3가지
- HTML
- CSS
- JavaScript

### JavaScript ( Live Script, ECMA Script )
- 정적 페이지 구성 용도의 HTML/CSS를 보완하여 동적 기능을 부여할 수 있는 언어
- External, Internal, Inline 형식으로 사용
- JavaScript는 명시적 자료형이 없다.

### Standard Library ( 내장형 라이브러리 )
- JavaScript 내장 라이브러리는 Browser로 부터 제공되며 크게 3가지 카테고리로 나뉨
1. BOM ( Browser Object Model )
    - Browser 관련 기능들을 모아둔 카테고리
2. DOM ( Document Object Model )
    - 문서영역 관련 기능들을 모아둔 카테고리
3. JavaScript Library
    - 날씨, 수학, 형식등에 관련된 브라우저와 관계없는 기능 집합 카테고리

### 변수
- variable0 = 10;
    - 전역변수
- var variable1;
    - Block Scope 변수
    - 변수명 재선언, 값 재할당 가능
- let variable2;
    - Function Scope 변수
    - 값 재할당 가능
- const variavle3;
    - 상수
    - 재선언, 재할당 불가

### 함수 ( function )
- JAVA의 메서드와 같은 개념
- JavaScript의 function은 First Class Function(일등급 함수)라고도 함
    - 함수의 이름을 하나의 주소값으로서 다룰 수 있다는 것이 이유
    - 함수명 : 함수의 실행 코드가 저장된 메모리 공간의 주소

### 호이스팅 ( Hoisting )
- 함수의 선언은 코드상 어디에 작성해도, 모든 스크립트 코드의 최상위에 선언된 것으로 처리된다.

### JavaScript에서 Event 란?
- 브라우저 위에서 취하는 모든 행동
- ex: 좌클릭, 마우스 움직임, 키보드 타이핑, 마우스 휠 움직임, 브라우저 크기 조절 등등..

### Event 종류
- Event Source : 이벤트 발생의 근원 Element
- Event Listener : 이벤트 근원 Element가 감지할 수 있는 이벤트 종류
- Event Handler : 이벤트 발생 시 처리동작을 가지는 함수

### Callback Function
- 개발자가 직접 콜하는 것이 아닌, 특정 트리거에 의해 자동으로 콜되는 함수

### HTML 요소 안에 HTML 요소 추가하기
``` bash
const list = document.querySelector('#list');
const item = document.querySelector('div');
item.innerHTML = 'Hello World!';
list.append(item);
```

### 팝업창 띄우는 기능
- window.open("https://www.naver.com", "", "width=200, height=200");

