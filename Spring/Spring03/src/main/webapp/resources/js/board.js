$(() => {
	// 현재 페이지 주소
	var pathname = window.location.pathname;
	
    // 특정 쿼리 스트링 값 추출 사용법 : urlParams.get('param')
	const urlParams = new URLSearchParams(window.location.search);
	
	// 섬머노트	타겟
	const summernote = $('#summernote');
	
	// 게시글 작성 & 업데이트 유효성 검사
	$("#write_form").on("submit", function(){
		$('#contents').val($('#summernote').summernote('code'));
		
		if($('#title').val() == "") {
			alert("제목 입력안함");
			return false;
		}
		if($('#contents').val() == "") {
			alert("내용 입력안함");
			return false;
		}
	});
	
	// Page Load Script
	switch(pathname){
		case "/board/insert" :
			useSummernote();
			break;
		case "/board/list" :
			let cpage = 1;
			if(urlParams.get('cpage') !== null) cpage = urlParams.get('cpage');
			pageNavi("board", cpage);
			break;
		case "/board/detail" :
			const board_seq = urlParams.get('seq');
			filesList(board_seq);
			replyList(board_seq);
			break;
	}
	
});

// 게시글 수정 폼 변경
const editContents = () => {
	$('h1').html("글 수정")
	$('#success-btn, #cancle-btn, #summernote').css({"display" : "block"});
	$('#writerInfo, #edit-btn, #del-btn, #list-btn, #div_contents').css({"display" : "none"});	
	$('#title').attr('readonly', false);
	const content = $("#div_contents").html().trim();
	useSummernote(content);
}

// 게시글 삭제
const deleteContents = (seq) => {
	if(confirm("정말 삭제할꺼임?")){
		location.href="/board/delete?seq=" + seq;
	} else {
		alert("ㅇㅋ 안지움");
	}
}

// 댓글 작성
const replyInsert = () => {
	const seq = $("#seq").val();
	const content = $(".board-reply-contents-board").html().trim();
	
	$.ajax({
		url: "/reply/insert",
		data: {
			seq,
			content
		}
	}).done(res => {
		console.log(res.result);
		location.href = "/board/detail?seq="+seq;
	});
}

// 파일 목록
const filesList = (parentSeq) => {
	$.ajax({
		url:"/files/list",
		data: { parentSeq },
		dataType: "json"
	}).done(res => {
		res.forEach(item => {
			// 다운로드 링크 셋팅
			let anker = $("<a>");
			anker.attr("href", `/files/download?sysName=${item.sysname}&oriName=${item.oriname}`);
			$(".board-contents-files").append(anker);
			
			// 다운로드 할 파일 이름 셋팅
			let oriname = item.oriname; 
		    if (oriname.length > 17) oriname = oriname.slice(0, 6) + "..." + oriname.slice(-6);
		    anker.html(oriname);
		});
	});
}

// 댓글 목록
const replyList = (boardSeq) => {
	$.ajax({
		url : "/reply/list",
		data: {
			boardSeq
		},
		dataType: "json"
	}).done(res => {
		if(res.result === "ok") {
			res.data.forEach(item => {
				replyListBinding(item, res.user);
			});
		}
	});
}

// 댓글 목록 바인딩
const replyListBinding = (list, user) => {
	const date = formatTimestamp(list.write_date);
    let subItem = "";

    if(user === list.writer) {
        subItem = `
            <button class="edit-btn edit-form">수정</button>
            <button class="edit-btn" onclick="replyDelete(${list.seq})">삭제</button>
            <button class="update-btn reply-update" onclick="replyUpdate()">확인</button>
            <button class="update-btn" onclick="location.reload()">취소</button>
        `;
    }

	const item = `
		<section class="board-reply-list">
			<div class="board-reply-info">
				<div class="board-reply-writer-avater">
					<img src="/images/bg-01.jpg" alt="basic image">
				</div>
				<div class="board-reply-writer">
					${list.writer}
				</div>
				<div class="board-reply-write-date">
					${date}
				</div>
				<div class="board-reply-info-btn">`
				+subItem+
				`</div>
			</div>
			<div class="board-reply-contents">
				<div class="board-reply-list-contents">${list.content}</div>
                <input class="board-reply-update-seq" type="hidden" value="${list.seq}">
                <input class="board-reply-update-input" type="hidden">
			</div>
		</section>`;

	$("#reply-list-binding").append(item);
	
	// 댓글 수정 폼으로 변경
    $(".edit-form").on("click", function() {

		// content div contentable true로 변경
        const content = $(this).closest(".board-reply-list").find(".board-reply-list-contents");
        content.attr("contenteditable", "true");
        
        // display hide()
        const btn1 = $(this).siblings(".edit-btn");
        $(this).hide();
        btn1.hide();
        
        // display show()
        const btn2 = $(this).siblings(".update-btn");
        btn2.show();
    });
    
    // 댓글 수정 후 확인 버튼 클릭
    $(".reply-update").on("click", function() {
    	let content = $(this).closest(".board-reply-list").find(".board-reply-list-contents");
    	let input = $(this).closest(".board-reply-list").find(".board-reply-update-input");
    	input.val(content.html().trim());
    	let seq = $(this).closest(".board-reply-list").find(".board-reply-update-seq");
    	
    	replyUpdate(seq.val(), input.val());
    });
}

