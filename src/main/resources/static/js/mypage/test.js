//전체 선택했을 때
function selectAll() {
    const checkbox = document.getElementById("selectAll");
    const isChecked = checkbox.checked;
   
    if(isChecked) {
        AllCheck()

    }else {
        AllUnCheck()
    }
    
}

function checkboxClick() {
    //체크박스 전체개수
    const allCount = document.querySelectorAll(".check").length;
    //체크된 체크박스 전체개수
    const query = 'input[name="check"]:checked'
    // 선택된 목록 가져오기
    const selectedElements = document.querySelectorAll(query);
    const selectedElementsCount = selectedElements.length;

    // 선택된 목록에서 value 찾기
    let result = '';


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });
    
    console.log("result값: " + result);

    const checkArray = [];
    // Name이 check 속성 취득
    const checks = document.getElementsByName("bookId");
    // 취득한 속성 만큼 루프
    for (let i = 0; i < checks.length; i++) {
        // 속성중에 체크 된 항목이 있을 경우
        if (checks[i].checked == true) {
            checkArray.push(checks[i].value);
            
        }
    }
    // 결과를 표시
    console.log("checkArray 안에 값들" + checkArray.value);

    let cartButton = document.querySelector(".cart-button");

    cartButton.addEventListener('click', function(e) {
        e.preventDefault();

        for(let i = 0; i < result.length; i++) {
            location.href = `/cart?bookId=${result[0]}&bookId=${result[2]}&bookId=${result[4]}`;
        }
    });


}


   

//체크박스 전체 체크
function AllCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = true;
    });
}

//체크박스 전체 체크 해제
function AllUnCheck(){
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = false;
    });
}

