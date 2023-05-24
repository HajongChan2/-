$(document).ready(function(){
    let name = localStorage.getItem("name");
    let str = '';
    let input;
    $.ajax({
        type:"GET",
        url:"/product/detail/"+name,
        dataType : "json",
        success : function(data){
            console.log(data);
            str += `
                <div id="content_top_font">
                <h2>펫세사리 상세</h2>
            </div>
            <div id="product_info">
                <div id="product_image">
                    <img src="${data[0].prGallery}">
                </div>
                <div class="description">
                    <div class="description info">
                        <ul class="description_content">
                            <li>이름</li>
                            <li>가격</li>
                            <li>배송</li>
                            <li>판매자</li>
                            <li>수량</li>
                        </ul>
                        <ul class="description_content">
                            <li>${data[0].prName}</li>
                            <li>${data[0].prPrice}</li>
                            <li>${data[0].prDpay}</li>
                            <li>관리자</li>
                            <div class="count-wrap count">
                                <button type="button" class="minus">-</button>
                                <input type="text" class="inp" value="1" />
                                <button type="button" class="plus">+</button>
                            </div>
                        </ul>
                    </div>
                      
                </div>
            </div>
            `
            $("form").prepend(str);
            input = $(".inp");
        }
    });




    $(document).on("click",".plus",function(){
        let plus = $(".plus");
        let pl_in = parseInt(input.val());
        if(pl_in < 99){
            input.val(pl_in + 1);
            $(".minus").removeAttr('disabled');
        }else{
            alert("더이상 추가할 수 없습니다.");
        }
        
    });
    $(document).on("click",".minus",function(){
        let minus = $(".minus");
        let pl_in = parseInt(input.val());
        if(pl_in > 1){
            input.val(pl_in - 1);
        }else{
            alert("더이상 내릴 수 없습니다.");
            minus.attr('disabled', true);
        }
    });
    $(document).on('click',"#mem_purchase", function(){
        $("form").attr("action", "/payment");
        localStorage.setItem('count',input.val());
    });
    $(document).on('click', '#non_purchase', function(){
        alert("로그인 후 이용 가능합니다.");
        $("form").attr("action", "/login");
    });

    $(document).on(".inp","propertychange change keyup paste input", function(){
        let input = $(".inp");
        let inputval = $(this).val();
        if(inputval >= 1 && inputval <= 100){
            input.val(input.val());
        }else{
            alert("이 수량은 선택할 수 없습니다.");
            input.val("1");
            input.focus();
        }
    });
    
});

