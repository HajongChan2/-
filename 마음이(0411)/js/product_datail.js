$(document).ready(function(){
    let plus = $(".plus");
    let minus = $(".minus");
    let input = $(".inp");
    plus.click(function(){
        let pl_in = parseInt(input.val());
        input.val(pl_in + 1);
        minus.removeAttr('disabled'); 
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
});