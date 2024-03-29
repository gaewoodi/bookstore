window.onload = () => {
    ComponentEvent.getInstance().addClickEventBookButton();
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

   
}

