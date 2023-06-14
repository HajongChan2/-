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
                `<ul>
                            <li>${mydog.id}</li>
                            <li>${mydog.name}</li>
                            <li>${mydog.dognum}</li>
                            <li>${mydog.dogname}</li>
                            <li>${mydog.phone}</li>
                            <li>${mydog.addr}</li>
                            <li>${mydog.saddr}</li>
                            <li>${mydog.memo}</li>
                            <li>${mydog.date}</li>
                            <li>입양이 완료되었습니다.</li>
                            </ul>
`

        });
        $("#mydog_content").append(str);
    }
})