// 댓글 수정
const replyUpdate = (seq, content) => {
	$.ajax({
		url: "/reply/update",
		data: {
			seq,
			content
		},
		dataType: "json"
	}).done(res => {
		console.log(res.result);
		if(res.result === "ok"){
			location.reload();
		}
	});
}

// 댓글 삭제
const replyDelete = (seq) => {
	$.ajax({
		url: "/reply/delete",
		data: {
			seq
		},
		dataType: "json"
	}).done(res => {
		if(res.result === "ok"){
			location.reload();
		}
	});
}

// 섬머노트
const useSummernote = (content) => {
	if(content === undefined) content = "";

	/** summernote **/
	$('#summernote').summernote({
		height: 300,
		minHeight: null,
		maxHeight: null,
		focus: true,
		lang: "ko-KR",
		placeholder: '내용을 작성하세요',
		onImageUpload: function(files, editor, welEditable) {
            sendFile(files[0], editor, welEditable);
        },
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
	
	// summernote 기존 내용 넣기
	$('#summernote').summernote('code', content);
	
	// summernote text 쓰기
	$('#summernote').summernote('insertText');

	// summernote 쓰기 비활성화
	$('#summernote').summernote('disable');

	// summernote 쓰기 활성화
	$('#summernote').summernote('enable');

	// summernote 리셋
	$('#summernote').summernote('reset');

	// 마지막으로 한 행동 취소 ( 뒤로가기 )
	$('#summernote').summernote('undo');
	
	// 앞으로가기
	$('#summernote').summernote('redo');
}

// 페이지 네비게이터 정보 받기
const pageNavi = (target, cpage) => {
	$.ajax({
		url: "/pagenavi",
		data: {
			target,
			cpage
		},
		dataType: "json"
	}).done(res => {
		if(res.result === "ok"){
			const data = res.data;
			pagenation(data.currentPage, data.totalRecord, data.pageRecord, data.pageNavi, data.url);
		}
	});
}

// 페이징 네비게이터
const pagenation = (cpage, recordTotalCount, recordCountPerPage, naviCountPerPage, url) => {

	// total page count
	let pageTotalCount = 0;
	if(recordTotalCount % recordCountPerPage > 0) pageTotalCount = recordTotalCount / recordCountPerPage + 1;
	else pageTotalCount = recordTotalCount / recordCountPerPage;
	
	// navigator start number
	let startNavi = Math.floor((cpage - 1) / naviCountPerPage) * naviCountPerPage + 1
	
	// navigator end number
	let endNavi = startNavi + naviCountPerPage - 1;
	
	if(endNavi > pageTotalCount) endNavi = pageTotalCount;
	
	let needNext = true;
	let needPrev = true;
	
	if(startNavi == 1) needPrev = false;
	if(endNavi == pageTotalCount) needNext = false;
	
	if(needPrev){
		let prev = `<a href='${url}?cpage=${(startNavi - 1)}'> < </a>`;
		$('.page-navigation').append(prev);
	}
	
	for(let i = startNavi; i <= endNavi; i++){
		if(cpage === i){
			let items = `<a href='${url}?cpage=${i}'> ${i} </a>`;
    		$('.page-navigation').append(items);
		} else {
			let items = `<a href='${url}?cpage=${i}'> ${i} </a>`;
    		$('.page-navigation').append(items);	
		}
	}
	
	if(needNext) {
		let next = `<a href='${url}?cpage=${(endNavi + 1)}'> > </a>`;
		$('.page-navigation').append(next);
	}	
}


// 날짜 포맷 변경
const formatTimestamp = (timeStamp) => {
	
	const date = new Date(timeStamp);
	const year   = date.getFullYear().toString();           
	const month  = ("0" + (date.getMonth() + 1)).slice(-2); 
	const day    = ("0" + date.getDate()).slice(-2);        
	const hour   = ("0" + date.getHours()).slice(-2);       
	const minute = ("0" + date.getMinutes()).slice(-2);     
	const second = ("0" + date.getSeconds()).slice(-2);
	
	const formattedDateTime = `${year}.${month}.${day}`
	
	return formattedDateTime;
}

