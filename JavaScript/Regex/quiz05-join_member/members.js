// 중복 확인
let idChecking = false;

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

        if(!idChecking){
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

        // if($('#pcode').val() === ""){
        //     alert("주소 입력 하셈");
        //     return false;
        // }

        // if($('#address2').val() === ""){
        //     alert("상세 주소 입력 하셈");
        //     return false;
        // }

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
    $('#idCheck').html("중복확인 완료");
    idChecking = true;
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