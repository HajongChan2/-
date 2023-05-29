let name;
let id;
let origin_pw;
let new_pw;
let phone;
let addr;
let saddr;
let pw;
$(document).ready(function(){
    name = $("#user_name");
    id = $("#id");
    origin_pw = $("#origin_pw");
    new_pw = $("#new_pw");
    phone = $("#txtPhone");
    addr = $("#member_addr");
    saddr = $("#address_detail");
    pw = '';
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
    });
    $("#submit").click(function(){
        if(new_pw.val() != ''){
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
                alert("a");
                location.href = "/main";

            }
        });
    });
});
