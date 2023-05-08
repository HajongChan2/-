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
    function productTag(product){
        product.map(function(Tag){
            let str = '';

            str += `
                
            `
        });
    }
});