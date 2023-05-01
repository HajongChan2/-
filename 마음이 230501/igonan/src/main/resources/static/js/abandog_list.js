$(document).ready(function(){


    $.ajax({
        type : "POST",
        url : "/abandog/list",
        dataType : "json",
        success : function(data){
            console.log(data);
        }
    });


    $(".abandoned_dog-text p").on('click',function(e){
        let na = $(e.target);
        let a = na.text();
        console.log(a);
    });

});