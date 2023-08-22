    function deleteAccount(regId){
      if(confirm("회원정보를 삭제 하시겠습니까? \n삭제 된 정보는 복원할 수 없습니다.")){
        $.ajax({
          type : "get",
          url  : " /admin/AccountView/delete",
          dataType : "json",
          data: {regId},
          success: function(res){
            if(res.msg == "success"){
              alert("회원 정보가 삭제 되었습니다.")
              location.href = "/admin/account";
            }
          },
          error:function(err){
            console.log(err)
          }
        });
      }
    }

    function deleteAccountImg(regId){
      if(confirm("회원 이미지를 삭제 하시겠습니까? \n삭제 된 이미지는 복원할 수 없습니다.")){
        $.ajax({
          type : "get",
          url  : "/admin/AccountView/deleteImg",
          dataType : "json",
          data: {regId},
          success: function(res){
            if(res.msg == "success"){
              alert("회원 이미지가 삭제 되었습니다.")
              location.reload();
            }
          },
          error:function(err){
            alert("저장된 이미지가 없습니다.")
            location.reload();
            console.log(err)
          }
        });
      }
    }
