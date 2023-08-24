function purchaseDelete() {
    let result = '';

    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    let regIdValue = document.querySelector(".regId").value;

    console.log("-------------------");
    console.log("regIdValue: " + regIdValue);
    console.log("result: " + result);


    $.ajax({
        url: "/purchase/delete", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
            regIdValue: regIdValue
        },
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("선택한 도서를 삭제하시겠습니까?")) {
                    location.href = `/purchase?regId=` + regIdValue;
                }
            } 

        },
        error: function(err) {
            console.log(err);
        }
    });

}