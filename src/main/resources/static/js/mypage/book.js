$(function() {
    $.ajax ({
        type: "get",
        url: "/book",
        dataType: "json",
        success: function() {
            console.log("book정보가져오기성공");
        },
        error: function(error) {
            console.log(error);
        }

    });
});



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


    console.log(result);

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
function AllCheck() {
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = true;
    });
}

//체크박스 전체 체크 해제
function AllUnCheck() {
    document.querySelectorAll(".check").forEach(function(v) {
        v.checked = false;
    });
}

const likeButton = document.querySelector(".like-button");


likeButton.addEventListener('click', function(e) {
    e.preventDefault();

    alert("버튼 클릭");

    // const likeButtons = document.querySelectorAll(".like-buttons");
    // const bookIds = document.querySelectorAll(".book-id");
    // const likeCounts = document.querySelectorAll(".like-count");

    // likeButtons.forEach((button, index) => {
    //     button.onclick = () => {
    //         if(button.classList.contains("like-button")) {
    //             let bookIdValues = bookIds[index].value;
    //             let likeCount = -1;
                    
    
    //             if(likeCount != -1){
    //                 likeCounts[index].textContent = likeCount;
    //                 button.classList.remove("like-button");
    //                 button.classList.add("dislike-button");
    //                 button.textContent = "추천취소";
    //             }
              
    //         }
    //         // else {
    //         //     if(likeCount != -1){
    //         //         likeCounts[index].textContent = likeCount;
    //         //         button.classList.remove("dislike-button");
    //         //         button.classList.add("like-button");
    //         //         button.textContent = "추천";
    //         //     }
    //         // }
    
    //     }

    //     $.ajax({
    //         type: "post",
    //         url: "/like",
    //         dataType: "json",
    //         success : function(res) {
    //             if(res.msg == "success") {
    //                 alert("좋아요 성공.");
    //                 location.reload();
    //             }
    //         },
    //         error: error => {
    //             console.log(error);
    //         }
    //     });
    
    // });

    

});


