function selectAll() {
    const checkbox = document.getElementById("selectAll");
    const isChecked = checkbox.checked;
   
    if(isChecked) {
        AllCheck()
    }else {
        AllUnCheck()
    }
    
}

function checkboxClick(){
    const allCount = document.querySelectorAll(".check").length;
    const query = 'input[name="check"]:checked'
    const selectedElements = document.querySelectorAll(query);
    const selectedElementsCount = selectedElements.length;

    let result = '';

    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    document.getElementById('result').innerText = result;

    console.log(result);

    const cartButton = document.querySelector(".cart-button");

    cartButton.addEventListener('click', function(e) {
        e.preventDefault();

        $.ajax({
            type: "post",
            url: "/cart",
            dataType: "json",
            data: result,
            success: function(res) {
                if(res.msg == "success") {
                    alert("장바구니에 추가되었습니다.");
                    location.href = "/cart";
                }
            },
            error: function(err) {
                console.log(err);
            }
        });

    });
        
    if(allCount == selectedElementsCount){
         document.getElementById('selectAll').checked = true;
    }

    else{
        document.getElementById('selectAll').checked = false;
    }


}

function AllCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = true;
    });
}

function AllUnCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = false;
    });
}





