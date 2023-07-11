$(function() {
    $('#purchasebutton').click(function() {
        //가맹점 식별코드
        IMP.init("imp07834451");
        IMP.request_pay({
            pg : 'kcp',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : bookName,
            amount : amount,
            buyer_email : email,
            buyer_name : userName,
            buyer_tel : phone,
            buyer_addr : address,
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
    });
});

class Purchase {
    amount = null;
    bookName = null;
    userName = null;
    password = null;
    email = null;
    phone = null;
  
    constructor(amount, bookName, userName, password, email, phone) {
      this.amount = amount;
      this.bookName = bookName;
      this.userName = userName;
      this.password = password;
      this.email = email;
      this.phone = phone;
    }
}

// function iamport(){

//     var flag = $("#flag").val();
//     var userId = $("#principalId").val();
//     var username = $("#name").val();
//     var address = $("#phone").val();
//     var email = $("#email").val();

//     var bookName;
//     var bookId = $("#productId").val();
//     var detailName = $("#productName").val();
//     var cartName = $("#cartName").val();
//     var amount = $("#amount").val();
//     var price = $("#total-price").text();


//     //가맹점 식별코드
//     IMP.init("imp07834451");
//     IMP.request_pay({
//         pg : 'kcp',
//         pay_method : 'card',
//         merchant_uid : 'merchant_' + new Date().getTime(),
//         name : productName,
//         amount : price,
//         buyer_email : email,
//         buyer_name : name,
//         buyer_tel : phone,
//         buyer_addr : address,
//         buyer_postcode : postcode
//     }, function(res) {

//         // 결제검증
//         $.ajax({
//             type : "POST",
//             url : "/verifyIamport/" + res.imp_uid
//         }).done(function(data) {

//             if(res.paid_amount == data.response.amount){
//                 alert("결제 및 결제검증완료");

//                 //결제 성공 시 비즈니스 로직

//             } else {
//                 alert("결제 실패");
//             }
//         });
//     });
// }