function getCheckBox() {
    const checkboxes = document.querySelectorAll('input[name="check"]');

    const checkArray = [];

    // 체크된 체크박스의 값을 배열에 추가한다
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            checkArray.push(checkboxes[i].value);
        }
    }

    // 선택된 과일을 출력한다
    if (checkArray.length > 0) {
        alert("선택된 도서: " + checkArray.join(", "));
    } else {
        alert("장바구니에 추가할 도서를 선택해주세요.");
    }

    $.ajax
}
