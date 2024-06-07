$(() => {

    $('.file-list').on('click', '.delete-btn', (e) => {
        $(e.currentTarget).parent().remove();
    });

    $('#addFile').on('click', (e) => {
        if($('.file-list').children().length >= 5) return alert("더 이상은 Naver");
        const item = `
            <div class="package">
                <input type="file">
                <button class="delete-btn">x</button>
            </div>
        `
        $('.file-list').append(item);
    });

});