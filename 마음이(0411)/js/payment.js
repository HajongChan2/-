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
});

$(document).ready(function(){
    let direct_message;
    let choice;
    let CountData;
    let count;
    if(localStorage.getItem('count')){
        CountData = localStorage.getItem('count');
        $("#count").val(CountData);
        $("#counts").text(CountData);
    }
    
    $("#btn").click(function(){
        let add_detail = $("#address_detail").val();
        let mem_add = $("#member_addr").val();
        let phone = $("input[name=phone]").val();
        let name = $("#user_name").val();
        let payment_method = $('input[name=payment_method]:checked').val();
        count = parseInt($("#counts").text());
        console.log(count);
        direct_message = $("#direct_input");
        choice = $("#selbox option:selected");
        if(choice.val() == 4){
            choice.val(direct_message.val());
        }else{
            direct_message.val(choice.val());
        }
        let memo = choice.val();
        alert(mem_add);
        let member_address = {
            name : name,
            address : mem_add,
            address_detail : add_detail,
            phone : phone,
            memo : memo,
            payment_method : payment_method,
            p_count : count
        }
        $.ajax({
            type : "POST",
            url : "/address",
            data : member_address,
            success : function(data){
                alert("성공");
            }
        }); 
    });
    
});
