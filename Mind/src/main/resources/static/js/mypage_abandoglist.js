$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "/mypage/abanapplist",
        dataType: "json",
        success: function (data) {
            abanapplist(data)
            console.log(data);
        }
    });
    function abanapplist(list) {
        let name = '';
        let str = '';
        list.map(function (mydog) {
            str +=
                `<div class="ma_content">
         <ul id="member_infor">
            <li>${mydog.id}</li>
            <li>${mydog.name}</li>
            <li>${mydog.phone}</li>
            <li>${mydog.addr}</li>
            <li>${mydog.saddr}</li>
            <li>${mydog.memo}</li>
        </ul>
        <ul id="dog_infor">
            <li>${mydog.dogname}</li>
            <li>${mydog.dognum}</li>
        </ul>
        <ul id="date_infor">
            <li>${mydog.date}</li>
            </ul>
            </div>
`
        });
        $("#infor_container").append(str);
    }
})