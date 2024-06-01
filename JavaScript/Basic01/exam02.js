/**
 *  Exam02
 *  JS 특징1 : JavaScript에는 명시적 자료형이 없음
 */

// HTML이 Load가 완료되면 실행
document.addEventListener('DOMContentLoaded', () => {

    // id가 txt인 html 엘리멘트를 input에 저장
    const input = document.getElementById("txt");

    // input에 저장된 엘리멘트의 속성을 출력
    console.log("value 속성 출력 === ", input.value);
    console.log("id 속성 출력 === ", input.id);
    console.log("class 속성 출력 === ", input.class);

    // id가 box인 html 엘리멘트를 div에 저장
    const box = document.getElementById("box");

    // box에 저장된 엘리멘트 속성을 출력
    console.log("box 요소 사이의 값 출력 === ", box.innerHTML);
});