function data(){
    new daum.Postcode({
        oncomplete: function(data) {
            let add = data.address;
            let mem_add = $("#member_addr");
            console.log(data);
            if(add !== ''){
                mem_add.val(add);
            }
        }
    }).open();
}