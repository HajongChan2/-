$(document).ready(function(){
    $("#login_bt").click(function(){
        let id = $("#id").val();
        let pw = $("#pw").val();
        const login = {
            id : id,
            pw : pw
        };
        $.ajax({
            type : "POST",
            url : "/logincheck",
            data : login,
            success : function(data){
                sessionStorage.setItem("id", id);
                console.log("성공");
            }
        });
    });

});