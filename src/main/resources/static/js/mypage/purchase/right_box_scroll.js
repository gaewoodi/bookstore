const boxScroll = document.querySelector("#purchaseBox");
const boxHeight = boxScroll.getBoundingClientRect().height;

document.addEventListener('scroll', () => {
	if (window.scrollY >= boxHeight) {
		boxScroll.classList.add('active');
	} else {
		boxScroll.classList.remove('active');
	}
});

function count(type)  {
	// 결과를 표시할 element
	const resultElement = document.getElementById('result');

	// 현재 화면에 표시된 값
	let number = resultElement.innerText;

	// 더하기/빼기
	if(type === 'plus') {
		number = parseInt(number) + 1;
	}else if(type === 'minus')  {
		number = parseInt(number) - 1;
	}

	// 결과 출력
	resultElement.innerText = number;
}