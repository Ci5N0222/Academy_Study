<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANI-MATE</title>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- Google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<!-- Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- fontawesome -->
<script src="https://kit.fontawesome.com/a0900b741f.js" crossorigin="anonymous"></script>

<link rel="icon" href="/img/favicon.PNG">
<link rel="stylesheet" href="/css/style.css" />

</head>
<body>
    <!-- Navbar -->
    <%@ include file="/view/include/header.jsp" %>

    <div class="container">
        <!-- Search Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Search</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body text-center">
                        <a href="detail1.jsp" style="color:blue; margin-right: 10px;">#귀멸의칼날</a>
                        <a href="detail2.jsp" style="color:blue; margin-right: 10px;">#주술회전</a>
                        <a href="detail3.jsp" style="color:blue">#최애의아이</a>
                        <input type="text" style="width: 400px; margin-top:15px" placeholder="검색어를 입력하세요">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">검색</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Login form -->
        <div class="login-container d-block d-md-flex">
            <div class="container login-form">
                <h1><a href="../index.jsp" style="color: deeppink">ANI-MATE</a></h1>
                <p>동시방영 신작부터 역대 인기작까지 한 곳에서 편-안하게!</p>
                <button class="btn btn-primary" onclick="location.href='../index.jsp'">
                    이메일로 시작
                </button>
                <hr />
                <div class="another-login">
                    <img src="../img/login_1.jpg" alt="" />
                    <img src="../img/login_2.png" alt="" />
                    <img src="../img/login_3.jpg" alt="" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>