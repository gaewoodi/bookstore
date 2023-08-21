function checkboxPurchase() {
    let checkArray = [];     // 배열 초기화
    let result = '';

    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    $("input[name='check']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    let regIdValue = document.querySelector(".reg-id").value;
    console.log("regIdValue: " + regIdValue);
    console.log("result: " + result);
    console.log("checkArray: " + checkArray);

    $.ajax({
        url: "/purchase", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue,
            checkArray: checkArray
        },
        success: function(res) {
            if(res.msg == "success") {
                alert("결제정보나옴");
            } 

        },
        error: function(err) {
            console.log(err);
        }
    });
}