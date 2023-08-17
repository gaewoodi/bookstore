function checkboxArr() {
    var checkArray = [];     // 배열 초기화
    $("input[name='check']:checked").each(function(i) {
        // 체크된 것만 값을 뽑아서 배열에 push
        checkArray.push($(this).val());     
    });

    $.ajax({
        url: 'cart'
        , type: 'post'
        , dataType: 'text'
        , data: {
            valueArray: checkArray
        }
    });
}

// ** 좋아요 ** //
// const likeButton = document.querySelector(".like-button");

// likeButton.addEventListener('click', function(e) {
//     e.preventDefault();
    
//     // let likeCount = 
    
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
