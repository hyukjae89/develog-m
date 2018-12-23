(function() {

    $('#acceptBtn').on('click', function() {
        var isAccept = true;
        $('.acceptCheck').each(function() {
            if (!$(this).prop('checked')) {
                isAccept = false;
            }
        });

        if (isAccept) {
            console.log("동의");
            location.href = "/member/sign-up";
        } else {
            console.log("미동의");
        }
    });

})();