const booksList = document.getElementById('booksList');
const searchForm = document.getElementById('searchForm');
const categoriesSubmenu = document.getElementById('categoriesSubmenu');
const languagesSubmenu = document.getElementById('languagesSubmenu');

searchForm.addEventListener('submit', (e) => {
    e.preventDefault();

    booksList.innerHTML = '';
    const searchingCharacters = document
        .getElementById('searchBar').value.toLowerCase();

    fetch("http://localhost:8080/books/api")
        .then(response => response.json())
        .then(books => {
                for (const book of books) {
                    if (book.title.toLowerCase().includes(searchingCharacters)
                        || book.author.toLowerCase().includes(searchingCharacters)) {
                        booksList.appendChild(createBookArticle(book));
                    }
                }
            }
        );
});

categoriesSubmenu.addEventListener('click', (e) => {
    e.preventDefault();

    booksList.innerHTML = '';
    const searchCategory = e.target.getAttribute('value');

    fetch("http://localhost:8080/books/api")
        .then(response => response.json())
        .then(books => {
                for (const book of books) {
                    for (const category of book.categories) {
                        if (category === searchCategory) {
                            booksList.appendChild(createBookArticle(book));
                            break;
                        }
                    }
                }
            }
        );
});

languagesSubmenu.addEventListener('click', (e) => {
    e.preventDefault();

    booksList.innerHTML = '';
    const searchLanguage = e.target.getAttribute('value');

    fetch("http://localhost:8080/books/api")
        .then(response => response.json())
        .then(books => {
                for (const book of books) {
                    if (book.language === searchLanguage) {
                        booksList.appendChild(createBookArticle(book));
                    }
                }
            }
        );
});

function createBookArticle(b) {
    let article = document.createElement('article');
    article.classList.add('card', 'rounded', 'p-2', 'm-3', 'col-sm-6', 'col-md-3');
    article.innerHTML =
        `<a href="/books/${b.id}"
           title="${b.title}">
            <img class="card-image rounded" src="${b.pictureUrl}" alt="Thumbnail [100%x225]"
                 data-holder-rendered="true">
        </a>
        <div class="row btn-group d-flex justify-content-end my-2 mx-3 border-bottom border-info">
            
            <a href="/wishlist/add/${b.id}"
               type="button" class="btn btn-sm col-md-2"
               title="Add to Favorites">
                <i class="far fa-heart fa-lg"></i>
            </a>
            <a href="/cart/add/${b.id}"
               id="addToCardBtn"
               type="button" class="btn btn-sm col-md-2"
               title="Add to Cart">
                <i class="fas fa-shopping-cart fa-lg"></i>
            </a>
        </div>
        <div class="card-body pt-2">
            <div class="text-center">
                <h5 class="card-title">${b.title}</h5>
                <p class="card-text text-secondary">Author:
                    <a href="/authors/${b.authorId}">
                        ${b.author}
                    </a>
                </p>
                <p class="card-text">${b.price.toFixed(2)} BGN</p>
            </div>
        </div>`;

    article
        .querySelector('.btn-group')
        .prepend(showInStockDiv(b.copies));

    if (b.copies === 0) {
        article.querySelector('a[id="addToCardBtn"]')
            .classList.add('disabled');
    }

    return article;
}

function showInStockDiv(copies) {
    let strongEl = document.createElement('strong');
    if (copies === 0) {
        strongEl.textContent = 'Out of stock';
        strongEl.classList.add('text-secondary', 'col-md-8');
    } else {
        strongEl.textContent = 'In stock';
        strongEl.classList.add('text-success', 'col-md-8');
    }

    return strongEl;
}
