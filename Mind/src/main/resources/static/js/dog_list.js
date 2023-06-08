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
                    <div class="pet_dog-image">
                        <img src="${petdog.petGallery}" alt="${petdog.petName}">
                        <p>${petdog.petName}</p>
                        </div>
                </div>
`

        });
        $("#container2").append(str);
    }

    $(document).on('click','.pet_dog-wrap',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        num = list;
        localStorage.setItem('num',num);
    });




});