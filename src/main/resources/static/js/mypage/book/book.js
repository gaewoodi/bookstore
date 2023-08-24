

function checkboxPurchase() {
    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);

    let result = '';

    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    console.log("result: " + result);

    let regIdValue = document.querySelector(".reg-id").value;

    $.ajax({
        url: "/purchase/save", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue
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

