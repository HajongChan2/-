const pwRegExp = /^[a-zA-Z0-9]{4,12}$/; //비밀번호
            const idRegExp = /^[a-zA-Z0-9]{4,12}$/; //아이디
const regExp = /^(?:(010-\d{4})|(01[1|6|7|8|9]-\d{3,4}))-(\d{4})$/;
let boolean = false;
            function checkAll(){
                if(!checkName()){
                    return false;
                } else if(!checkId()){ 
                    return false;
                }
                else if(!Pass()){
                    return false;
                }else if(!checkPass()){
                    return false;
                }else if(!checkPhoneNumber()){
                    return false;
                }else if(!address()){
                    return false;
                }else if(!boolean){
                    alert("아이디 중복체크를 하세요.");
                    return false;
                }
                alert('회원가입 성공');
                return true;
            }

            //ID를 체크하는 함수
            function checkId(){
                box = document.getElementById('id');
                if(!idRegExp.test(box.value)){
                    alert('아이디를 정확하게 적어주세요.');
                    box.value = "";
                    box.focus();
                    return false;
                }
                return true;
            }
            //비밀번호를 체크하는 함수
            function Pass(){
                box = document.getElementById('pw');
                if(!idRegExp.test(box.value)){
                    alert('비밀번호를 잘 적어주세요.');
                    box.value = "";
                    box.focus();
                    return false;
                }else if(box.value == document.getElementById('id').value){
                    alert('비밀번호는 아이디와 같을 수 없습니다.')
                    box.value = "";
                    box.focus();
                    return false;
                }
                return true;
            }
            //비밀번호를 한번더 적어서 맞게 썼는지 확인하는 함수
            function checkPass(){
                box = document.getElementById('pwcheck');
                if(box.value!=document.getElementById('pw').value){
                    alert('비밀번호가 서로 다릅니다.');
                    box.value = "";
                    box.focus();
                    return false;
                }
                return true;
            }
            //이름이 한글자일 수는 없으니 1글자 이상으로만 설정
            function checkName(){
                box = document.getElementById('user_name');
                if(box.value.length <=1){
                    alert('이름이 정확하지 않습니다.');
                    box.value ="";
                    box.focus();
                    return false;
                }
                return true;
            }
            // function checkPhoneNumber() {
            //     if( regExp.test($("#txtPhone").val()) == true ) {
            //         return true;
            //     }
            //     else {
            //         alert("휴대폰 번호를 정확하게 입력해주세요.");
            //         return false;
            //     }
            // }

            function address(){
                let addr = $("#member_addr").val();
                let addr_detail = $("#address_detail").val();
                if(addr == "" || addr_detail == ""){
                    alert("주소를 입력해주세요.");
                    return false;
                }
                return true;
            }

            function IdCheck(){
                let id = $("#id_check").val();
                $.ajax({
                   url : "/idcheck",
                   datatype: "json",
                   data : {id : id},
                   type : "POST",
                   success : function (data){
                       if(!data){
                           alert("사용 불가능한 아이디입니다.");
                           return false;
                       }
                       boolean = true;
                       alert("사용 가능한 아이디입니다.");
                       return ;
                   }
                });
            }

            $("#id_check").click(function(){
                console.log("a");
                IdCheck();
            });

$(document).ready(function(){
    $("#submit").click(function(){
            let name = $("#user_name").val();
            let id = $("#id").val();
            let pw = $("#pw").val();
            let phone = $("#txtPhone").val();
            let addr = $("#member_addr").val();
            let addr_detail = $("#address_detail").val();

            const join_insert = {
                name : name,
                id : id,
                pw : pw,
                phone : phone,
                addr : addr,
                saddr : addr_detail
            };
            if(checkAll()){
                $.ajax({
                    type: "POST",
                    url : "join/insert",
                    data: join_insert,
                    datatype: "json",
                    success : function(data){
                        location.replace("/main");
                    }
                });
            }

    });
});