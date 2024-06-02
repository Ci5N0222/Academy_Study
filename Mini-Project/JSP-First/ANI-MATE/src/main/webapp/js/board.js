$(function(){
	$('#summernote').summernote({
		height: 300,
		minHeight: null,
		maxHeight: null,
		focus: true,
		lang: "ko-KR",
		placeholder: '내용을 작성하세요',
		toolbar: [
		    ['fontname', ['fontname']],
		    ['fontsize', ['fontsize']],
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    ['color', ['forecolor','color']],
		    ['table', ['table']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['insert',['picture','link','video']],
		    ['view', ['fullscreen', 'help']]
		 ],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		
	});
	
	// 서머노트에 text 쓰기
	$('#summernote').summernote('insertText');

	// 서머노트 쓰기 비활성화
	$('#summernote').summernote('disable');

	// 서머노트 쓰기 활성화
	$('#summernote').summernote('enable');

	// 서머노트 리셋
	$('#summernote').summernote('reset');

	// 마지막으로 한 행동 취소 ( 뒤로가기 )
	$('#summernote').summernote('undo');
	
	// 앞으로가기
	$('#summernote').summernote('redo');
	
});