(function() {
    'use strict';

    var validationFlag = {
        'id' : {
            'doesNotExist' : false,
            'isOnlyEnglish' : false,
            'isNotEmpty' : false
        },
        'password' : {
            'isMatch' : false,
            'isMoreThan8' : false,
            'isNotEmpty' : false
        },
        'name' : {
            'isNotEmpty' : false
        },
        'passwordQuestion' : {
            'isNotEmpty' : false
        },
        'passwordAnswer' : {
            'isNotEmpty' : false
        }
    };

    $('#idCheckBtn').on('click', function() {

    });

    $('#password').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.password.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.next().text("필수값 입니다.").show();
            return;
        }

        if (!(validationFlag.password.isMoreThan8 = validator.checkMinimumInputValue($this, 8))) {
            $this.next().text("비밀번호는 8자 이상입니다.").show();
            return;
        }

        $this.next().empty().hide();
    });

    $('#passwordConfirm').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.password.isMatch = validator.checkSameValue($this, $('#password')))) {
            $this.next().text("입력한 비밀번호와 일치하지 않습니다.").show();
            return;
        }

        $this.next().empty().hide();
    });

})();