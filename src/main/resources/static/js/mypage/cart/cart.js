function checkboxArray() {
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

    let regIdValue = document.querySelector(".reg-id").value;

    $.ajax({
        url: "/cart", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue
        },
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("장바구니로 이동하시겠습니까?")) {
                    location.href = `/cart?regId=` + regIdValue;
                }
            } 

        },
        error: function(err) {
            console.log(err);
        }
    });
}