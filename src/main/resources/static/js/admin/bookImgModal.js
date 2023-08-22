
        function modal(bookId) {
            console.log(bookId);
            document.querySelector("#modal").style.display = "block";

            document.querySelector("#upload").addEventListener("click", function () {

                let formData = new FormData();
                formData.append("uploadFile", $(".uploadFile")[0].files[0]);
                formData.append("bookId", bookId)
                $.ajax({
                    type: "post",
                    url: "/admin/inventoryUpdate/Img",
                    enctype: "multipart/form-data",
                    data: formData,
                    processData: false,
                    contentType: false,
                    cache: false,
                    success: function (res) {
                        if (res.msg == "success") {
                            alert("이미지가 수정 되었습니다.")
                            location.reload();
                        }
                    },
                    error: function (err) {
                        location.reload();
                        console.log(err)
                    }
                });
            });
        }

        function closeModal() {
            document.querySelector("#modal").style.display = "none";
        }