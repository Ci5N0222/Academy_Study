<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업데이트</title>
<style>
        div {
            border: 1px solid black;
        }

        body {
            width: 300px;
            height: 150px;
            margin: 30px auto;
            border: 1px solid black;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        .title {
            width: 90%;
            padding: 10px;
            margin: 4px auto;
        }

        .genre {
            padding: 10px;
            width: 90%;
            margin: 4px auto;
        }

        button {
            width: 70px;
            height: 30px;
            margin: 10px auto;
            padding: 5px;
        }

        .btn-box {
            border: none;
            margin: auto;
        }
    </style>
</head>
<body>
	<form action="UpdateServlet" method="post" id=updateForm>
        <input type="hidden" name="id" id="id" value="${ movie.id }"/> 
		<input type="text" name="title" id="title" class="title" value="${ movie.title }" placeholder="제목" /> 
		<input type="text" name="genre" id="genre" class="genre" value="${ movie.genre }" placeholder="장르" />
        <div class="btn-box">
            <button type="submit">확인</button>
            <button type="button">취소</button>
        </div>
	</form>
	
	<script>
	
		// Input validation
	    document.querySelector("#inputForm").addEventListener('submit', (e) => {
	    	
	        if(document.querySelector('#title').value === "" ){
		    	e.preventDefault();
	            alert("제목 없음");
	            return false;
	        }
	        
	        if(document.querySelector('#genre').value === "" ){
		    	e.preventDefault();
	            alert("장르 없음");
	            return false;
	        }
	    });
		
	</script>
</body>
</html>