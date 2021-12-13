// $(document).ready(function () {
//     $('a[id="minusButton"]').on('click', function () {
//         let productId = $(this).attr('pid');
//         let quantityInput = $('#quantity' + productId);
//         let newQuantity = parseInt(quantityInput.val()) - 1;
//         if (newQuantity > 0) {
//             quantityInput.val(newQuantity);
//         }
//     });
// });

// $(document).ready(function () {
//     $('a[id="plusButton"]').on('click', function (e) {
//         const bookId = parseInt($(this).attr('bookId'));
//         fetch("http://localhost:8080/books/api")
//             .then(response => response.json())
//             .then(books => {
//                 const book = books.filter(b => b.id === bookId)[0];
//                 if (book) {
//                     const quantityInput = $('#quantity' + bookId);
//                     let newQuantity = parseInt(quantityInput.val()) + 1;
//                     if (newQuantity <= book.copies + parseInt(quantityInput.val())) {
//                         quantityInput.val(newQuantity);
//                     } else {
//                         $('[data-toggle="popover"]').popover('show');
//                     }
//                 }
//             });
//     });
// });


window.addEventListener('load', function () {
    document.querySelectorAll('a[id="minusButton"]')
        .forEach(a =>
            a.addEventListener('click', function () {
                const bookId = parseInt($(this).attr('bookId'));
                fetch("http://localhost:8080/books/api")
                    .then(response => response.json())
                    .then(books => {
                        const book = books.filter(b => b.id === bookId)[0];
                        if (book) {
                            const quantityInput = $('#quantity' + bookId);
                            let newQuantity = parseInt(quantityInput.val()) - 1;
                            if (newQuantity > 0) {
                                quantityInput.val(newQuantity);
                            }
                        }
                    });
            })
        );
});

window.addEventListener('load', function () {
    document.querySelectorAll('a[id="plusButton"]')
        .forEach(a =>
            a.addEventListener('click', function (e) {
                e.preventDefault();
                const bookId = parseInt($(this).attr('bookId'));
                fetch("http://localhost:8080/books/api")
                    .then(response => response.json())
                    .then(books => {
                        const book = books.filter(b => b.id === bookId)[0];
                        if (book) {
                            const quantityInput = $('#quantity' + bookId);
                            let newQuantity = parseInt(quantityInput.val()) + 1;
                            if (newQuantity <= book.copies + parseInt(quantityInput.val())) {
                                quantityInput.val(newQuantity);
                                window.location = this.href;
                            } else {
                                $(this).attr('data-toggle', 'popover').popover('show');
                            }
                        }
                    });
            })
        );
});


$('.popover-dismiss').popover({
    trigger: 'focus'
})









