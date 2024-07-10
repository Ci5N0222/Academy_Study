<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Board List</title>

<script src="/js/board.js"></script>

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	max-width: 1448px;
	margin: 30px auto;
}

.container>h1 {
	text-align: center;
	margin: 50px 0;
}

.content-info {
	display: flex;
	flex-direction: column;
	border: 1px solid lightgrey;
	margin: 5px 0;
}

.title-box {
	display: flex;
	justify-content: space-between;
}

.title-box>a {
	flex: 4;
}

.title-box>a>.title {
	padding: 15px;
	display: flex;
	align-items: center;
}

.title-box>.additional {
	flex: 2;
	font-size: 12px;
	padding: 3px;
}

.additional>p {
	margin: 2px;
}

.content {
	height: 70px;
	padding: 15px;
	display: flex;
	justify-content: space-between;
}

.text {
	flex: 9;
	overflow: hidden;
}

.btn-del {
	flex: 1;
	display: flex;
	align-items: end;
}

button {
	width: 80px;
	height: 30px;
	border: none;
	border-radius: 10px;
	background-color: antiquewhite;
	font-weight: 700;
}

button:hover {
	cursor: pointer;
}

.btn-header {
	display: flex;
	justify-content: space-between;
	margin-bottom: 10px;
}

.search>input {
	width: 200px;
	height: 30px;
}

.search-btn {
	height: 30px;
	border: none;
	border-radius: 10px;
	background-color: skyblue;
	font-weight: 700;
}

a {
	color: inherit;
	text-decoration: none;
}

#navi {
	display: flex;
	justify-content: center;
	align-items: center;
}

#navi>a {
	color: blue;
	margin: 3px;
}
</style>

</head>
<body>

	<div class="container">
		<h1>자 유 게 시 판</h1>
		<div class="btn-header">
			<div class="btn-box">
				<button onclick="location.href='/board/insert'">글쓰기</button>
				<button onclick="location.href='/'">홈으로</button>
			</div>
			<form class="serach" action="/board/searchList">
				<select name="select">
					<option value="writer">작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="search" placeholder="검색어 입력">
				<button>검색</button>
			</form>
		</div>

		<c:choose>
			<c:when test="${list.size() == 0}">
				<br />
				<br />
				<br />
				<h1 style="text-align: center">게시물이 없습니다!!</h1>
			</c:when>

			<c:otherwise>
				<c:forEach var="list" items="${ list }">
					<div class="content-info">
						<div class="title-box">

							<a href="/board/detail?seq=${list.seq}"><div class="title">${ list.title }</div></a>
							<div class="additional">
								<p class="writer">작성자 : ${ list.writer }</p>
								<p class="write_date">
									작성 날짜 :
									<fmt:formatDate value="${ list.write_date }"
										pattern="yyyy-MM-dd" />
								</p>
							</div>
						</div>
						<hr />
						<div class="content">
							<div class="text">${ list.content }</div>
							<div class="btn-del">
								<c:if test="${ list.writer eq loginID }">
									<button onclick="deleteContents(${list.seq})">삭제</button>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<div class="page-navigation"></div>
	</div>
</body>
</html>