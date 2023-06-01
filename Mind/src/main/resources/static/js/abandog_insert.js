let count = 0;
let imgs = [];

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
        imgs.push(e.target.result);
    }
    count++;
    console.log(imgs);
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
        for(let i = 0; i < imgs.length; i++){
            if(imgs[i] == b){
                imgs.splice(i, 1);
            }
        }
        console.log(imgs);



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

    $("#submit").click(function(){
        let title  = $("#title").val();
        let name = $("#register").val();
        let area = $("#area").val();
        let kind = $("#kind").val();
        let neutered = $("input[name='neutered']:checked").val();
        let inoculation = $("input[name='inoculation']:checked").val();
        let memo = $("#text_box").val();
        const ad_insert = {
            title : title,
            name : name,
            area : area,
            kind : kind,
            neutered : neutered,
            inoculation : inoculation,
            memo : memo
        }
        $.ajax({
            type : "POST",
            url : "/payment/insert",
            data : ad_insert ,
            success : function (data){
                location.replace("/abandog/list");
            }
        });
    });

});

