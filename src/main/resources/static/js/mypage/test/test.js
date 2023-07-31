let cartButton = document.querySelector(".cart-button");
        
cartButton.addEventListener('click', function(e) {
    e.preventDefault();

    // 체크한 데이터를 담을 배열 선언
    const checkArray = [];
    // Name이 check 속성 취득
    const query = 'input[name="check"]:checked'
    const selectedElements = document.querySelectorAll(query);

    // 취득한 속성 만큼 루프
    for (let i = 0; i < selectedElements.length; i++) {
        // 속성중에 체크 된 항목이 있을 경우
        if (selectedElements[i].checked == true) {
            checkArray.push(selectedElements[i].value);
        }
    }
    // 결과를 표시
    console.log("checkArray 안에 값들" + checkArray);

    console.log(checkArray[0]);
    console.log(checkArray[1]);
    console.log(checkArray[2]);

    // location.href = `/cart?bookId=${checkArray[0]}&bookId=${checkArray[1]}&bookId=${checkArray[2]}`;

    // $.ajax({
    //     type: "POST",
    //     url: "/book",
    //     dataType: "json",
    //     success: function() {
    //         alert("성공");
    //     },
    //     error: function(err) {
    //         console.log(err);
    //     }
    // });


    
    // if(checkArray == 0) {
    //     location.href = location.href = `/cart?bookId=${checkArray}`;
    // }else {
    //     //체크된 체크박스 전체개수
    //     const query = 'input[name="check"]:checked'

    //     // 선택된 목록 가져오기
    //     const selectedElements = document.querySelectorAll(query);
    
    //     // 선택된 목록에서 value 찾기
    //     let result = '';

    //     selectedElements.forEach((el) => {
    //         result += el.value + ' ';
    //     });
    //     location.href = `/cart?bookId=${result}`;
    //     let qs = `&bookId=${result}`;

    //     location.href = `/cart?${qs}`;
    // }
 
    // location.href = `/cart?bookId=${checkArray}`;
});