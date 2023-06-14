
function memo_check(){
    let text_box = $('#text_box');
    if(text_box.val() == ''){
        alert("입양 희망 이유를 적어주세요.");
        text_box.focus();
        return false;
    }
    return true;
}

let num = localStorage.getItem("num");
$(document).ready(function(){
    $.ajax({
        url : "/mypage/return",
        dataType : "json",
        type: "POST",
        success : function (data){
            $("#title").val(data[0].name);
            $("#register").val(data[0].phone);
            $("#member_addr").val(data[0].addr);
            $("#kind").val(data[0].saddr);
        }
    });
    $('#text_box').keyup(function () {
        let content = $(this).val();

        // 글자수 세기
        if (content.length == 0 || content == '') {
            $('.textCount').text('0');
        } else {
            $('.textCount').text(content.length);
        }

        // 글자수 제한
        if (content.length > 500) {
            $(this).val($(this).val().substring(0, 500));
            $('.textCount').text(500);
            alert('글자수는 500자까지 입력 가능합니다.');
        };
    });

    $("#submit").click(function (){
        let name = $("#title").val();
        let phone = $("#register").val();
        let addr = $("#member_addr").val();
        let saddr = $("#kind").val();
        let memo = $("#text_box").val();

        const abandogFormData = {
            name : name,
            phone : phone,
            addr : addr,
            saddr : saddr,
            memo : memo,
            num  : num
        }
        if(memo_check()){
            $.ajax({
                type : "POST",
                url : "/abandog/add",
                data : abandogFormData,
                success : function (data){
                    alert("입양 신청이 완료되었습니다.");
                    location.replace("/dog/list");
                }
            });
        }
    });
});