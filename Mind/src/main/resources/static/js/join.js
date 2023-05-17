const pwRegExp = /^[a-zA-Z0-9]{4,12}$/; //비밀번호
            const idRegExp = /^[a-zA-Z0-9]{4,12}$/; //아이디 

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
                }else if(!checkPhone()){
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
                addr_detail : addr_detail
            };

            $.ajax({
            type: "POST",
            url : "join/insert",
            data: join_insert,
            datatype: "json",
            success : function(data){

            }
        });
    });
});