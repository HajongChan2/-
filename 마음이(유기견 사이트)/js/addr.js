// $(document).ready(function(){
    
//     $("#btn").click(function(){
//         let add_detail = $("#address_datail").val();
//         let mem_add = $("#member_addr").val();
//         let member_address = {
//             address : mem_add,
//             address_detail : add_detail
//         }

//         $.ajax({
//             tyep : "POST",
//             url : "/address",
//             data : member_address,
//             success : function(){
//                 console.log("성공");
//             }

//         });
        
//     });
// });
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