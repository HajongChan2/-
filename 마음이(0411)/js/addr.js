function data(){ // 함수 선언
    new daum.Postcode({
        oncomplete: function(data) {
            let add = data.address; // 카카오가 지원해준 데이터 담기 (data 중에서 address만)
            let mem_add = $("#member_addr"); // id를 변수에 담기
            if(add !== ''){ // null이 아닐 시
                mem_add.val(add); //데이터를 input value에 담기
            }
        }
    }).open();
}

$("#find").click(function(){
    data(); // 함수 호출
});