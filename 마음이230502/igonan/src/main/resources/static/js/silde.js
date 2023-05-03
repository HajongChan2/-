$(function() {
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        infinite: true,
        autoplay: true,
        speed: 1500,
        slidesPerView: 1,
		paginationClickable: true,
        loop: true
    });
});