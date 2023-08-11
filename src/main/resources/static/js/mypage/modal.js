function modal(regId) {
    document.querySelector("#modal").style.display = "block";
    // regId에 해당되는 첨부파일 들고오기
    document.querySelector("#upload").addEventListener("click",  function () {
        let formData = new FormData();
        formData.append("uploadFile", $(".uploadFile")[0].files[0]);
        formData.append("regId", regId)

        $.ajax({
            type: "post",
            url: "/update/upload",
            encType: "multipart/form-data",
            data: formData,
            processData: false,
            contentType: false,
            cache: false,
            success: function(res) {
                if(res.msg == "success") {
                    location.reload();
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
