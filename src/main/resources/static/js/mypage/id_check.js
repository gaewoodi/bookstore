const idCheck = document.querySelector(".id-check");
const userId = document.querySelector(".id");


idCheck.addEventListener('click', function() {

    if(!userId.value) {
        alert("아이디 중복확인을 해주세요.");
        userId.focus();
        return false;

    }else {
        $.ajax({
            type : "post",
            url : "/idCheck",
            dataType : "json",
            data : {id : userId.value},
            success : function(res) {
                if(res > 0) {
                    alert("사용할 수 없는 아이디입니다.");
                    userId.value = "";
                    userId.focus();

                }else {
                    alert("사용 가능한 아이디입니다.");
                }
            },
            error : function(err) {
                console.log(err);
            }
        });
    }
});

   
