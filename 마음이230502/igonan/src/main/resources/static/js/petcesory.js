$(document).ready(function(){


    $.ajax({
        type : "POST",
        url : "/product/tag",
        dataType : "json",
        success : function(data){
            console.log(data);
            productTag(data);
        }
    });

    function ProductTag () {
    }
}