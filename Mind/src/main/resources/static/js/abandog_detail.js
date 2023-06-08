$(document).ready(function(){
    let dogname = '';
    if(localStorage.getItem('name')){
        dogname = localStorage.getItem('name');
    }
    srt = '';
    $.ajax({
        type : "GET",
        url : "/abandog/detail/"+dogname, 
        dataType : "json",
        success : function(data){

            srt = srt + `<h1 id="main_nb">보호중인 유기견 상세 정보</h1>
        <div id="abandogbox_wrap">
            <div id="abandogbox_wrap1">
                    <img src="https://github.com/HajongChan2/abandoned_dog_site/blob/main/Mind/src/main/resources/static/img/btn_arrow_left.png?raw=true" alt="left" class="prev">
                    <img src="https://github.com/HajongChan2/abandoned_dog_site/blob/main/Mind/src/main/resources/static/img/btn_arrow_right.png?raw=true" alt="right" class="next">
                     <div class="slide">
                          <ul class="panel">
                            <li><img src="${data[0].adGallery}" alt="asd"></li>
                            <li><img src="${data[0].adGallery}" alt="asd"></li>
                            <li><img src="${data[0].adGallery}" alt="asd"></li>
                          </ul>
                          <ul class="dot">
                            <li class="on">슬라이드 버튼1번</li>
                            <li>슬라이드 버튼2번</li>
                            <li>슬라이드 버튼3번</li>
                          </ul>
                    
                     </div>
            </div>
            <div class="abandogbox_wrap2">
                <p class="content_text">등록 번호 : ${data[0].adNum}</p>
                <p class="content_text">이름 : ${data[0].adName}</p>
                <p class="content_text">나이 : ${data[0].adAge}</p>
                <p class="content_text">성별 : ${data[0].adSex}</p>
            </div>
        </div>
        <div class="center_line"></div>
        <h1 class="center_text">마음이</h1>
        <p class="center_text2">마음이 따뜻한 보호소</p>
        <div class="abandogbox_img1"></div>
        <div id="container1">
            <p class=center_text2>마음이 입양 안내 보러가기 ></p>
        </div>
        <div class="abandogbox_img1"></div>
        <div class="abandogbox_wrap2">
            <p class="content_text">분양 지역 : ${data[0].adArea}</p>
            <p class="content_text">품종 : ${data[0].adSpec}</p>
            <p class="content_text">접종 : ${data[0].adVac}</p>
            <p class="content_text">중성화 여부 : ${data[0].adNeut}</p>
            <p class="content_text">안락사 예정일 :${data[0].adDead}</p>
            <p class="content_text">특이사항 :${data[0].adMemo}</p>
        </div>
        <input type="button" class="adoption_button" value="입양 신청하러 가기 >" onclick="location.href='/abandog/form'">`
            $("#container0").append(srt);
            console.log(data);
            slide();
        }
    });
});



// 슬라이드
function slide() {
    var wid = 0;
    var now_num = 0;
    var slide_length = 0;
    var auto = null;
    var $dotli = $('.dot>li');
    var $panel = $('.panel');
    var $panelLi = $panel.children('li');

    // 변수 초기화
    function init() {
        wid = $('.slide').width();
        now_num = $('.dot>li.on').index();
        slide_length = $dotli.length;
    }

    // 이벤트 묶음
    function slideEvent() {

        // 슬라이드 하단 dot버튼 클릭했을때
        $dotli.click(function() {
            now_num = $(this).index();
            slideMove();
        });

        // 이후 버튼 클릭했을때
        $('.next').click(function() {
            nextChkPlay();
        });

        // 이전 버튼 클릭했을때
        $('.prev').click(function() {
            prevChkPlay();
        });

        // 오토플레이
        autoPlay();

        // 오토플레이 멈춤
        autoPlayStop();

        // 오토플레이 재시작
        autoPlayRestart();

        // 화면크기 재설정 되었을때
        resize();
    }

    // 자동실행 함수
    function autoPlay() {
        auto = setInterval(function() {
            nextChkPlay();
        }, 4000);
    }

    // 자동실행 멈춤
    function autoPlayStop() {
        $panelLi.mouseenter(function() {
            clearInterval(auto);
        });
    }


    // 자동실행 멈췄다가 재실행
    function autoPlayRestart() {
        $panelLi.mouseleave(function() {
            auto = setInterval(function() {
                nextChkPlay();
            }, 3000);
        });
    }

    // 이전 버튼 클릭시 조건 검사후 슬라이드 무브
    function prevChkPlay() {
        if (now_num == 0) {
            now_num = slide_length - 1;
        } else {
            now_num--;
        }
        slideMove();
    }

    // 이후 버튼 클릭시 조건 검사후 슬라이드 무브
    function nextChkPlay() {
        if (now_num == slide_length - 1) {
            now_num = 0;
        } else {
            now_num++;
        }
        slideMove();
    }

    // 슬라이드 무브
    function slideMove() {
        $panel.stop().animate({
            'margin-left': -wid * now_num
        });
        $dotli.removeClass('on');
        $dotli.eq(now_num).addClass('on');
    }

    // 화면크기 조정시 화면 재설정
    function resize() {
        $(window).resize(function() {
            init();
            $panel.css({
                'margin-left': -wid * now_num
            });
        });
    }
    init();
    slideEvent();
}