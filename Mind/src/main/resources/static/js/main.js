$(document).ready(function(){
    window.localStorage.clear();
    $.ajax({
        type : "POST",
        url : "/main/abandoglist",
        dataType : "json",
        success : function(data){
            console.log(data);
            mainList(data);
        }
    });

    function mainList(dogList) {
        let name = '';
        let addr = "/abandog/detail";
        let str = '';
        dogList.map(function (dog) {
            str +=
                `<div class="dog-wrap">
                    <a href="${addr}">
                        <div class="dog-image">
                            <img src="${dog.adGallery}" alt="${dog.adName}">
                            <p>${dog.adName}</p>
                            <h2 id="number">${dog.adNum}</h2>
                        </div>
                    </a>                    
                </div>`
        });
        $("#container3").append(str);
    }
    $(document).on('click','.dog-image',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        num = list;
        localStorage.setItem('num',num);
    });
    $(".add_bt").click(function(){
        location.href="/abandog/list"
    });

    $.ajax({
        type : "POST",
        url : "/main/productlist",
        dataType : "json",
        success : function(data){
            console.log(data);
            mainProductList(data);
        }
    });

    function mainProductList(productList) {
        let name = '';
        let addr = "/product/detail";
        let str = '';
        productList.map(function (pr) {
            str +=
                `<div class="dog-wrap">
                    <a href="${addr}">
                        <div class="dog-image">
                            <img src="${pr.prGallery}" alt="${pr.prName}">
                            <p>${pr.prName}</p>
                            <h2 id="number">${pr.prNum}</h2>
                        </div>
                    </a>                    
                </div>`
        });
        $("#product_content").append(str);


        $("#ad_btn").click(function(){
            location.href="/abandog/list";
        });
        $("#pr_btn").click(function(){
            location.href="/petcesary";
        });
    }
});