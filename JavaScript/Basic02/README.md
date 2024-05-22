## 배열 메서드
indexOf() : 배열안에서 특정 요소가 있을 경우 그 요소의 인덱스를 반환, 그 요소가 없을 경우 -1을 반환

join() : 인자로 전달된 값을 바탕으로 배열 요소를 연결하여 하나의 String 값으로 반환

reverse() : 배열 요소의 순서를 뒤집는 기능

slice() : 배열내에서 특정 범위 내 요소들을 추출하여 반환하는 함수
- 인자값1 : 추출 시작 위치 ( Inclusive - 포함 )
- 인자값2 : 추출 종료 위치 ( Exclusive - 제외 )
- 추출 후 원본 배열에 영향을 미치지 않음

splice()
1. 배열 내에서 특정 시작점부터 특정 개수 만큼의 데이터를 삭제
2. 특정 위치에 데이터를 끼워 넣는 기능
- 인자값1 : 시작 Index
- 인자값2 : 개수
- 원본에 영향을 미침!!!


#### 동적 배열 요소 추가 및 삭제
push() : 배열의 마지막에 요소를 추가하는 기능

pop() : 배열의 마지막요소를 제거하는 기능, 제거한 마지막 요소를 반환한다.

unshift() : 배열의 가장 앞쪽에 요소를 추가하는 기능

shift() : 배열의 가장 앞쪽에 있는 요소를 삭제하는 기능


## 객체
#### JavaScript 객체
객체를 만드는 3가지 방법
1. 객체 Literal ( 가장 많이 사용되는 방식 )
     - 표기법 : JSON ( JavaScript Object Notation )
     - JSON : 현 시점 기준 크로스 플랫폼/언어 간 데이터 교환용 직렬화 방식으로 유명
     ``` bash
     let obj = {
            id: 1001,
            name: "kim",
            age: 20,
            1: "One",
            helllo: function(){console.log("Hello");}
        };
     ```
2. 생성자
    ``` bash
     function Music(id, title, singer){
            this.id = id;
            this.title = title;
            this.singer = singer;
        }

    let obj2 = new Music("1001", "After Like", "IVE");
    ```
3. 기본 객체 Object
    ``` bash
    let obj3 = new Object();
    obj3.id = 1002;
    obj3.title = "범죄도시4";
    obj3.genre = "액션";
    ```


#### 직렬화 : 여러 언어들 사이에서 특정 언어를 통신할 때, 공통 언어로 변경하는 작업
#### 역직렬화 : 직렬화된 데이터를 언어에서 사용 가능하게 변환하는 작업

## 외부 API 실습

### 카카오 맵
- https://apis.map.kakao.com/web/

### 카카오 우편번호
- https://postcode.map.daum.net/guide