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
        str = '';
        list.map(function(abandog){


            str +=
                `<div class="abandoned_dog-wrap">
                    <div class="abandoned_dog-image"><img src="${abandog.adGallery}" alt=""></div>
                    <div class="abandoned_dog-text">
                        <p>${abandog.adName}</p>
                    </div>
                </div>`

        });
        $("#container2").append(str);
    }
    $(document).on("click", ".abandoned_dog-text p", function(e){
        let na = $(e.target);
        let a = na.text();
        console.log(a);
    });

});