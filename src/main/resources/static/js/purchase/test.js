function cartClick() {

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

    $.ajax({
        type: "post",
        url: "/cart",
        dataType: "json",
        data: bookId,
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?")) {
                    location.href = `/cart?bookId=${bookId}`;
                }
            }
           
        },
        error: function(err) {
            console.log(err);
        }
    });
}