function count(type)  {
	const likeElement = document.getElementById('like');

	const bookLike = document.querySelector(".like-count").textContent;

    console.log(bookLike);

	if(type === 'plus') {
		bookLike = parseInt(bookLike) + 1;
	}

	likeElement.innerText = bookLike;
}
