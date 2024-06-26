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

        <!-- Video -->
        <div class="row">
            <div class="col-12">
                <div class="embed-container">
                    <iframe width="100%" height="100%"
                        src="https://www.youtube.com/embed/O-IWJk6K8IY?si=0kTv4VFza6oGaOMQ" frameborder="0"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
                </div>
            </div>
        </div>


        <!-- description -->
        <div class="row" style="margin-top: 15px;">
            <div class="col-12">
                <h2>[PV 공개] 귀멸의 칼날: 도공마을 편</h2>
            </div>
            <div class="col-12">
                <p>
                    [귀멸의 칼날: 도공 마을편] 4월 10일 월요일 밤 11시 첫 방송!
                </p>
            </div>
            <hr>
        </div>

        <!-- Up next List -->
        <div class="row m-1">
            <div class="d-none d-lg-block"></div>
            <div class="col-3 col-lg-3">
                <img src="../img/thumbnail_1.png" width="100%" height="100%" alt="">
            </div>
            <div class="col-9 col-lg-8">
                <h5 style="margin-top: 4px;">
                    [귀멸의 칼날 극장판: 무한열차편] PV 예고편
                </h5>
            </div>
            <div class="col-1 d-none d-lg-block"></div>
        </div>
        <div class="row m-1">
            <div class="d-none d-lg-block"></div>
            <div class="col-3 col-lg-3">
                <img src="../img/thumbnail_2.jpg" width="100%" height="100%" alt="">
            </div>
            <div class="col-9 col-lg-8">
                <h5 style="margin-top: 4px;">
                    주술회전 [애니박스] 7/7(금) 새벽 1시 첫방송
                </h5>
            </div>
            <div class="col-1 d-none d-lg-block"></div>
        </div>
        <div class="row m-1">
            <div class="d-none d-lg-block"></div>
            <div class="col-3 col-lg-3">
                <img src="../img/thumbnail_3.jpg" width="100%" height="100%" alt="">
            </div>
            <div class="col-9 col-lg-8">
                <h5 style="margin-top: 4px;">
                    최애의 아이 2기 키비주얼 2차 PV
                </h5>
            </div>
            <div class="col-1 d-none d-lg-block"></div>
        </div>

        <!-- Footer -->
        <div class="row footer" style="margin-top: 30px; margin-left: auto; margin-right: auto">
            <br />
            <hr />
            <div class="col-12 col-md-4">
                <span style="color: deeppink; font-size: 30px">ANI-MATE</span>
                <p>(주)ANI-MATE 사업자 정보</p>
            </div>
            <div class="col-12 col-md-8" style="text-align: center">
                <p>Create by Sion-Noh</p>
                <p>Contract Kakao: test123 　| 　E-mail: test@gamil.com</p>
            </div>
        </div>
    </div>
</body>
</html>