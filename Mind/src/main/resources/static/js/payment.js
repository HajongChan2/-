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

    let addr_detail = $("#address_detail");
    let addr = $("#member_addr");
    let phone = $("input[name=phone]");
    let name = $("#user_name");
    let now_addr;
    $.ajax({
        url : "/mypage/return",
        dataType : "json",
        type : "POST",
        success : function(data){
            name.val(data[0].name);
            addr.val(data[0].addr);
            addr_detail.val(data[0].saddr);
            phone.val(data[0].phone);
            now_addr = addr.val();
        }
    });

    $("#new_addr").click(function(){
        addr.val("");
        $("#find").removeAttr('disabled');
    });
    $("#now_addr").click(function(){
        addr.val(now_addr);
        $("#find").attr("disabled", true);
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
                <li>${data[0].prPrice}</li>
                <li>기본배송</li>
                <li>${data[0].prDpay}</li>
                <li>${totalPay}</li>
            `
            $("#content").append(str);

            str = `                <h4>총 결제 예정 금액</h4>
                <p>${totalPay}</p>`
            $("#total_payment").append(str);
            console.log(data);
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
            url : "/",
            data : member_address,
            success : function(data){
                alert("성공");
            }
        });
    });

});