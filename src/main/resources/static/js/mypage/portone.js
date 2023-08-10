const IMP = window.IMP;
IMP.init('imp07834451'); // 예: imp37739582(차이 공식 데모 계정용 가맹점 식별코드)

function requestPay() {
    IMP.request_pay({
        pg : 'kcp',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '도서결제' , //결제창에서 보여질 이름(bookName)
        amount : 100, //실제 결제되는 가격 (totalPrice)
        buyer_email : 'iamport@siot.do',
        buyer_name : '구매자이름',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울 강남구 도곡동',
        buyer_postcode : '123-456'
    }, function (rsp) {
        if (rsp.success) {
            $.ajax({
                async : false,
                type : "post",
                url: "http://localhost:8000/api/payment/complete",
                url : "/verifyIamport/" + rsp.imp_uid,
                contentType: 'application/json',
                dataType : "json",
                success : response => {
                    console.log(response);
                    successFlag = true;
                }                
            })
            location.href = 'http://localhost:8888/purchase';
        } else {
            // 차이 결제 시작 페이지로 리디렉션되기 전에 오류가 난 경우
            var msg = '오류로 인하여 요청을 처리하지 못했습니다.';
            msg += '에러내용 : ' + rsp.error_msg;

            alert(msg);
        }
    });
} 