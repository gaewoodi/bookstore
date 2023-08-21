function checkboxPurchase() {
    let checkArray = [];     // 배열 초기화
    let result = '';
    let nameResult = '';
    let priceResult = '';

    const query = 'input[name="check"]:checked';
    const nameQuery = 'input[name="book-name"]:checked';
    const priceQuery = 'input[name="book-price"]:checked';
    const selectedElements = document.querySelectorAll(query);
    const nameQueryAll = document.querySelectorAll(nameQuery);
    const priceQueryAll = document.querySelectorAll(priceQuery);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    nameQueryAll.forEach((el) => {
        nameResult += el.value + ' ';
    });

    priceQueryAll.forEach((el) => {
        priceResult += el.value + ' ';
    });

    $("input[name='check']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    let regIdValue = document.querySelector(".reg-id").value;

    console.log("nameResult: "+ nameResult);
    console.log("priceResult: "+ priceResult);

    $.ajax({
        url: "/purchase", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue,
            bookName: nameResult,
            price: priceResult
        },
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("결제창으로 이동하시겠습니까?")) {
                    location.href = `/purchase?regId=` + regIdValue;
                }
            } 

        },
        error: function(err) {
            console.log(err);
        }
    });
}