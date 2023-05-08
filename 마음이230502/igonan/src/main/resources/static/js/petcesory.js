$(document).ready(function(){
    $.ajax({
        type : "POST",
        url : "/petcesary/tag",
        dataType : "json",
        success : function(data){
            console.log(data);
            productTag(data);
        }
    });
    function productTag(product){
        product.map(function(tag){
            let str = '';
            let addr = "/product/detail";

            str += `
            <div class="petcesory-wrap">
            <a href="${addr}">
                        <div class="petcesory-image">
                            <img src="${tag.prGallery}" alt="${tag.prName}">
                            <p>${tag.prName}</p>
                        </div>
                    </a>                    
                </div>`

            $("#container2").append(str);
        });
    }
});