

let userid = document.querySelector(".userid");
let passwd = document.querySelector(".passwd");
let passwd2 = document.querySelector(".passwd2");

function frmCheck() {
    if( !passwd.value) {
        $("#chkPage").html("비밀번호를 입력해 주세요.");
        $("#chkPage").css("padding", "20px 50px");
        $("#chkPage1").html("비밀번호를 확인해주세요.");
        $("#chkPage1").css("padding", "20px 30px");
        passwd.focus();
        return false;

    }else {
        $.ajax({
            type : "post",
            url : "/chkPwd",
            dateType : "json",
            data : {passwd: passwd.value},
            success : function(res) {
                if(res > 0) {
                    $("#chkPage").html("사용할 수 없는 비밀번호입니다.");
                    $("#chkPage").css("padding", "20px 50px");
                    $("#chkPage1").html("비밀번호가 일치하지 않습니다.");
                    $("#chkPage1").css("padding", "20px 30px");
                    passwd.value = "";
                    passwd.focus();

                }else {
                    $("#chkPage").html("사용가능한 비밀번호입니다.");
                    $("#chkPage").css("padding", "20px 50px");
                    $("#chkPage1").html("입력한 비밀번호와 일치합니다.");
                    $("#chkPage1").css("padding", "20px 30px");
                }
            },
            error : function(err) {
                console.log(err);
            }
        });
    }
}

passwd2.addEventListener('focus', frmCheck);





