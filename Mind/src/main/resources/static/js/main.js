$(document).ready(function(){
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
                        </div>
                    </a>                    
                </div>`
        });
        $("#container3").append(str);
    }
    $(document).on("click",".dog-image",function(e){
        let na = $(e.target);
        let name = na.attr("alt");
        if(name == null){
            name = na.text();
        }
        console.log(name);
        localStorage.setItem('name',name);
    });

});