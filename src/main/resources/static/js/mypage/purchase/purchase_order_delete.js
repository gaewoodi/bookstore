function orderDelete() {
    let result = '';

    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    console.log("result: " + result);

    let regIdValue = document.querySelector(".reg-id").value;

    $.ajax({
        url: "/purchase/order/delete", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue
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