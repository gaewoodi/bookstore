let cartButton = document.querySelector(".cart-button");
        
cartButton.addEventListener('click', function(e) {
    e.preventDefault();
    //체크된 체크박스 전체개수
    const query = 'input[name="check"]:checked'
    // 선택된 목록 가져오기
    const selectedElements = document.querySelectorAll(query);

    let bookId = '';
    // 선택된 목록에서 value 찾기
    selectedElements.forEach((el) => {
        bookId += el.value + '';
    });

    console.log("이벤트안" + bookId);

    location.href = `/cart?bookId=${bookId}`;
});