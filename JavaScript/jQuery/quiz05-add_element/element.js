$(() => {

    let count = 1;

    $('#upAdd').on('click', () => {
        let text = `
            <p>
                ContentMessage Here: ${count++}
            </p>
        `
        $('.container').prepend(text);
    });

    $('#downAdd').on('click', () => {
        let text = `
            <p>
                ContentMessage Here: ${count++}
            </p>
        `
        $('.container').append(text);
    });

});