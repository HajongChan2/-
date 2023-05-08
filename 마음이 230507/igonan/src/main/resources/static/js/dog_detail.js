$(document).ready(function(){
    //let dogname = '빵이';
    if(localStorage.getItem('name')){
       dogname = localStorage.getItem('name');
    }
    srt = '';
    $.ajax({
        type : "GET",
        url : "/dog/detail/"+dogname,
        dataType : "json",
        success : function(data){

            srt = srt + `<h1 id="main_nb">반려견 상세 조회</h1>
        <div id="container1">
            <h2 class="content_text">제목</h2>
            <h2 class="content_text">등록번호 : ${data[0].petNum}</h2>
        </div>

        <div class="dogbox_wrap">
            <div id="dogbox_wrap1">
                <div class="dogbox_img"><img src="${data[0].petGallery}"></div>
                <div class="dogbox_img"><img src="${data[0].petGallery}"></div>
            </div>
            <div id="dogbox_wrap2">
                <p class="content_text">이름 : ${data[0].petName}</p>
                <p class="content_text">나이 :${data[0].petAge} </p>
                <p class="content_text">성별 : ${data[0].petSex} </p>
                    <p class="content_text">품종 : ${data[0].petSpec}</p>
                    <p class="content_text">접종 여부: ${data[0].petVac}</p>
                    <p class="content_text">중성화 여부 : ${data[0].petNeut}</p>
                    <p class="content_text">특이 사항 : ${data[0].petMemo}</p>
                    <p class="content_text">입양 날짜 : ${data[0].petDate}</p>
            </div>
        </div>
        <div id="dogbox_img2"></div>
        <h1 id="main_nb2">입양 후 근황</h1>
        <div id="container2">
            <div class="dogbox_img3"></div>
            <div class="dogbox_img3"></div>
            <div class="dogbox_img3"></div>
            <div class="dogbox_img3"></div>
        </div>`
            $("#container").append(srt);

            console.log(data);
        }
    });
});