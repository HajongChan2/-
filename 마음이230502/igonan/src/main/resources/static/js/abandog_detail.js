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
                <div class="abandogbox img"><img src="${data[0].adGallery}" alt=""></div>
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
        }
    });
});