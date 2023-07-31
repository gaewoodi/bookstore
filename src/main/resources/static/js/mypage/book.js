let cartButton = document.querySelector(".cart-button");
        
cartButton.addEventListener('click', function(e) {
    e.preventDefault();

    const checkArray = [];

    //체크된 체크박스 전체개수
    const query = 'input[name="check"]:checked'

    // 선택된 목록 가져오기
    const selectedElements = document.querySelectorAll(query);

    const checkValue = document.querySelectorAll(".check");
    const checkValues = document.querySelectorAll(".check").value;

    if(checkValue.checked) {
        console.log(checkValues);
    }

});