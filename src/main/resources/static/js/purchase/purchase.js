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
