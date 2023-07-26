  
        $(document).ready(function(){
            $('.owl-carousel').owlCarousel({
                // 한바퀴돌고나서 계속 돌거냐
                loop:true,
                // 사진옆간격
                margin:100,
                //화살표. 내비게이션 없애고 싶으면 false라고 써야함.
                nav:true,
                //밑에 점나오게 하는 것. > 요즘이거 잘 안씀
                dots:false,
                // 사이트 켜면 자동으로 돌아가게
                autoplay : true,
                // 돌아가는 시간
                autoplayTimeout: 2000,
                //마우스올리면 멈추게
                autoplayHoverPause : true,
                // 가운데로 들어가게
                center:true,
                // 반응형
                // animateOut :'fadeOut';
                responsive:{
                    0:{
                    //밑에 점나오게 하는 것. > 요즘이거 잘 안씀
                        dots:true,
                        items:1
                    },
                    600:{
                        items:1
                    },
                    1200:{
                        dots:false,
                        items:1
                    }
                }
            })
        });

        // 메뉴 펼쳤다 나오게하기
        function openmenu() {
            if(document.querySelector(".submenu").style.display === "block") {
                document.querySelector(".submenu").style.display = "none"
            }else {
                document.querySelector(".submenu").style.display = "block"
            }
    
        }

    // 메뉴이동
    // const tabList = document.querySelectorAll('main6-menu > ul > a > .one');
        
    // for(let i = 0; i < tabList.length; i++){
    //     tabList[i].querySelector('.one').addEventListener('click', function(e){
    //     e.preventDefault();
    //     for(let j = 0; j < tabList.length; j++){
    //         tabList[j].classList.remove('main6-list1');
    //     }
    //     this.parentNode.classList.add('main6-list1');
    //     });
    // }
    
    // for(let i=0; i<tabList.length; i++) {
    //     tabList[i].querySelector('.one').addEventListener('click', function(e) {
    //         e.preventDefault();
    
    //         for(let j=0; j<tabList.length; j++) {
    //             tabList[j].classList.remove();
    //         } 
    //     });
    // }







    // 탭전환 자바스크립트
    const tabList = document.querySelectorAll('.main .container .main6 .main6-secondwrap .main6-menu > ul > li');
    const contents = document.querySelectorAll('.main .container .main6 .main6-secondwrap .main6-menu .main6-list')
    let activeCont = '#one'; // 현재 활성화 된 컨텐츠 (기본:#tab1 활성화)
  
    for(var i = 0; i < tabList.length; i++){
      tabList[i].querySelector('.btn').addEventListener('click', function(e){
        e.preventDefault();
        for(var j = 0; j < tabList.length; j++){
          // 나머지 버튼 클래스 제거
          tabList[j].classList.remove('is_on');
  
          // 나머지 컨텐츠 display:none 처리
          contents[j].style.display = 'none';
        }
  
        // 버튼 관련 이벤트
        this.parentNode.classList.add('is_on');
  
        // 버튼 클릭시 컨텐츠 전환
        activeCont = this.getAttribute('href');
        document.querySelector(activeCont).style.display = 'block';
    });
}