$(document).ready(function(){
    let plus = $(".plus");
    let minus = $(".minus");
    let input = $(".inp");
    plus.click(function(){
        let pl_in = parseInt(input.val());
        if(pl_in < 99){
            input.val(pl_in + 1);
            minus.removeAttr('disabled'); 
        }else{
            alert("더이상 추가할 수 없습니다.");
        }
        
    });
    minus.click(function(){
        let pl_in = parseInt(input.val());
        if(pl_in > 1){
            input.val(pl_in - 1);
        }else{
            alert("더이상 내릴 수 없습니다.");
            minus.attr('disabled', true);
        }
    });
    $("#purchase").on('click', function(){
        localStorage.setItem('count',input.val());
    });

    $(".inp").on("propertychange change keyup paste input", function(){
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

