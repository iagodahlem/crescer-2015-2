$(function () {
    $('#loginLabel').click(function () {
        if ($('.login-menu-content').hasClass('hidden')) {
            $('.login-menu-content').removeClass('hidden');
        }
        else {
            $('.login-menu-content').addClass('hidden');
        }
    });
});
