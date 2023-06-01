$(document).ready(function(){
    let str = '';
    $.ajax({
       url : "/mypage/return",
       dataType : "json",
       type : "POST",
       success : function(data){
           str = '';

           str += `
            <li>${data[0].name}</li>
            <li>${data[0].id}</li>
            <li>${data[0].phone}</li>
            <li>${data[0].addr}</li>
            <li>${data[0].saddr}</li>
           `
           $(".member_info2").append(str);
       }
    });

    $.ajax({
        type : "POST",
        url : "mypagebuytotal",
        dataType : "json",
        success : function (data){
            str = '';

            str += `
            <div class="border_box">
                <h2>총 구매 횟수</h2>
                <h2>${data[0].uCount}</h2>
            </div>
            <div class="border_box">
                <h2>총 구매 금액</h2>
                <h2>${data[0].uTotalpay}</h2>
            </div> `
            $("#purchase_dt").append(str);
        }

    });
    $.ajax({
        type : "POST",
        url : "mypagebuytotalmonth",
        dataType : "json",
        success : function (data){
            str = '';

            str += `

            <div class="border_box">
                <h2>이번 달 구매 횟수</h2>
                <h2>${data[0].uCount}</h2>
            </div>
            <div class="border_box">
                <h2>이번 달 구매 금액</h2>
                <h2>${data[0].uTotalpay}</h2>
            </div>
            `
            $("#purchase_dt").append(str);
        }

    });
});