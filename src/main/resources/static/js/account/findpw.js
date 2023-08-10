
function pwCheck() {
    let id = document.querySelector(".id");

    if(!id.value) {
        alert("아이디를 입력해주세요.");
        id.focus();
        return false;
    }

    $.ajax({
        type : "post",
        url : "/findpw",
        dataType : "json",
        data : {id : id.value},
        success : function(res) {
            if(res.passwd != '') {
                alert(`사용자의 비밀번호는 ${res.passwd} 입니다.`);
                id.value = "";
                id.focus();

            }else {
                alert("일치하는 정보가 없습니다.");
            }
        },
        error : function(err) {
            console.log(err);
        }
    });
}
document.querySelector(".btn").addEventListener('click', pwCheck);