function cartDelete() {
    let checkArray = [];     // 배열 초기화
    let result = '';

    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    console.log("result: " + result);

    $("input[name='check']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    let bookIdValue = document.querySelector(".bookId").value;

    $.ajax({
        url: "/cart/delete", 
        type: "delete", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            bookIdValue: bookIdValue
        },
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("선택한 목록을 장바구니에서 삭제하시겠습니까?")) {
                    location.href = `/cart?regId=` + regIdValue;
                }
            } 

        },
        error: function(err) {
            console.log(err);
        }
    });
}