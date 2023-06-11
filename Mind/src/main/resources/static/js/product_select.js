let status = 'all';
$(document).ready(function(){
    let str = '';
    let status_content = '';

    $.ajax({
        type : "POST",
        datatype: "json",
        url : "/userallbuylist",
        success : function(data){
            product_all_select(data);
            $(".contents").append(str);
            date();
        }
    });

    $.ajax({
        url : "userdeliverycount",
        dataType : "json",
        type : "POST",
        success : function(data){
            status_content += `
                <div class="delivery_box">
                    <h2>전체</h2>
                    <h2>${data[0].count}</h2>
                </div>
                <div class="delivery_box">
                    <h2>입금/결제</h2>
                    <h2>${data[1].count}</h2>
                </div>
                <div class="delivery_box">
                    <h2>배송중</h2>
                    <h2>${data[2].count}</h2>
                </div>
                <div class="delivery_box">
                    <h2>배송완료</h2>
                    <h2>${data[3].count}</h2>
                </div>
            `

            $("#delivery_status").append(status_content);
        }
    });

    $(document).on('click','.delivery_box',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        switch (list){
            case "전체":
                status = "all";
                break;
            case "입금/결제":
                status = "pay";
                break;
            case "배송중":
                status = "ship";
                break;
            case "배송완료":
                status = "complete";
                break;

        }
        $.ajax({
            url : "/userdeliveryreturn/"+status,
            type : "POST",
            dataType : "json",
            success : function(data){
                str = '';
                product_all_select(data);
                $(".contents").empty();
                $(".contents").append(str);
            }
        });
    });




    $("#select").click(function(){
        let start_date = $("#date_start").val();
        let end_date = $("#date_end").val();
        const date_date = {
            start_date :start_date,
            end_date : end_date,
            status : status
        }
        $.ajax({
            url : "/userbuylistdate",
            data : date_date,
            type : "POST",
            success : function(data){
                $(".contents").empty();
                str = '';
                product_all_select(data);
                $(".contents").append(str);
            }


        });
    });

    function product_all_select(list){
        list.map(function(all){
        str += `
            <ul class="delivery_content">
                <li class="first_content">
                    <img src="${all.uPrimg}">
                    <div class="description">
                        <p><a href="/product/detail/+${all.uPrname}">${all.uPrmemo}</a></p>
                    </div>
                </li>
                <li>${all.uCount}</li>
                <li>${all.uDel}</li>
                <li>${all.uTotalpay}</li>
                <div class="user_choice">
                    <button class="${all.uNum}" id="confir">결제확정</button>
                    <button class="${all.uNum}" id="cancel">주문취소</button>
                </div>
            </ul>
        `
        });
    }

    $(document).on('click','.user_choice > button',function(){
        let target = this;
        let unum = $(this).attr('class');
        console.log(unum);
        let list = target.innerText;
        if(list == '결제확정'){
            confir(unum);
        }else if(list == '주문취소'){

        }

    });

    function confir(num){
        $.ajax({
            url : "/delivery/update",
            data : {num : num},
            type : "POST",
            success : function(data){
                location.reload();
            }
        });
    }
});

function date(){
    // 조회 끝나는 날짜 구하기
    let d = new Date();

    let month = d.getMonth()+1;
    let day = d.getDate();


    let output = d.getFullYear() + '-' +
        (month<10 ? '0' : '') + month + '-' +
        (day<10 ? '0' : '') + day;
    $("#date_end").val(output);
    $("#date_end").attr('max', output);

    // 조회 시작하는 날짜 구하기 초깃값 6개월
    d = new Date();
    let sel_month = -6;
    d.setMonth(d.getMonth() + sel_month);
    let year = d.getFullYear();
    month = ('0' + (d.getMonth() + 1)).slice(-2);
    day = ('0' + d.getDate()).slice(-2);
    let dt = year + "-" + month + "-" + day;

    $("#date_start").val(dt);
    $("#date_start").attr('max', output);
    console.log(dt);
}