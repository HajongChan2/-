let count = 0;
let imgs = ["product_list"];
let num = localStorage.getItem("num");
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

function productcontent(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $(img).attr("class","content_img");
        $('.content').append(img);
        iamge_resizing();
    }
}

function iamge_resizing(){
    let con_div = $(".content_img").closest("div");
    $(".content_img").resizable({
        //함께 커질영역
        //alsoResize:".ui-wrapper",
        //커질때 애니메이션 발생
        animate :  true,
        animateDuration: 300,
        animateEasing:"swing",
        //비율유지
        aspectRatio: true,
        //마우스 hover 아닐때 핸들러 숨기기
        autoHide: true,
        //minHeight, maxHeight, minWidth, maxWidth 최소,최대 크기지정
    });
}

$(document).ready(function(){
    iamge_resizing();
    $("#imageFile").on("change",function(){
        if(imgs.length <= 4){
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

    // update

    function update_image(){
        $.ajax({
            url : "/productimagelist/"+num,
            type : "POST",
            success : function(data){
                data.map(function(images){
                    let img = $('<img />');
                    $(img).attr('src',images.imgSrc);
                    $(img).addClass("imgs");
                    $('#photo_sign_up').prepend(img);
                    imgs.push(images.imgSrc);
                });
            }
        });
    }

    function update_query(){

        $.ajax({
            url : "/product/detail/"+num,
            dataType : "json",
            type : "POST",
            success : function(data){
                let type = data[0].prType;
                $("#title").val(data[0].prName);
                $("#price").val(data[0].prPrice);
                $("#dpay").val(data[0].prDpay);
                $("#register").val(data[0].prSeller);
                $("#count").val(data[0].prCount);
                $("#memo").val(data[0].prMemo);
                $("#type option:selected").val();
                $("#type").val(data[0].prType).prop("selected", true);
                $("#id option:eq(type - 1)").prop("selected", true);
                $(".content").append(data[0].prContent);
            }
        });

    }
    if(num != null){
        update_query();
        update_image();
        iamge_resizing();
        console.log("aa");
    }

    function update_success(){
        let name = $("#title").val();
        let price = $("#price").val();
        let dpay = $("#dpay").val();
        let seller = $("#register").val();
        let count = $("#count").val();
        let memo = $("#memo").val();
        let type = $("#type option:selected").val();
        let content = $(".content").html();
        const ad_update = {
            imgs : imgs,
            name : name,
            price : price,
            dpay : dpay,
            seller : seller,
            count : count,
            memo : memo,
            type : type,
            content : content,
            num : num
        }
        $.ajax({
            url : "/product/update",
            type : "POST",
            data : ad_update,
            success : function(){
                alert("수정이 완료되었습니다.");
                location.replace("/product/detail");
            }
        });
    }

    $(".register_button").click(function(){
        let name = $("#title").val();
        let price = $("#price").val();
        let dpay = $("#dpay").val();
        let seller = $("#register").val();
        let count = $("#count").val();
        let memo = $("#memo").val();
        let type = $("#type option:selected").val();
        let content = $(".content").html();

        const product_data = {
            imgs : imgs,
            name : name,
            price : price,
            dpay : dpay,
            seller : seller,
            count : count,
            memo : memo,
            type : type,
            content : content
        }
        if(num != null){
            update_success();
        }else{
            $.ajax({
                type : "POST",
                url : "/product/insert",
                data : product_data,
                success : function (data){
                    location.replace("/petcesary");
                }
            });
        }
    });

});

