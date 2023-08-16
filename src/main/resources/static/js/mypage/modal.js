function modal(regId) {
    document.querySelector("#modal").style.display = "block";
    // regId에 해당되는 첨부파일 들고오기
    document.querySelector("#upload").addEventListener("click",  function () {
        let formData = new FormData();
        formData.append("uploadFile", $(".uploadFile")[0].files[0]);
        formData.append("regId", regId)

        $.ajax({
            type: "post",
            url: "/mypage/update/upload",
            encType: "multipart/form-data",
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function(res) {
                if(res.msg == "success") {
                    alert("이미지가 수정 되었습니다.");
                    location.href = `/mypage/update?&regId=${regId}`
                }
            },
            errer: function(err) {
                console.log(err);
            }

        });
    });


}

function closeModal() {
    document.querySelector("#modal").style.display = "none";
}
