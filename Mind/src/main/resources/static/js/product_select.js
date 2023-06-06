$(document).ready(function(){
    $.ajax({
        type : "POST",
        datatype: "json",
        url : "/product/select",
        success : function(data){
            console.log(data)
        }
    });

    $(document).on('click','.delivery_box',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        console.log(list);
    });

});