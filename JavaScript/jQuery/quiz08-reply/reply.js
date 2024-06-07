$(() => {
            
    // 댓글 등록
    $('#writeReply').on('click', () => {
        if($('#writer').html().trim() === "") return alert("작성자 없음");
        if($('#content').html().trim() === "") return alert("내용 없음");
        
        // 작성된 댓글 Component
         let item = `
            <div class="container-reply">
                <div class="content-reply">
                    <div class="reply-area">
                        <div class="writer" contenteditable="false">${ $('#writer').html() }</div>
                        <div class="content" contenteditable="false">${ $('#content').html() }</div>
                    </div>
                </div>
                <div class="btn-list">
                    <button class="updateReply">수정</button>
                    <button class="deleteReply">삭제</button>
                    <button class="success">확인</button>
                    <button class="cancle">취소</button>
                </div>
            </div>
        `;

        $('#reply-form').append(item);

        $('#writer').html("작성자");
        $('#content').html("내용");

    });

    // 댓글 삭제
    $('#reply-form').on('click', '.deleteReply', (e) => {
        $(e.currentTarget).closest(".container-reply").remove();
    });

    // 댓글 업데이트
    $('#reply-form').on('click', '.updateReply', (e) => {

        let writer = $(e.currentTarget).closest('.container-reply').find('.writer').html();
        let content = $(e.currentTarget).closest('.container-reply').find('.content').html();

        $(e.currentTarget).css({"display": "none"});
        $(e.currentTarget).siblings('.deleteReply').css({"display": "none"});
        $(e.currentTarget).siblings('.success').css({"display": "block"});
        $(e.currentTarget).siblings('.cancle').css({"display": "block"});
        $(e.currentTarget).closest('.container-reply').find('.writer').attr("contenteditable", true);
        $(e.currentTarget).closest('.container-reply').find('.content').attr("contenteditable", true);

        // 업데이트 후 '확인' 버튼을 눌렀을 때
        $('.success').on('click', function(){
            $(this).closest('.container-reply').find('.writer').attr("contenteditable", false);
            $(this).closest('.container-reply').find('.content').attr("contenteditable", false);
            $(this).css({"display": "none"});
            $(this).siblings('.cancle').css({"display": "none"});
            $(this).siblings('.updateReply').css({"display": "block"});
            $(this).siblings('.deleteReply').css({"display": "block"});
        });

        // 업데이트 후 '취소' 버튼을 눌렀을 때
        $('.cancle').on('click', function(){
            $(this).closest('.container-reply').find('.writer').html(writer);
            $(this).closest('.container-reply').find('.content').html(content);
            $(this).closest('.container-reply').find('.writer').attr("contenteditable", false);
            $(this).closest('.container-reply').find('.content').attr("contenteditable", false);
            $(this).css({"display": "none"});
            $(this).siblings('.success').css({"display": "none"});
            $(this).siblings('.updateReply').css({"display": "block"});
            $(this).siblings('.deleteReply').css({"display": "block"});
        });
    });

});