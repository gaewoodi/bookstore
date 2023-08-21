window.onload = () => {
    ComponentEvent.getInstance().addClickEventSidebarButton();
  }
  //대쉬보드 메뉴 열기
const dashboard = document.querySelector('.dashboard');

dashboard.classList.add('opened');

dashboard.addEventListener('click', function () {
  this.classList.toggle('opened');
});


  //사이드바 열기
  class ComponentEvent {
    static #instance = null;
    static getInstance() {
      if (this.#instance == null) {
        this.#instance = new ComponentEvent();
      }
      return this.#instance;
    }

    addClickEventSidebarButton() {
      const OnSidebar = document.querySelector("#sidebar-icon");

      OnSidebar.onclick = () => {
        const sidebar = document.getElementById("sidebar");
        sidebar.style.display = (sidebar.style.display != 'none') ? "none" : "block";
      }

    }
  }