
function findCheck() {
    let name = document.querySelector(".name");
    let birth = document.querySelector(".birth");

    if(!name.value) {
        alert("이름을 입력해주세요.");
        name.focus();
        return false;
    }

    if(!birth.value) {
        alert("생년월일을 선택해주세요.");
        birth.focus();
        return false;
    }


    $.ajax({
        type : "post",
        url : "/findid",
        dataType : "json",
        data : {
            name : name.value,
            birth : birth.value
        },
        success : function(res) {
        console.log(res.id);
             if(res.id != '' ) {
                // $("#id").text(data);
                 alert(`사용자의 아이디는 ${res.id} 입니다.`);
//                 alert(`사용자의 아이디는 $('#id').val() 입니다.`);
                 name.value = "";
                 name.focus();

             }else {
                 alert("일치하는 정보가 없습니다.");
             }
        },
        error : function(err) {
            console.log(err);
        }
    });
}
document.querySelector(".btn").addEventListener('click', findCheck);