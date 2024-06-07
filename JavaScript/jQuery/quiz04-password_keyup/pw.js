$(() => {

    $('#pw1').on('keyup', () => {
        if($('#pw1').val() === "" || $('#pw2').val() === ""){
            $('#text').html(" ");
        } else if($('#pw1').val() === $('#pw2').val()){
            $('#text').html("비밀번호 일치!");
            $('#text').css({
                "color": "green",
                "display": "block"
            });
        } else { 
            $('#text').html("비밀번호 불일치!");
            $('#text').css({
                "color": "red",
                "display": "block"
            });
        }
    });

    $('#pw2').on('keyup', () => {
        if($('#pw1').val() === "" || $('#pw2').val() === ""){
            $('#text').html(" ");
        } else if($('#pw1').val() === $('#pw2').val()){
            $('#text').html("비밀번호 일치!");
            $('#text').css({
                "color": "green",
                "display": "block"
            });
        } else {
            $('#text').html("비밀번호 불일치!");
            $('#text').css({
                "color": "red",
                "display": "block"
            });
        }
    });

});