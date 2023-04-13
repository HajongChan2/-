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
    let phone;
    $("#aa").on('click',function(){
        direct_message = $("#direct_input").val();
        choice = $("#selbox option:selected");
        if(choice.val() == 4){
            choice.val(direct_message);
        }else{
            choice.val();
        }
    });
    
    
    $("#btn").click(function(){
        let add_detail = $("#address_datail").val();
        let mem_add = $("#member_addr").val();
        let phone = $("input[name=phone]").val();
        let name = $("#name").val();
        let member_address = {
            name : name,
            address : mem_add,
            address_detail : add_detail,
            phone : phone,
            choice : choice.val()
        }

        $.ajax({
            tyep : "POST",
            url : "/address",
            data : member_address,
            success : function(){
                console.log("성공");
            }

        });
        
    });
    
});