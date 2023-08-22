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

function on_pay() { // 함수 호출 > 서버 에러가 없을 시 이니시스 결제창 호출
	
	$.ajax({
        url: "/purchase",
        type: "post",
        // work_no 
        data:  {
    		work_no : '${workData.work_no}', // 작업번호
    		estimate_no : '${estimateData.estimate_no}', // 견적서 번호 
    		total_pay_amount : '${estimateData.total_pay_amount }', // 결제할 금액 > 임의로 script 수정을 고려해 백엔드에서 데이터(금액, 고객정보 등등...) 검사 후 이니시스 결제창으로 전환 추천
    		pay_type_str : $('#pay-type').val() // 결제 타입
    	},
        success: function(resultData) {
        	console.log('resultData :: ',resultData)
        	if(resultData.result_code == "200"){
            	// 서버 에러가 없을 시 이니시스 페이지로 전환
        		myform = document.mobileweb; 
            	myform.action = "https://mobile.inicis.com/smart/payment/";
            	myform.target = "_self";
            	myform.submit(); 
        	} else {
        		alert('결제 에러')
        		return
        	}
        	
        },
        error: function(jqXHR, textStatus, errorThrown) {
           alert('결제 에러')
        }
	});  
	
}  

function comma(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

$(function () {
	
	console.log('개발환경 :: ',window.location.hostname)
	
	let p_mid;
	// 개발 환경에 따라 t_mid(결제 키) 설정
	if (window.location.hostname == 'localhost'){
		p_mid = "INIpayTest"
	} else {
		//
		p_mid = "real_inicis_key";

	}
	$('[name=P_MID]').val(p_mid);
	
	$('#pay-btn').val(comma(parseInt('${estimateData.total_pay_amount }')) +"원"+ " 결제하기");
	
    // 결제 완료 혹은 결제 중간 취소 시 이동페이지
	let next_url = window.location.origin + '/inicis/complete' + '?work_no='+'${workData.work_no}' + '&estimate_no=' + '${estimateData.estimate_no}'
	
    let vbank_url = window.location.origin + '/inicis/vbank'
	$('[name=P_NEXT_URL]').val(next_url)
	$('[name=P_NOTI_URL]').val(vbank_url)
	
	$('[name=P_AMT]').val(comma(parseInt('${estimateData.total_pay_amount }')));
})
