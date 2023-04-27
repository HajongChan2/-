function checkNumber(event) {
    if(event.key >= 0 && event.key <= 9) {
      return true;
    }
    
    return false;
}
$(document).ready(function(){
    

    $("#submit").on('click', function(){
        let name = $("#title").val();
        let phone = $("#register").val();
        let addr = $("#member_addr").val();
        let saddr = $("#kind").val();
        let memo = $("#text_box").val();

        const application = {
            name : name,
            phone : phone,
            addr : addr,
            saddr : saddr,
            memo : memo
        }
        $.ajax({
            type : "POST",
            url : "/address",
            data : application,
            success : function(data){
                alert("성공");
            }
        }); 
    });
});