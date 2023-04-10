function readURL(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $('#photo_sign_up').prepend(img);
    }
    count++;
    console.log(count);
}

$(document).ready(function(){
    $("#imageFile").on("change",function(){
        readURL(this);
    });
});

