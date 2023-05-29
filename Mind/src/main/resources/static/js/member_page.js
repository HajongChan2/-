$(document).ready(function(){
    let str = '';
    $.ajax({
       url : "/mypage/return",
       dataType : "json",
       type : "POST",
       success : function(data){
           str += `
            <li>${data[0].name}</li>
            <li>${data[0].id}</li>
            <li>${data[0].phone}</li>
            <li>${data[0].addr}</li>
            <li>${data[0].saddr}</li>
           `
           console.log(data);
           $(".member_info2").append(str);
       }
    });
});