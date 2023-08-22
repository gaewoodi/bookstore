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


    // 출력
    // document.getElementById('result').innerText = result;

    // console.log(result);

    //체크박스 전체개수와 체크된 체크박스 전체개수가 같으면 전체 체크박스 체크
    if(allCount == selectedElementsCount){
         document.getElementById('selectAll').checked = true;
    }

    //같지않으면 전체 체크박스 해제
    else{
        document.getElementById('selectAll').checked = false;
    }

    let regIdValue = document.querySelector(".reg-id").value;
    console.log("regIdValue: " + regIdValue);
    console.log("result: " + result);
    console.log("checkArray: " + checkArray);

    $('input[name="check"]').isChecked(function(){
        $('.book-name').append('완벽한 사과는 없다 : 김혜진 장편소설');
    });

    // $.ajax({
    //     url: "/purchase", 
    //     type: "post", 
    //     dataType: "json", 
    //     data: {
    //         checkboxResult: result,
    //         regIdValue: regIdValue,
    //         checkArray: checkArray
    //     },
    //     success: function(res) {
    //         if(res.msg == "success") {
    //             alert("결제정보나옴");
    //         } 

    //     },
    //     error: function(err) {
    //         console.log(err);
    //     }
    // });
    

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

