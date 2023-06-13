let name;
let id;
let origin_pw;
let new_pw;
let phone;
let addr;
let saddr;
let pw;
$(document).ready(function(){
    $("#txtPhone").on('propertychange change paste input',function(){
        let phone = $('#txtPhone');
        let orgin;
        let zin;
        let a;
        let newPhone = phone.val().replace(/^(\d{3})(\d{4})(\d{4})$/, `$1-$2-$3`);
        if(phone.val().length < 13){
            zin = phone.val();

            orgin = zin.replace("-", "");

            let a = orgin.replace(/^(\d{3})(\d{4})(\d{4})$/, `$1-$2-$3`);

            phone.val(a);
        }else{
            phone.val(newPhone);
        }
    });
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
        const member_update = {
            name : name.val(),
            id : id.val(),
            phone : phone.val(),
            addr : addr.val(),
            saddr : saddr.val(),
            pw : pw
        }
        $.ajax({
            type : "POST",
            url : "/mypage/update",
            data : member_update,
            success : function(data){
                location.href = '/mypage';
            }
        });
    });
});
