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
    let str = '';
    function productTag(product){
        product.map(function(tag){

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
    $(".pet_items1").on("click", function(){
        $.ajax({
            type: "POST",
            url: "/petcesary/tag",
            dataType: "json",
            success: function (data) {
                console.log(data);
                productTag(data);
            }
        });
    });
});