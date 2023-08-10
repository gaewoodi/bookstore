
let id = document.querySelector(".id");
        let passwd = document.querySelector(".passwd");
        let btn = document.querySelector(".btn");

        btn.addEventListener('click', function(e){
            e.preventDefault();

            if( !id.value ) {
                alert("아이디를 입력해 주세요.");
                id.focus();
                return false;
            }

            if( !passwd.value ) {
                alert("비밀번호를 입력해 주세요.");
                passwd.focus();
                return false;
            }

            $.ajax({
                type : "post",
                url : "/login",
                dataType : "json",
                data : {id : id.value, passwd : passwd.value},
                success : function(res) {
                console.log(res.msg);
                    if(res.msg == "confirm") {
                        alert("로그인 되었습니다.");
                        location.href = "/admin/dashboard";
                    }else {
                        alert("일반회원입니다.");
                        location.href = "/main";
                    }
                }
            });

        });