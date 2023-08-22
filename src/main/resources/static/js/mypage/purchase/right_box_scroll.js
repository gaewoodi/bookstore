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
	const resultElement = document.getElementById('result');

	let number = resultElement.innerText;

	if(type === 'plus') {
		number = parseInt(number) + 1;
	}else if(type === 'minus')  {
		number = parseInt(number) - 1;
	}

	resultElement.innerText = number;
}