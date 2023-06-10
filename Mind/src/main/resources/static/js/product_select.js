$(document).ready(function(){
    $.ajax({
        type : "POST",
        datatype: "json",
        url : "/product/select",
        success : function(data){
            console.log(data)
        }
    });

    $(document).on('click','.delivery_box',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        console.log(list);
    });

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

});