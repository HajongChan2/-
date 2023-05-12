let str = '';
$(document).ready(function(){

    let a = true;
    if(a){
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
            <a href="${addr}/${tag.prName}">
                        <div class="petcesory-image">
                            <img src="${tag.prGallery}" alt="${tag.prName}">
                            <p>${tag.prName}</p>
                        </div>
                    </a>                    
                </div>`


            });
            $("#container2").append(str);
        }

        a = false;
    }
    $("#tag").on("click", function(){
        $(".line").animate({left:0},"fast");
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
            <a href="${addr}/${tag.prName}">
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
        $(".line").animate({left:'480px'},"fast");
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
                    <a href="${addr}/${chip.prName}">
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
    $("#etc").on("click", function(){
        $(".line").animate({left:'960px'},"fast");
        $("#container2").empty();
        $.ajax({
            type: "POST",
            url: "/petcesary/etc",
            dataType: "json",
            success: function (data) {
                console.log(data);
                productEtc(data);
            }
        });
        function productEtc(product){
            str = '';
            product.map(function(etc){

                let addr = "/product/detail";

                str += `
                 <div class="petcesory-wrap">
                    <a href="${addr}/${etc.prName}">
                        <div class="petcesory-image">
                            <img src="${etc.prGallery}" alt="${etc.prName}">
                            <p>${etc.prName}</p>
                        </div>
                    </a>                    
                </div>`


            });
            $("#container2").append(str);
        }
    });
});