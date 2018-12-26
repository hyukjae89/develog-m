(function() {
    'use strict';

    var validationFlag = {
        'isMatch' : true
    }

    $('#idCheckBtn').on('click', function() {

    });

    $('#passwordConfirm').on('blur', function() {
        var $this = $(this);

        if (validationFlag.isMatch || $this.val() !== $('#password').val()) {
            $this.next().text("입력한 비밀번호와 일치하지 않습니다.");
            $this.next().show();
            validationFlag.isMatch = false;
        } else if (!validationFlag.isMatch || $this.val() === $('#password').val()) {
            $this.next().empty();
            $this.next().hide();
            validationFlag.isMatch = true;
        }
    });

})();