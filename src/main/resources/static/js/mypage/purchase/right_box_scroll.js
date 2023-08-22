const boxScroll = document.querySelector("#purchaseBox");
const boxHeight = boxScroll.getBoundingClientRect().height;

document.addEventListener('scroll', () => {
	if (window.scrollY >= boxHeight) {
		boxScroll.classList.add('active');
	} else {
		boxScroll.classList.remove('active');
	}
});