let cartButton = document.querySelector(".cart-button");

//체크된 체크박스 전체개수
const query = 'input[name="check"]:checked'
// 선택된 목록 가져오기
const selectedElements = document.querySelectorAll(query);

// 선택된 목록에서 value 찾기
let bookId = '';

selectedElements.forEach((el) => {
    bookId += el.value + '';
});

console.log("boojs임" + bookId);

cartButton.addEventListener('click', function(e) {
    e.preventDefault();

    location.href = "/cart?bookId=${book.bookId}";
});
 
 