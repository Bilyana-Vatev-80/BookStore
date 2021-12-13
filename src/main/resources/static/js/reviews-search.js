let reviewsBtn = document.querySelector('#user-reviews a');
let userReviewsContainer = document.getElementById('user-reviews-container');
let bookReviewsContainer = document.getElementById('book-reviews-container');
let isAdmin = document.getElementById('isAdmin');

window.addEventListener('load', showBookReviews);

reviewsBtn.addEventListener('click', toggle);

function toggle(e) {
    e.preventDefault();

    if (this.innerText === 'Show My Reviews') {
        showUserReviews();
    } else {
        userReviewsContainer.innerHTML = '';
    }

    this.innerText = this.innerText === 'Show My Reviews'
        ? 'Hide My Reviews'
        : 'Show My Reviews';
}

function showBookReviews() {
    bookReviewsContainer.innerHTML = '';

    let bookId = parseInt(document.getElementById('bookId').value);

    fetch("http://localhost:8080/reviews/api/" + bookId)
        .then(response => response.json())
        .then(reviews => {
                if (reviews.length === 0) {
                    bookReviewsContainer.innerHTML =
                        `<div class="mb-3">
                            <h5 class="text-left text-secondary">Be the first one to write a review</h5>
                            <h6 class="text-left text-secondary">There are no reviews yet</h6>
                         </div>`;
                    return;
                }

                displayReviews(bookReviewsContainer, createBookReviewElement, ...reviews);
            }
        );
}

function showUserReviews() {
    userReviewsContainer.innerHTML = '';

    fetch("http://localhost:8080/reviews/api/user")
        .then(response => response.json())
        .then(reviews => {
                if (reviews.length === 0) {
                    userReviewsContainer.innerHTML =
                        `<div class="mt-3">
                            <h5 class="text-left text-secondary">You have no reviews yet.</h5>
                        </div>`;
                    return;
                }

                displayReviews(userReviewsContainer, createUserReviewElement, ...reviews);
            }
        );
}

function displayReviews(container, func, ...reviews) {
    for (const review of reviews) {
        container.appendChild(func(review));
    }
}

function createBookReviewElement(review) {
    let article = document.createElement('article');
    article.classList.add('card', 'row', 'mt-2', 'w-100');

    let dateTime = review.addedOn.slice(0, 19)
        .replace('T', ' ');

    article.innerHTML = `<div class="card-body">
                            <h5 class="card-title">${review.title}</h5>
                            <p class="card-text"><strong>Rating: </strong>${review.rating}</p>
                            <p class="card-text">${review.textContent}</p>
                            <footer class="blockquote-footer">Added by 
                                <strong>${review.nickname}</strong> 
                                on <strong>${dateTime}</strong>
                            </footer>
                        </div>`;

    if (isAdmin) {
        appendDeleteForm(article, review.id, review.bookId);
    }

    return article;
}

function createUserReviewElement(review) {
    let article = document.createElement('article');
    article.classList.add('card', 'row', 'mt-2', 'w-100');

    let dateTime = review.addedOn.slice(0, 19)
        .replace('T', ' ');

    article.innerHTML = `<h5 class="card-header">
                            <a href="/books/${review.bookId}">${review.bookTitle}</a>
                        </h5>
                        <div class="card-body">
                            <h5 class="card-title">${review.title}</h5>
                            <p class="card-text"><strong>Rating: </strong>${review.rating}</p>
                            <p class="card-text">${review.textContent}</p>
                            <footer class="blockquote-footer">Added by 
                                <strong>${review.nickname}</strong> 
                                on <strong>${dateTime}</strong>
                            </footer>
                        </div>`;

    appendDeleteForm(article, review.id, review.bookId);

    return article;
}

// TODO - fix delete functionality
function appendDeleteForm(article, reviewId, bookId) {
    let form = document.createElement('form');
    form.action = "/reviews/" + bookId + "/" + reviewId;
    form.method = "post";
    form.innerHTML = `<button id="deleteBtn" type="button"
                         title="Delete Review"
                         class="btn btn-link">
                            Delete Review
                      </button>`;

    article.querySelector('footer').appendChild(form);
}