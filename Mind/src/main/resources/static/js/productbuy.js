$(document).ready(function(){
    let str = '';
    $.ajax({
        url : "/productbuyresult",
        type : "POST",
        dataType : "json",
        success : function (data){
            console.log(data);
            str += `
                 <li>${data.uName}</li>
                 <li>${data.uAddr + " " + data.uSaddr} </li>
                 <li>${data.uCashsel}</li>
                 <li>${data.uTotalpay}</li>
            `
            $("#data_info").append(str);
        }
    })
});