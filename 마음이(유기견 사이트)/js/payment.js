$(document).ready(function(){
    $("#direct_input").hide();

    $("#selbox").change(function(){
        if($("#selbox").val() == "4"){
            $("#direct_input").show();
            $("#direct_input").focus();
            $("#selbox").hide();
        }
        $("#direct_input").focusout(function(){
            if($("#direct_input").val() == ''){
                $("#direct_input").hide();
                $("#selbox").show();
            } 
        });
    });
    $("#btn").click(function(){
        if ( ! $('input[name="payment_method"]:checked').val() ) {
            alert('옵션을 선택해주세요.');
            $('input[name="payment_method"]').focus();
            return false;
        }else{
            alert("결제성공");
        }
    });
});