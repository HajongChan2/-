let count = 0;
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
    }
    count++;
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
    $(document).on("click",".imgs",function() {
		this.remove();
        count -= 1;
        $("#image_plus").css('display', 'inline-block');
	});

    $('#text_box').keyup(function () {
        let content = $(this).val();
        
        // 글자수 세기
        if (content.length == 0 || content == '') {
            $('.textCount').text('0자');
        } else {
            $('.textCount').text(content.length + '자');
        }
        
        // 글자수 제한
        if (content.length > 500) {
            // 200자 부터는 타이핑 되지 않도록
            $(this).val($(this).val().substring(0, 500));
            // 200자 넘으면 알림창 뜨도록
            alert('글자수는 500자까지 입력 가능합니다.');
        };
    });

});

