function likeCheckbox() {
    const query = 'input[name="checkBookId"]';
    const selectedElements = document.querySelectorAll(query);

    let result = '';

    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    console.log("result: " + result);

}
let likeButton = document.querySelector(".book-like");
let like = document.querySelector("#like");
let bookLike = document.querySelector(".bookLike").innerHTML;
console.log(bookLike);


likeButton.addEventListener("click", () => {
	
    bookLike = parseInt(bookLike) + 1;
	console.log("bookLike" + bookLike);

	$.ajax({
		type: "post",
		url: "/book/like",
		dataType: "json",
		data: {
			bookLike: bookLike
		},
		success: function() {
			location.reload();
		},
		error: function(err) {
			console.log(err);
		} 
	});
});