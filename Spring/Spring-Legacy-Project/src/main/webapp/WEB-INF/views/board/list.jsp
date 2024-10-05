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
<h3> �Խñ� ( ${ count } )</h3>
	<c:choose>
		<c:when test="${ list.size() > 0 }">
			<table border=1>
				<tr>
					<td>.NO</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>��¥</td>
					<td>��ȸ��</td>
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
			<p> �Խñ��� �����ϴ�. </p>
		</c:otherwise>
	</c:choose>
	<a href="/">Ȩ����</a><br />
	<a href="/board/write">�۾���</a><br />
</body>
</html>