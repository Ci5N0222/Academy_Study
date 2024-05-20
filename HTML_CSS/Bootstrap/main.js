document.addEventListener('DOMContentLoaded', () => {

    const btn = document.querySelector('#writeBtn');
    const list = document.querySelector('.content-list');

    let content = '';
    let writer = '';

    document.querySelector('#contentInput').addEventListener('change', (e) => {
        content = e.target.value;
    });

    document.querySelector('#writerInput').addEventListener('change', (e) => {
        writer = e.target.value;
    });

    btn.addEventListener('click', () => {
        list.innerHTML +=
            `<div class="row">
                <div class="d-none d-md-flex justify-content-center col-md-1">8</div>
                <div class="col-12 col-md-5 content-title">${content}</div>
                <div class="col-2 text-center">${writer}</div>
                <div class="col-2 text-center">0</div>
                <div class="col-2 text-center">05-07</div>
            </div>`;
    });
    
});