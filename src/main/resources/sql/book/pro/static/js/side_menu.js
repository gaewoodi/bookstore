window.onload = () => {
    ComponentEvent.getInstance().addClickEventBookButton();
    ComponentEvent.getInstance().addClickEventMyPageButton();
}

class ComponentEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ComponentEvent();
        }
        return this.#instance;
    }

    addClickEventBookButton() {
        const bookButton = document.querySelector(".book-button");

        bookButton.onclick = () => {
            const tab1 = document.getElementById("tab1");
            tab1.style.display = (tab1.style.display != 'none') ? "none" : "block";
        }
       
    }

    addClickEventMyPageButton() {
        const myPageButton = document.querySelector(".mypage-button");

        myPageButton.onclick = () => {
            const tab2 = document.getElementById("tab2");
            tab2.style.display = (tab2.style.display != 'none') ? "none" : "block";
        }
       
    }

   
}
