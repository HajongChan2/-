function checkNumber(event) {
    if(event.key >= 0 && event.key <= 9) {
      return true;
    }
    
    return false;
}



$(document).ready(function(){
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