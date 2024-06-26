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
    
    <div style="height: 100px;"></div>

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

        <!-- Event List -->
        <div class="row" style="margin-top: 50px; margin-left: auto; margin-right: auto;">
            <h2> 회원들을 위한 <span style="color: deeppink;">BIG EVENT!!</span></h2>
            <hr>
            <div class="col-12 event-form">
                <div class="event-image">
                    <img src="../img/event_1.png" style="opacity: 1;" alt="event1">
                </div>
                <div class="event-content">
                    <h3>지금 VIP 가입하면 30% 할인!!</h3>
                    <span style="color: gray;">이벤트 기간: 2024.04.01 ~ 2024.05.01</span>
                </div>
            </div>
            <div class="col-12 event-form">
                <div class="event-image">
                    <img src="../img/event_1.png" alt="event1">
                </div>
                <div class="event-content">
                    <h3 style="color: gray;">지금 VIP 가입하면 40% 할인!! (종료)</h3>
                    <span style="color: gray;">이벤트 기간: 2024.03.01 ~ 2024.04.01</span>
                </div>
            </div>
            <div class="col-12 event-form">
                <div class="event-image">
                    <img src="../img/event_1.png" alt="event1">
                </div>
                <div class="event-content">
                    <h3 style="color: gray;">지금 VIP 가입하면 50% 할인!! (종료)</h3>
                    <span style="color: gray;">이벤트 기간: 2024.02.01 ~ 2024.03.01</span>
                </div>
            </div>
            <div class="col-12 event-form">
                <div class="event-image">
                    <img src="../img/event_1.png" alt="event1">
                </div>
                <div class="event-content">
                    <h3 style="color: gray;">지금 VIP 가입하면 50% 할인!! (종료)</h3>
                    <span style="color: gray;">이벤트 기간: 2024.01.01 ~ 2024.02.01</span>
                </div>
            </div>
            <div class="col-12 event-form">
                <div class="event-image">
                    <img src="../img/event_1.png" alt="event1">
                </div>
                <div class="event-content">
                    <h3 style="color: gray;">지금 VIP 가입하면 50% 할인!! (종료)</h3>
                    <span style="color: gray;">이벤트 기간: 2023.12.01 ~ 2024.01.01</span>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <div class="row footer" style="margin-top: 40px; margin-left: auto; margin-right: auto;">
            <br />
            <hr />
            <div class="col-12 col-md-4">
                <span style="color: deeppink; font-size: 30px;">ANI-MATE</span>
                <p>
                    (주)ANI-MATE 사업자 정보
                </p>
            </div>
            <div class="col-12 col-md-8" style="text-align: center;">
                <p>Create by Sion-Noh</p>
                <p>Contract Kakao: test123 　| 　E-mail: test@gamil.com</p>
            </div>
        </div>
    </div>
</body>
</html>