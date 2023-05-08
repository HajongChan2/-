function checkNumber(event) {
    if(event.key >= 0 && event.key <= 9) {
      return true;
    }
    
    return false;
}



$(document).ready(function(){
        let dogname = '';
            srt = '';
        if(localStorage.getItem('name')){
            dogname = localStorage.getItem('name');
        }
        $.ajax({
                type : "GET",
                url : "/abandog/detail/"+dogname,
                dataType : "json",
                success : function(data){

                console.log(data);


srt = srt + `    <div id="delivery_infomation">
             <div>
                 <ul id="content_header" class="delivery_content">
                     <li>상품 정보</li>
                     <li>수량</li>
                     <li>배송 구분</li>
                     <li>합계</li>
                 </ul>
             </div>
             <div>
                 <ul class="delivery_content">
                     <li class="first_content">
                         <img src="img/product.jpg">
                         <div class="description">
                             <p><a href="#">설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명설명</a></p>
                         </div>
                     </li>
                     <li><label for="count" class="count"></label></li><input type="hidden" name="count" id="count" value="1">
                     <li>기본배송</li>
                     <li>0</li>
                 </ul>
             </div>
         </div>
`








                }
                });

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
            url : "/abandog/form/insert",
            data : application,
            success : function(data){
                alert("성공");
            }
        }); 
    });
});