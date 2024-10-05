<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> 게시글 ( ${ count } )</h3>
	<c:choose>
		<c:when test="${ list.size() > 0 }">
			<table border=1>
				<tr>
					<td>.NO</td>
					<td>제목</td>
					<td>작성자</td>
					<td>날짜</td>
					<td>조회수</td>
				</tr>
				<c:forEach var="list" items="${ list }" >
					<tr>
						<td>${ list.board_seq }</td>
						<td><a href="/board/detail?seq=${ list.board_seq }">${ list.board_title }</a></td>
						<td>${ list.board_writer }</td>
						<td><fmt:formatDate value="${ list.write_date }" pattern="yyyy-MM-dd" /></td>
						<td>${ list.board_count }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p> 게시글이 없습니다. </p>
		</c:otherwise>
	</c:choose>
	<a href="/">홈으로</a><br />
	<a href="/board/write">글쓰기</a><br />
</body>
</html>