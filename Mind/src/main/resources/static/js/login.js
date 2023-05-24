$(document).ready(function(){
    $(".login_bt").click(function(){
        let id = $("#id").val();
        let pw = $("#pw").val();
        let a = document.referrer;
        let b = a.split('8080/', 2);
        let addr = `/${b}`;

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
    let a = document.referrer;
    let b = a.split('8080/', 2);
    let addr = `/${b[1]}`;
    console.log(addr);

});