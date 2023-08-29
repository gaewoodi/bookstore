function formCheck() {
    let id = document.querySelector(".id");
    let passwd = document.querySelector(".passwd");
    let passwd2 = document.querySelector(".passwd2");
    let name = document.querySelector(".name");

    if(!id.value) {
    alert("아이디를 입력해주세요.");
    id.focus();

    return false;
    }

    if(!passwd.value) {
        alert("비밀번호를 입력해주세요.");
        passwd.focus();

        return false;
    }

    if(passwd.value != passwd2.value) {
        alert("비밀번호가 일치하지 않습니다.\n 비밀번호를 다시 입력해주세요.");
        passwd2.value = "";
        passwd2.focus();

        return false;
    }

    if(!name.value) {
        alert("이름을 입력해주세요.");
        name.focus();

        return false;
    }

    let email = $(".email1").val() + $(".email2").val()

    let obj = {
        regId : $(".regId").val(),
        id : $(".id").val(),
        passwd : $(".passwd").val(),
        name : $(".name").val(),
        birth : $(".birth").val(),
        gender : $("input[type='radio']:checked").val(),
        email : email,
        postcode : $(".postcode").val(),
        address : $(".address").val(),
        address1 : $(".address1").val(),
        tel : $(".telephone").val(),
        level : $(".level").val(),
        grade : $(".grade").val()
    };

    console.log(obj);

    $.ajax({
        type : "post",
        url : "/mypage/update",
        dataType : "json",
        data : obj,
        success : function(res) {
            if(res.msg == "success") {
                alert("회원 정보가 수정되었습니다.");
                location.reload();
            }
        }
    });
}

document.querySelector(".edit-button").addEventListener('click', formCheck);
