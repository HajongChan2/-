let count = 0;
let imgs = ["list"];
//let dogNum = localStorage.getItem('num');

function readURL(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src',e.target.result);
        $(img).addClass("imgs");
        $('#photo_sign_up').prepend(img);
        imgs.push(e.target.result);
    }
    count++;
    console.log(imgs);
}

$(document).ready(function(){

    if(dogNum != '' || dogNum != null){
        let img = '';

        console.log(dogNum);
        let srt = '';
        $.ajax({
            type : "POST",
            url : "/abandog/detail/"+dogNum,
            dataType : "json",
            success : function(data){
                abandogImage();
            }
        });
        function abandogImage(){

            $.ajax({
                url : "/abandogimagelist/"+dogNum,
                type : "POST",
                dataType : "json",
                success : function(data){
                    console.log(data);
                    let name = $("#register").val();
                    let age = $("#age").val();
                    let area = $("#area").val();
                    let kind = $("#kind").val();
                    let dead = $("#date").val();
                    let sex = $("input[name='sex']:checked").val();
                    let neut = $("input[name='neutered']:checked").val();
                    let vac = $("input[name='inoculation']:checked").val();
                    let memo = $("#text_box").val();
                    let size = $("#size option:selected").val();
                    abandogimage(data);
                }
            });
        };


        function abandogimage(list){

            list.map(function(abandog){

            });

        }
    }

    let d = new Date();

    let month = d.getMonth()+1;
    let day = d.getDate();

    let output = d.getFullYear() + '-' +
        (month<10 ? '0' : '') + month + '-' +
        (day<10 ? '0' : '') + day;
    $("#date").val(output);
    $("#date").attr('min', output);

    $("#imageFile").on("change",function(){
        if($(".imgs").index <= 2){
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
                imgs.splice(i,1);
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
        let name = $("#register").val();
        let age = $("#age").val();
        let area = $("#area").val();
        let kind = $("#kind").val();
        let dead = $("#date").val();
        let sex = $("input[name='sex']:checked").val();
        let neut = $("input[name='neutered']:checked").val();
        let vac = $("input[name='inoculation']:checked").val();
        let memo = $("#text_box").val();
        let size = $("#size option:selected").val();
        const ad_insert = {
            name : name,
            age : age,
            area : area,
            dead : dead,
            spec : kind,
            sex : sex,
            neut : neut,
            vac : vac,
            memo : memo,
            size: size,
            imgs: imgs
        }
        if(dogNum != '' || dogNum != null){
            $.ajax({
                type : "POST",
                data : ad_insert,
                url : "/abandog/update/"+dogNum,
                success : function (data){

                }
            });
        }else{
            $.ajax({
                type : "POST",
                url : "/abandog/insert",
                data : ad_insert,
                success : function (data){
                    location.replace("/abandog/list");
                }
            });
        }
    });

});

