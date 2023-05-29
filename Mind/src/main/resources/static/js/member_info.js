$(document).ready(function(){
    let name = $("#user_name");
    let id = $("#id");
    let origin_pw = $("#origin_pw");
    let new_pw = $("#new_pw");
    let phone = $("#txtPhone");
    let addr = $("#member_addr");
    let saddr = $("#address_detail");
    let pw = '';
    $.ajax({
        url : "/mypage/return",
        dataType : "json",
        type : "POST",
        success : function (data){
            name.val(data[0].name);
            id.val(data[0].id);
            phone.val(data[0].phone);
            addr.val(data[0].addr);
            saddr.val(data[0].saddr);
            pw = data[0].pw;
            console.log(data, pw);
        }
    })

    $("#submit").click(function(){
        if(new_pw != ''){
            pw = origin_pw.val();
        }
        const datas = {
            name : name.val(),
            id : id.val(),
            phone : phone.val(),
            addr : addr.val(),
            saddr : saddr.val(),
            pw : pw
        }
        $.ajax({
            url : "/mypage/update",
            data : datas,
            dataType : "json",
            type : "POST",
            success : function(data){

            }
        })
    });
});