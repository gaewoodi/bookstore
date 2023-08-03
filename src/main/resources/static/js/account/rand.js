
var randomNum = {};

// 0~9까지의 난수
randomNum.random = function(n1, n2) {
    return parseInt(Math.random() * (n2 - n1 + 1)) + n1;
};

// 인증번호를 뽑을 난수 입력 n 5이면 5자리
randomNum.authNo = function(n) {
    var value = "";
    for(var i = 0; i < n; i++) {
        value += randomNum.random(0,9);
    }
    return value;
};

// 화면에 번호 출력
randomNum.printRandom = function(data, num) {
    document.getElementById(data).innerHTML = randomNum.authNo(num);
};

function getSend() {
    location.reload();
}