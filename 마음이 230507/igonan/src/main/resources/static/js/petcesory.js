let str = '';
$(document).ready(function(){
    $(".pet_items").click(function(e){
        e.preventDefault();
    });

    $("#tag").on("click", function(){
        $("#container2").empty();
        $.ajax({
            type: "POST",
            url: "/petcesary/tag",
            dataType: "json",
            success: function (data) {
                console.log(data);
                productTag(data);
            }
        });
        function productTag(product){
            str = '';
            product.map(function(tag){

                let addr = "/product/detail";

                str += `
            <div class="petcesory-wrap">
            <a href="${addr}" + "/" + "${tag.prName}">
                        <div class="petcesory-image">
                            <img src="${tag.prGallery}" alt="${tag.prName}">
                            <p>${tag.prName}</p>
                        </div>
                    </a>                    
                </div>`


            });
            $("#container2").append(str);
        }
    });

    $("#chip").on("click", function(){
        $("#container2").empty();
        $.ajax({
            type: "POST",
            url: "/petcesary/chip",
            dataType: "json",
            success: function (data) {
                console.log(data);
                productChip(data);
            }
        });
        function productChip(product){
            str = '';
            product.map(function(chip){

                let addr = "/product/detail";

                str += `
                 <div class="petcesory-wrap">
                    <a href="${addr}" +"/" + "${chip.prName}">
                        <div class="petcesory-image">
                            <img src="${chip.prGallery}" alt="${chip.prName}">
                            <p>${chip.prName}</p>
                        </div>
                    </a>                    
                </div>`


            });
            $("#container2").append(str);
        }
    });
});