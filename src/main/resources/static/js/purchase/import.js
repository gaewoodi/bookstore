function iamport(){

    var flag = $("#flag").val();
    var principalId = $("#principalId").val();
    var name = $("#name").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var postcode = $("#postcode").val();
    var address = $("#address").val() + " " + $("#detailAddress").val();

    var productName;
    var productId = $("#productId").val();
    var detailName = $("#productName").val();
    var cartName = $("#cartName").val();
    var amount = $("#amount").val();
    var price = $("#total-price").text();


    //가맹점 식별코드
    IMP.init("imp07834451");
    IMP.request_pay({
        pg : 'kcp',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : productName,
        amount : price,
        buyer_email : email,
        buyer_name : name,
        buyer_tel : phone,
        buyer_addr : address,
        buyer_postcode : postcode
    }, function(res) {

        // 결제검증
        $.ajax({
            type : "POST",
            url : "/verifyIamport/" + res.imp_uid
        }).done(function(data) {

            if(res.paid_amount == data.response.amount){
                alert("결제 및 결제검증완료");

                //결제 성공 시 비즈니스 로직

            } else {
                alert("결제 실패");
            }
        });
    });
}