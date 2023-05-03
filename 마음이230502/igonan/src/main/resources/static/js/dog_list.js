$(document).ready(function(){
    $.ajax({
        type : "GET",
        url : "/dog/list",
        dataType : "json",
        success : function(data){
            console.log(data);
        }
    });

});