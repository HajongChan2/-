$(document).ready(function(){
    $(".login_bt").click(function(){
        let id = $("#id").val();
        let pw = $("#pw").val();
        let addr = document.referrer;
        const login = {
            id : id,
            pw : pw,
            addr : addr
        };
        $.ajax({
            type : "POST",
            url : "/logincheck",
            data : login,
            success : function(data){
                console.log("성공");
            }
        });
    });



});