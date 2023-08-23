let likeButton = document.querySelector(".book-like");
let like = document.querySelector("#like");
let bookLike = document.querySelector(".bookLike").textContent;

let i = 0;

likeButton.addEventListener("click", () => {
    i++
    like.textContent = i;

    bookLike.textContent = like.toLocaleString();

});
