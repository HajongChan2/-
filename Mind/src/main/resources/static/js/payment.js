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
    let CountData = localStorage.getItem('count');;
    productName = localStorage.getItem('name');
    let str = '';
    let totlePay = 1;
    $.ajax({
        type : "POST",
        url : "payment/show/" + productName,
        dataType : "json",
        success : function(data){
            totalPay = (CountData * data[0].prPrice) + data[0].prDpay;
            str += `
                <li class="first_content">
                    <img src="${data[0].prGallery}">
                    <div class="description">
                        <p><a href="/product/detail" target='_blank'>${data[0].prMemo}</a></p>
                    </div>
                </li>
                <li><label for="count" class="count">${CountData}</label></li><input type="hidden" name="count" id="count" value="${CountData}">
                <li>기본배송</li>
                <li>${totlePay}</li>
            `
            $("#content").append(str);
        }

    });
    let direct_message;
    let choice;
    let count = $("#count").val();
    $(".count").text(count);
    $("#btn").click(function(){
        let add_detail = $("#address_detail").val();
        let mem_add = $("#member_addr").val();
        let phone = $("input[name=phone]").val();
        let name = $("#user_name").val();
        let payment_method = $('input[name=payment_method]:checked').val();
        count = $("#count").val();
        direct_message = $("#direct_input");
        choice = $("#selbox option:selected");
        if(choice.val() == 4){
            choice.val(direct_message.val());
        }else{
            direct_message.val(choice.val());
        }
        let memo = choice.val();

        let member_address = {
            prName : productName,
            name : name,
            address : mem_add,
            address_detail : add_detail,
            phone : phone,
            memo : memo,
            payment_method : payment_method,
            count : count,
            totalPay : totalPay

        }
        $.ajax({
            type : "POST",
            url : "/payment/insert",
            data : member_address,
            success : function(data){
                alert("성공");
            }
        });
    });

});