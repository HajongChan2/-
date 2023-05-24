$(document).ready(function(){
    $(".login_bt").click(function(){
        let id = $("#id").val();
        let pw = $("#pw").val();
        let a = document.referrer;
        let addr = a.split('8080/', 2);
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
                
            }
        });

    });

    let addr = document.referrer;
    let a = addr.split('8080/', 2);
    console.log("/"+a[1]);
});