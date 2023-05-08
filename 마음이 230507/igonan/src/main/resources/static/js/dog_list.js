$(document).ready(function(){
    $.ajax({
        type : "POST",
        url : "/dog/list",
        dataType : "json",
        success : function(data){
           dogList(data);

            console.log(data);
        }
    });

    function dogList(list){
        let name = '';
        let addr = "/dog/detail";
        let str = '';
        list.map(function(petdog){
            str +=
                `<div class="pet_dog-wrap">
                    <a href="${addr}">
                    <div class="pet_dog-image"><img src="${petdog.petGallery}" alt="${petdog.petName}"></div>
                    <div class="pet_dog-text">
                        <p>${petdog.petName}</p>
                    </div>
                </div>
`

        });
        $("#container2").append(str);
    }

    $(document).on("click",".pet_dog-image",function(e){
        let na = $(e.target);
        let name = na.attr("alt");
        if(name == null){
            name = na.text();
        }
        console.log(name);
        localStorage.setItem('name',name);
    });



});