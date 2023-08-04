
function frmCheck() {
     let userid = document.querySelector(".userid");
     let passwd = document.querySelector(".passwd");
     let passwd2 = document.querySelector(".passwd2");
     let username = document.querySelector(".username");

     if(!userid.value) {
        alert("아이디를 입력해주세요.");
        userid.focus();
        return false;
     }

     if(!passwd.value) {
         alert("비밀번호를 입력해주세요.");
         passwd.focus();
         return false;
     }

     if(!passwd2.value) {
         alert("위에서 입력한 비밀번호를 한번 더 입력해주세요.");
         passwd2.focus();
         return false;
     }

     if(passwd.value != passwd2.value) {
         alert("비밀번호가 일치하지 않습니다.\n 비밀번호를 다시 입력해주세요.");
         passwd.value = "";
         passwd2.value = "";
         passwd.focus();
         return false;
     }

     if(!username.value) {
         alert("이름을 입력해주세요.");
         username.focus();
         return false;
     }
     let email = $(".email1").val() + $(".email2").val()

    let obj = {
        userid : $(".userid").val(),
        passwd : $(".passwd").val(),
        name : $(".username").val(),
        birth : $(".birth").val(),
        userGender : $("input[type='radio']:checked").val(),
        postcode : $("#postcode").val(),
        address : $("#address").val(),
        address1 : $("#address1").val(),
        tel : $(".tel1").val(),
        email : email
    };

    console.log(obj);

    $.ajax({
        type : "post",
        url : "/register",
        dataType : "json",
        data : obj,
        success : function(res) {
            if(res.msg == "success") {
                alert("회원가입이 완료되었습니다.\n 로그인 후 이용 가능합니다.");
                location.href = "/login";
            }
        }
    });
}

document.querySelector(".btn").addEventListener('click', frmCheck);

let userid1 = document.querySelector(".userid1");



