function change(id,path) {
    $('#menuItem'+id).nextAll().removeClass("active");
    $('#menuItem'+id).prevAll().removeClass("active");
    $('#menuItem'+id).addClass("active");
    $('#mIframe').attr("src",path);
}

$(function () {
})