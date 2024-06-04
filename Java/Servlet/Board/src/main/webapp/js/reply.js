// 폼에 맞춰 데이터 바인딩
const replyList = (reply, loginID) => {
	
	let item =`<form class="reply-board" action="/update.reply" method="post" id="update_form${ reply.seq }">
			        <div class="reply-board-header">
			            <span class="reply-writer">${ reply.writer }</span>
			            <span class="reply-write_date"> 
			                ${ reply.write_date }
			            </span>
			        </div>
			        <div class="reply-contens-box">
			            <div class="reply-contents" id="div_reply_contents${ reply.seq }">${ reply.contents }</div>
			            <input type="hidden" name="seq" value="${ reply.seq }">
			            <input type="hidden" name="parent_seq" value="${ reply.parent_seq }">
			            <input type="hidden" name="contents" id="reply_contents${ reply.seq }" value="${ reply.contents }">
			            `
	            
	if(reply.writer === loginID){
		item += `<div class="reply-btn-box">
	        <button type="button" class="reply_edit" id="reply_edit${ reply.seq }"> 수정 </button>
	        <button type="button" class="reply_delete" id="reply_delete${ reply.seq }" onclick="deleteReply(${ reply.seq }, ${ reply.parent_seq })"> 삭제 </button>
	        <button type="submit" class="reply_success" id="reply_success${ reply.seq }"> 완료 </button>
	        <button type="button" class="reply_cancel" id="reply_cancel${ reply.seq }" data-seq="${ reply.seq }"> 취소 </button> 
	    </div>
		`
	}
	            
    item +=` 
	    	<script>
	            $('#reply_edit${ reply.seq }').on("click", function(){
	                
	                $('#reply_edit${ reply.seq }').hide();
	                $('#reply_delete${ reply.seq }').hide();
	                $('#reply_success${ reply.seq }').show();
	                $('#reply_cancel${ reply.seq }').show();
	                
	                $("#div_reply_contents${ reply.seq }").attr("contenteditable", "true");
	                $("#div_reply_contents${ reply.seq }").focus();
	                
	            });
	        
	            
	            $("#reply_cancel${ reply.seq }").on("click", function(){
	                location.reload();
	            });
	            
	            
	            $('#update_form${reply.seq}').on("submit", function(){
	                
	                $("#reply_contents${reply.seq}").val($("#div_reply_contents${reply.seq}").text());
	                if($("reply_contents${reply.seq}").val() === "") {
	                    alert("내용 작성하셈");
	                    $("#div_reply_contents${ reply.seq }").focus();
	                    return false;
	                }
	            });
	        
	        </script>
	    </div>
	</form>`
    
    return item;
}