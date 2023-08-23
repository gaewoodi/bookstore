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
    const query = 'input[name="check"]:checked';
    // 선택된 목록 가져오기
    const selectedElements = document.querySelectorAll(query);
    const selectedElementsCount = selectedElements.length;

    let checkArray = [];     // 배열 초기화
    // 선택된 목록에서 value 찾기
    let result = '';


    selectedElements.forEach((el) => {
        result += el.value + ' ';
    });

    $("input[name='check']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    for (let i = 0; i < checkArray.length; i++) {
    //   console.log("checkArray: " + checkArray[i]);
      checkArray[i];
    }

    console.log("checkArray: " + checkArray);    

    let minus = document.querySelector(".minus");
    let plus = document.querySelector(".plus");
    let resultElement = document.querySelector("#result");
    let totalPrice = document.querySelector(".totalPrice");
    
    let price = document.querySelector(".purchase-price").textContent;
    console.log("price: " + price);

    price.textContent = price + "원";
    totalPrice.textContent = 0 + "원"

    // let i = 1;

    // minus.addEventListener("click", () => {
    //     if(i > 0) {
    //         i--
    //         resultElement.textContent = i;

    //         let totalPriceNumber = i * checkArray;
    //         totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";

    //     }else {
    //         totalPrice.textContent = 0 + "원"
    //     }

    // });

    // plus.addEventListener("click", () => {
    //     i++
    //     resultElement.textContent = i;

    //     let totalPriceNumber = i * checkArray;
    //     totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";

    // });


    // 출력
    // document.getElementById('result').innerText = result;

    // console.log("result: " + result);

    //체크박스 전체개수와 체크된 체크박스 전체개수가 같으면 전체 체크박스 체크
    if(allCount == selectedElementsCount){
         document.getElementById('selectAll').checked = true;
    }

    //같지않으면 전체 체크박스 해제
    else{
        document.getElementById('selectAll').checked = false;
    }

    
    

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

