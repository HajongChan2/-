$(document).ready(function(){

    let num;

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
        let addr = "/abandog/detail";
        let str = '';
        list.map(function(abandog){
            str +=
                `<div class="abandoned_dog-wrap">
                    <a href="${addr}">
                        <div class="abandoned_dog-image">
                            <img src="${abandog.adGallery}" alt="${abandog.adName}">
                            <p>${abandog.adName}</p>
                            <h2 id="number">${abandog.adNum}</h2>
                        </div>
                    </a>                    
                </div>`

        });
        $("#container2").append(str);
    }

    $(document).on('click','.abandoned_dog-wrap',function(){
        let target = this
        let list = target.querySelector('h2').innerText;
        num = list;
    });


    localStorage.setItem('num',num);
});