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
<link rel="stylesheet" href="/css/style.css">

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
                        <a href="view/detail1.jsp" style="color:blue; margin-right: 10px;">#귀멸의칼날</a>
                        <a href="view/detail2.jsp" style="color:blue; margin-right: 10px;">#주술회전</a>
                        <a href="view/detail3.jsp" style="color:blue">#최애의아이</a>
                        <input type="text" style="width: 400px; margin-top:15px" placeholder="검색어를 입력하세요">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">검색</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- contents -->
        <!-- slide banner -->
        <div class="row">
            <div id="carouselExampleCaptions" class="carousel slide col-12 g-0">
                <div class="carousel-inner mt-5">
                    <div class="carousel-item active">
                        <img src="img/banner_1.jpg" class="d-block w-100" alt="퀴멸의칼날 배너" />
                    </div>
                    <div class="carousel-item">
                        <img src="img/banner_2.jpg" class="d-block w-100" alt="주술회전 배너" />
                    </div>
                    <div class="carousel-item">
                        <img src="img/banner_3.jpg" class="d-block w-100" alt="최애의아이 배너" />
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>

            <!-- contents 1 -->
            <div class="row" style="margin-top: 70px; margin-left: auto; margin-right: auto;">
                <h3><span style="color: deeppink;">ANI-MATE</span> 인기작품</h3>
                <hr>
                <div class="col-12 col-md-4" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="view/detail1.jsp">
                            <img src="img/image1.jpg" class="card-img-top" id="content-image1" alt="귀멸의칼날">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 24px;">귀멸의 칼날
                                <span class="card-text" style="font-size: 16px; color: grey;"><a
                                        href="detail1.jsp">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="view/detail2.jsp">
                            <img src="img/image2.png" class="card-img-top" alt="주술회전">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 24px;">주술회전
                                <span class="card-text" style="font-size: 16px; color: grey;"><a
                                        href="detail2.jsp">자세히보기</a></span>
                            </p>

                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-4" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="view/detail3.jsp">
                            <img src="img/image3.png" class="card-img-top" alt="최애의 아이">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 24px;">최애의 아이
                                <span class="card-text" style="font-size: 16px; color: grey;"><a
                                        href="detail3.jsp">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <!-- contents 1 -->
            <div class="row" style="margin-top: 70px; margin-left: auto; margin-right: auto;">
                <h3><span style="color: deeppink;">역대</span> 인기작품</h3>
                <hr>

                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_1.jpg" class="card-img-top" id="content-image1" alt="스파이 패밀리">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">스파이 패밀리
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_2.jpg" class="card-img-top" id="content-image1" alt="하이큐">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">하이큐
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_3.jpg" class="card-img-top" id="content-image1" alt="마슐">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">마슐
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_4.jpg" class="card-img-top" id="content-image1" alt="원피스">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">원피스
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_5.jpg" class="card-img-top" id="content-image1" alt="나루토">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">나루토
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_6.jpg" class="card-img-top" id="content-image1" alt="블리치">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">블리치
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_7.jpg" class="card-img-top" id="content-image1" alt="체인소맨">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">체인소맨
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-6 col-md-4 col-lg-3" style="margin-top: 15px;">
                    <div class="card" style="width: 100%;">
                        <a href="#">
                            <img src="img/popular_8.jpg" class="card-img-top" id="content-image1" alt="드래곤볼">
                        </a>
                        <div class="card-body">
                            <p class="card-text" style="font-size: 22px;">드래곤볼
                                <span class="card-text" style="font-size: 14px; color: grey;"><a
                                        href="#">자세히보기</a></span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row footer" style="margin-top: 70px; margin-left: auto; margin-right: auto;">
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

        <script>
            const nextBtn = document.querySelector(".carousel-control-next");
            setInterval(() => nextBtn.click(), 3000);
        </script>
</body>
</html>