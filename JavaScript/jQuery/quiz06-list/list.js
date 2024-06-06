
let article = [];

$(() => {

    // 동적 삭제
    // $('table').on('click', '.del', (e) => {
    //     $(e.currentTarget).closest('tr').remove();
    // });

    // $('#add').on('click', () => {
    //     if($('#title').val() === "") return alert("제목 없음");
    //     if($('#content').val() === "") return alert("내용 없음");
    //     if($('#writer').val() === "") return alert("작성자 없음");

    //     let item = `
    //         <tr>
    //             <td>${ $('#title').val() }</td>
    //             <td>${ $('#content').val() }</td>
    //             <td>${ $('#writer').val() }</td>
    //         </tr>
    //     `
    //     $('tbody').append(item);

    //     $('#title').val("");
    //     $('#content').val("");
    //     $('#writer').val("");
    // });

    // 검색받은 값을 포함하고 있으면 삭제
    // $('#del').on('click', () => {
    //     if($('#delTitle').val() === "") return alert("빈 입력값");
    //     $('tbody').children().each((i, item) => {
    //         if($($(item).children()[0]).html().includes($('#delTitle').val())){
    //             $(item).remove();
    //         }
    //     });
    // });


    const title = document.querySelector('#title');
    const content = document.querySelector('#content');
    const writer = document.querySelector('#writer');
    const delTitle = document.querySelector('#delTitle');
    const tbody = document.querySelector('tbody');

    // Add content btn event
    document.querySelector('#add').addEventListener('click', () => {
        const articleInfo = {
            title: title.value,
            content: content.value,
            writer: writer.value
        }
        article.push(articleInfo);

        displayList(article);
    });

    // Delete content btn event
    document.querySelector('#del').addEventListener('click', () => {
        delContent(delTitle.value);
    });

    // Display on content list function
    const displayList = (list) => {
        tbody.innerHTML = "";

        list.forEach(item => {
            const data = `
                <td>${ item.title }</td>
                <td>${ item.content }</td>
                <td>${ item.writer }</td>
            `
            let tr = document.createElement('tr');
            tr.innerHTML = data;
            tbody.append(tr);
        });
    }

    // Delete content function
    const delContent = (text) => {
        const newArticle = article.filter(item => !item.title.includes(text));
        article = newArticle;

        displayList(article);
    }

});