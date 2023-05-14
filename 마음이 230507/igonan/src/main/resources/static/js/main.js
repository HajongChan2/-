$(document).ready(function(){
    $( document ).ready( function() {
        $( window ).scroll( function() {
            if ( $( this ).scrollTop() > 200 ) {
                $( '.top' ).fadeIn();
            } else {
                $( '.top' ).fadeOut();
            }
        } );
        $( '.top' ).click( function() {
            $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
            return false;
        } );
    } );

    $.ajax({
        type : "POST",
        url : "/main/abandoglist",
        dataType : "json",
        success : function(data){
            console.log(data);
            mainList(data);
        }
    });

    function mainList(dogList) {
        let name = '';
        let addr = "/abandog/detail";
        let str = '';
        dogList.map(function (dog) {
            str +=
                `<div class="dog-wrap">
                    <a href="${addr}">
                        <div class="dog-image">
                            <img src="${dog.adGallery}" alt="${dog.adName}">
                            <p>${dog.adName}</p>
                        </div>
                    </a>                    
                </div>`
        });
        $("#container3").append(str);
    }

});