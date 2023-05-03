$(document).ready(function(){


    $.ajax({
        type : "POST",
        url : "/abandog/list",
        dataType : "json",
        success : function(data){
            console.log(data);
            abandogList(data);
        }
    });


    function abandogList(list){
        let name = '';
        let addr = "/abandog/detail";
        let str = '';
        list.map(function(abandog){
            str +=
                `<div class="abandoned_dog-wrap">
                    <a href="${addr}">
                        <div class="abandoned_dog-image">
                            <img src="${abandog.adGallery}" alt="${abandog.adName}">
                            <p>${abandog.adName}</p>
                        </div>
                    </a>                    
                </div>`

        });
        $("#container2").append(str);
    }

    $(document).on("click",".abandoned_dog-image",function(e){
        let na = $(e.target);
        let name = na.attr("alt");
        if(name == null){
            name = na.text();
        }
        console.log(name);
        localStorage.setItem('name',name);
    });



});