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
        let addr = "/abandog/detail/";
        let str = '';
        list.map(function(abandog){
            str +=
                `<div class="abandoned_dog-wrap">
                    <a href="${addr + abandog.adName}">
                            <div class="abandoned_dog-image"><img src="${abandog.adGallery}" alt=""></div>
                                <div class="abandoned_dog-text">
                                    <p>${abandog.adName}</p>
                                </div>
                        </div>
                    </a>
                    `

        });
        $("#container2").append(str);
    }
    let name = '';
    $(document).on("click", ".abandoned_dog-text p", function(e){
        let na = $(e.target);
        name = na.text();
        console.log(name);
    });
    localStorage.setItem('name',name);

});