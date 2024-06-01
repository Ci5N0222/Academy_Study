/**
 *  Exam03
 *  function ( 함수, 메서드 )
 *      - 자바의 메서드와 같은 개념
 *      - 매개변수에 자료형이 없음
 *  hoisting: 함수의 선언은 코드상 어디에 작성해도, 모든 스크립트 코드의 최상위에 선언된 것으로 처리됨
 */

// HTML이 Load가 완료되면 실행
document.addEventListener('DOMContentLoaded', () => {

    const result = plus(4, 2);
    console.log("result === ", result);

    // 함수의 주소값을 변수에 담을 수 있다.
    let addPlus = plus;
    console.log("add 함수의 주소값으 담은 변수 addPlus == ",addPlus(1, 2));

    // IIRF ( Instantly Invoked Function Expression ) : 즉석에서 표현되는 함수 표현식
    let result2 = (function(num1, num2){
        return num1 * num2;
    })(1, 2);
    console.log("result2 === ", result2);

    // const template = temp(minus, 5, 3);
    const template = temp(((num1, num2) => num1 * num2), 5, 3);
    console.log("temp === ", template);

    // 익명함수의 주소값을 가지는 test 함수
    function test(){
        return function(num1, num2){
            return num1 / num2;
        }
    }
    let result3 = test()(10,2);
    console.log("result3 === ", result3);

});