let cartButton = document.querySelector(".cart-button");

const URLSearch = new URLSearchParams(location.search);

        
cartButton.addEventListener('click', function(e) {
    e.preventDefault();

    // 체크한 데이터를 담을 배열 선언
    const checkArray = [];
    // Name이 check 속성 취득
    const checks = document.getElementsByName("check");
    // 취득한 속성 만큼 루프
    for (let i = 0; i < checks.length; i++) {
        // 속성중에 체크 된 항목이 있을 경우
        if (checks[i].checked == true) {
            checkArray.push(checks[i].value);
            
        }
    }
    // 결과를 표시
    console.log(checkArray);

    $.ajax({
        type: "POST",
        url: "/book",
        dataType: "json",
        success: function() {
            alert("성공");
        },
        error: function(err) {
            console.log(err);
        }
    });


    
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