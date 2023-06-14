let str = '';

$(document).ready(function(){
    let type = 'tag';
    types_query();
    let addr = "product/detail";
    function types_query(){
        $.ajax({
            type: "POST",
            url: "/petcesary/"+type,
            dataType: "json",
            success: function (data) {
                console.log(data);
                productTag(data);
            }
        });
        function productTag(product){
            str = '';
            $('#container2').empty();
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
    }



    $(document).on('click','.pet_items',function(){
        type = $(this).attr("id");
        types_query();
        console.log(type);
    });
    $("#tag").on("click", function(){
        $(".line").animate({left:0},"fast");

    });

    $("#chip").on("click", function(){
        $(".line").animate({left:'480px'},"fast");

    });
    $("#etc").on("click", function(){
        $(".line").animate({left:'960px'},"fast");

    });

    $(document).on('click','.petcesory-image',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        num = list;
        localStorage.setItem('num',num);
    });
    $("#add_list").click(function(){
        window.localStorage.clear();
    });
});