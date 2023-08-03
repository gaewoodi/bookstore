function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 주소 변수
            var addr = ''; 
            // 상세주소2 변수
            var extraAddr = ''; 

            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 상세주소2 값
                document.getElementById("address1").value = extraAddr;
            
            } else {
                // 상세주소2 값
                document.getElementById("address1").value = '';
            }
            // 우편번호
            document.getElementById('postcode').value = data.zonecode;
            // 도로명주소
            document.getElementById("address").value = addr;
            // 상세주소
            document.getElementById("address1").focus();
        }
    }).open();
}