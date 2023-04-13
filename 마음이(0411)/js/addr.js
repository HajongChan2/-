
function data(){
    new daum.Postcode({
        oncomplete: function(data) {
            let add = data.address;
            let mem_add = $("#member_addr");
            if(add !== ''){
                mem_add.val(add);
            }
        }
    }).open();
}

$("#find").click(function(){
    data();
});