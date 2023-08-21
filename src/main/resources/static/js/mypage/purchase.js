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
    let bookName = document.querySelector(".bookName").innerText;
    let price = document.querySelector(".price").innerText;

    console.log("bookName: "+ bookName);
    console.log("price: "+ price);

    $.ajax({
        url: "/purchase", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue,
            bookName: bookName,
            price: price
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