let count = 0;
let a = [];

function readURL(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $(img).addClass("imgs");
        $('#photo_sign_up').prepend(img);
        a.push(e.target.result);
    }
    count++;
    console.log(a);
}


$(document).ready(function(){
    $("#imageFile").on("change",function(){
        if(count < 3){
            readURL(this);
        }else{
            alert("3장 이상은 선택할 수 없습니다.");
            $("#image_plus").css('display', 'none');
        }
    });
    $(document).on("click",".imgs",function(e) {
        this.remove();
        count -= 1;
        let b = $(this).attr("src");
        for(let i = 0; i < a.length; i++){
            if(a[i] == b){
                a.splice(i, 1);
            }
        }
        console.log(a);



        $("#image_plus").css('display', 'inline-block');
    });

    $('#text_box').keyup(function () {
        let content = $(this).val();

        // 글자수 세기
        if (content.length == 0 || content == '') {
            $('.textCount').text('0자');
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

});

