
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
                success : function(res, check) {
                    console.log(res.msg);
                        if(res.msg == "admin") {
                            alert("관리자 로그인 되었습니다.");
                            location.href = "/admin/dashboard";

                        }else if(res.msg == "normal") {
                            alert("일반회원 로그인 되었습니다.");
                            location.href = "/main";
                        }else {
                            alert("아이디 또는 비밀번호를 잘못 입력했습니다.\n 입력하신 내용을 다시 확인해주세요.");
                            location.href = "/login";
                        }
                    }
                });
            });







