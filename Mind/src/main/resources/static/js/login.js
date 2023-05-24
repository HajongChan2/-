$(document).ready(function(){
    $(".login_bt").click(function(){
        let id = $("#id").val();
        let pw = $("#pw").val();
        let a = document.referrer;
        let b = a.split('8080/', 2);
        let addr = `/${b[1]}`;
        const login = {
            id : id,
            pw : pw
        };
        $.ajax({
            type : "POST",
            url : "/logincheck",
            data : login,
            success : function(data){
                if(data){
                    location.href = addr;
                }else{
                    alert("아이디 혹은 비밀번호가 틀렸습니다.");
                }
            }

        });
    });

});