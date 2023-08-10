  
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

        // 탭메뉴
        $(document).ready(function () {

            $('.main6-menu ul li').click(function () {
                var tab_id = $(this).attr('data-tab');

                $('.main6-menu ul li').removeClass('active');
                $('.tab-content').removeClass('active');

                //tab-content의 내용을 display:none으로 처리해 두고 탭 버튼을 누르면 해당 tab-content에 active.
                $(this).addClass('active');
                $("#" + tab_id).addClass('active');
            })

        })



        