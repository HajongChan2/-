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


    $(".abandoned_dog-text p").on('click',function(e){
        let na = $(e.target);
        let a = na.text();
        console.log(a);
    });

    function abandogList(list){
        str = '';
        list.map(function(abandog){


            str +=
                `<div class="abandoned_dog-wrap">
                    <div class="abandoned_dog-image"><img src="${abandog.ad_gallery}" alt=""></div>
                    <div class="abandoned_dog-text">
                        <p>{abandog.ad_name}</p>
                    </div>
                </div>`
        });
    }
});