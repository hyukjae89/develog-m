(function() {
    'use strict';

    var validationFlag = {
        'id' : {
            'doesNotExist' : false,
            'isOnlyAlphabatAndNumber' : false,
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

    $('#id').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.id.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.siblings('.validation-msg').text("필수값 입니다.").show();
            return;
        }

        if (!(validationFlag.id.isOnlyAlphabatAndNumber = validator.checkOnlyAlphabatAndNumberValue($this))) {
            $this.siblings('.validation-msg').text("아이디는 소문자 또는 소문자와 숫자 조합만 가능합니다.").show();
            return;
        }

        if (!validationFlag.id.doesNotExist) {
            $this.siblings('.validation-msg').text("중복 확인이 필요합니다.").show();
            return;
        }

        // 입력한 값의 변화가 생기면 중복 재확인 필요

        $this.siblings('.validation-msg').empty().hide();
    });

    $('#idCheckBtn').on('click', function() {
        var $this = $(this);

        if (!validationFlag.id.isNotEmpty || !validationFlag.id.isOnlyAlphabatAndNumber) {
            return;
        }

        $this.next().text("이미 존재하는 아이디 입니다.").show();

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

    $('#name').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.name.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.next().text("필수값 입니다.").show();
            return;
        }

        $this.next().empty().hide();
    });

    $('#passwordQuestion').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.passwordQuestion.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.next().text("필수값 입니다.").show();
            return;
        }

        $this.next().empty().hide();
    });

    $('#passwordAnswer').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.passwordAnswer.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.next().text("필수값 입니다.").show();
            return;
        }

        $this.next().empty().hide();
    });

})();