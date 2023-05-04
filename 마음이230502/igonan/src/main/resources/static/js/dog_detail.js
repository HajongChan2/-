$(document).ready(function(){
  //  let dogname = '빼롱이';
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
            <h2 class="content_text">등록번호 : ${data[0].pdNum}</h2>
        </div>

        <div class="dogbox_wrap">
            <div id="dogbox_wrap1">
                <div class="dogbox_img"><img src="${data[0].pdGallery}"></div>
                <div class="dogbox_img"><img src="${data[0].pdGallery}"></div>
            </div>
            <div id="dogbox_wrap2">
                <p class="content_text">이름 : ${data[0].pdName}</p>
                <p class="content_text">나이 :${data[0].pdAge} </p>
                <p class="content_text">성별 : ${data[0].pdSex} </p>
                    <p class="content_text">품종 : ${data[0].pdSpec}</p>
                    <p class="content_text">접종 여부: ${data[0].pdVac}</p>
                    <p class="content_text">중성화 여부 : ${data[0].pdNeut}</p>
                    <p class="content_text">특이 사항 : ${data[0].pdMemo}</p>
                    <p class="content_text">입양 날짜 : ${data[0].pdDate}</p>
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
            console.log(data[0].adAge);
            console.log(data);
        }
    });
});