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

});