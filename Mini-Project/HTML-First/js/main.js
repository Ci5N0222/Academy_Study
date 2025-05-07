document.addEventListener('DOMContentLoaded', () => {
    header();
    modal();
    footer();

    banner();
    card("best-ani");

    const nextBtn = document.querySelector(".carousel-control-next");
    setInterval(() => nextBtn.click(), 3000);
});

const header = () => {
    const item = `
        <div class="container-fluid navi">
        <div class="row navigation">
            <nav class="navbar navbar-expand-md">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.html" style="color: deeppink;">ANI-MATE</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="view/best.html">
                                    <p class="default-font">BEST</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="view/event.html">
                                    <p class="default-font">EVENT</p>
                                </a>
                            </li>
                            <li class="nav-item d-md-none">
                                <a href="view/login.html">
                                    <p class="default-font">Login</p>
                                </a>
                            </li>
                        </ul>
                        <div class="nav-account d-none d-md-block">
                            <i class="fa-solid fa-magnifying-glass" data-bs-toggle="modal"
                                data-bs-target="#exampleModal" style="cursor: pointer; margin-right: 15px;"></i>
                            <a href="view/login.html"><i class="fa-solid fa-user"></i></a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    `;
    document.querySelector('header').innerHTML = item;
}

const modal = () => {
    const item = `
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Search</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body text-center">
                        <a href="view/detail1.html" style="color:blue; margin-right: 10px;">#귀멸의칼날</a>
                        <a href="view/detail2.html" style="color:blue; margin-right: 10px;">#주술회전</a>
                        <a href="view/detail3.html" style="color:blue">#최애의아이</a>
                        <input type="text" style="width: 400px; margin-top:15px" placeholder="검색어를 입력하세요">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">검색</button>
                    </div>
                </div>
            </div>
        </div>
    `;
    document.querySelector('.modal').innerHTML = item;
}

const banner = () => {
    const item = `
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
        </div>
    `;
    document.querySelector('.banner').innerHTML = item;
}

const footer = () => {
    const item = `
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
    `;
    document.querySelector('.footer').innerHTML = item;
}


const card = (target) => {

    const arr = [
        { id: 0, title: "귀멸의 칼날", img: "img/image1.jpg" },
        { id: 1, title: "주술회전", img: "img/image2.png" },
        { id: 2, title: "최애의 아이", img: "img/image3.png" }
    ]

    for(let obj of arr ) {
        const item = `
            <div class="col-12 col-md-4 mt-3">
                <div class="card">
                    <a href="view/detail1.html">
                        <img src="${obj.img}" class="card-img-top" id="content-image1" alt="귀멸의칼날">
                    </a>
                    <div class="card-body">
                        <p class="card-text fs-4">${obj.title}
                            <span class="card-text text-secondary fs-6">
                                <a href="detail1.html">자세히보기</a>
                            </span>
                        </p>
                    </div>
                </div>
            </div>
        `;
        document.querySelector(`.${target}`).innerHTML += item;
    }
}