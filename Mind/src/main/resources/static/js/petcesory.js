let str = '';
$(document).ready(function(){
    let addr = "product/detail";
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

                str += `
            <div class="petcesory-wrap">
            <a href="${addr}">
                        <div class="petcesory-image">
                            <img src="${tag.prGallery}" alt="${tag.prName}">
                            <p>${tag.prName}</p>
                            <h2 id="number">${tag.prNum}</h2>
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

                str += `
            <div class="petcesory-wrap">
            <a href="${addr}">
                        <div class="petcesory-image">
                            <img src="${tag.prGallery}" alt="${tag.prName}">
                            <p>${tag.prName}</p>
                            <h2 id="number">${tag.prNum}</h2>
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


                str += `
                 <div class="petcesory-wrap">
                    <a href="${addr}">
                        <div class="petcesory-image">
                            <img src="${chip.prGallery}" alt="${chip.prName}">
                            <p>${chip.prName}</p>
                            <h2 id="number">${chip.prNum}</h2>
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


                str += `
                 <div class="petcesory-wrap">
                    <a href="${addr}">
                        <div class="petcesory-image">
                            <img src="${etc.prGallery}" alt="${etc.prName}">
                            <p>${etc.prName}</p>
                            <h2 id="number">${etc.prNum}</h2>
                        </div>
                    </a>                    
                </div>`


            });
            $("#container2").append(str);
        }
    });

    $(document).on('click','.petcesory-image',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        num = list;
        localStorage.setItem('num',num);
    });
});