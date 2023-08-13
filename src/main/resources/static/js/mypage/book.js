
function checkboxArray() {
    let result = '';

    const query = 'input[name="check"]:checked';
    const selectedElements = document.querySelectorAll(query);


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    console.log("result: " + result);


    $.ajax({
        url: "/cart", 
        type: "post", 
        dataType: "json", 
        data: {
            checkboxResult: result,
        },
        success: function(res) {
            if(res.msg == "success") {
                if(confirm("장바구니로 이동하시겠습니까?")) {
                    location.href = `/cart`;    
                }
            }

        },
        error: function(err) {
            console.log(err);
        }
    });
}