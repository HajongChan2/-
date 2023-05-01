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
                <div class="abandogbox img"><img src="/img/dog0.jpg" alt=""></div>
            </div>
            <div class="abandogbox_wrap2">
                <p class="content_text">등록 번호 : ${data[0].aNum}</p>
                <p class="content_text">이름 : ${data[0].aName}</p>
                <p class="content_text">나이 : ${data[0].aAge}</p>
                <p class="content_text">성별 : ${data[0].aSex}</p>
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
            <p class="content_text">분양 지역 : ${data[0].aArea}</p>
            <p class="content_text">품종 : ${data[0].aSpec}</p>
            <p class="content_text">접종 : ${data[0].aVac}</p>
            <p class="content_text">중성화 여부 : ${data[0].aNeut}</p>
            <p class="content_text">안락사 예정일 :${data[0].aDead}</p>
            <p class="content_text">특이사항 :${data[0].aMemo}</p>
        </div>
        <input type="button" class="adoption_button" value="입양 신청하러 가기 >">`
            $("#container0").append(srt);
            console.log(data[0].aAge);
            console.log(data);
        }
    });
});
