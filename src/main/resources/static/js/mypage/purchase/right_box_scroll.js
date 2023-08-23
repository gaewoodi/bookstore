const boxScroll = document.querySelector("#purchaseBox");
const boxHeight = boxScroll.getBoundingClientRect().height;

document.addEventListener('scroll', () => {
	if (window.scrollY >= boxHeight) {
		boxScroll.classList.add('active');
	} else {
		boxScroll.classList.remove('active');
	}
});

let minus = document.querySelector(".minus");
let plus = document.querySelector(".plus");
let resultElement = document.querySelector("#result");
let totalPrice = document.querySelector(".totalPrice");

let i = 1;

minus.addEventListener("click", () => {
	if(i > 0) {
		i--
		resultElement.textContent = i;

		let totalPriceNumber = i * 4500;
		totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";
	}else {
		totalPrice.textContent = 0 + "원"
	}

});

plus.addEventListener("click", () => {
	i++
	resultElement.textContent = i;

	let totalPriceNumber = i * 4500;
	totalPrice.textContent = totalPriceNumber.toLocaleString() + "원";
});
