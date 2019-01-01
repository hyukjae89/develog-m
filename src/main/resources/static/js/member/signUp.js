(function() {
    'use strict';

    var validationFlag = {
        'id' : {
            'isNotEmpty' : false,
            'doesNotExist' : false,
            'isOnlyAlphabatAndNumber' : false
        },
        'password' : {
            'isNotEmpty' : false,
            'isMatch' : false,
            'isMoreThan8' : false
        },
        'name' : {
            'isNotEmpty' : false
        },
        'email' : {
            'isNotEmpty' : false,
            'isEmailFormat' : false
        },
        'passwordQuestion' : {
            'isNotEmpty' : false
        },
        'passwordAnswer' : {
            'isNotEmpty' : false
        }
    };

    var idValue;

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

        if (idValue !== $this.val()) {
            validationFlag.id.doesNotExist = false;
            idValue = $this.val();
            $('#idCheckBtn').addClass('ready-sub-btn').removeClass('failure-sub-btn success-sub-btn');
        }

        $this.siblings('.validation-msg').empty().hide();
    });

    $('#idCheckBtn').on('click', function() {
        var $this = $(this);

        if (!validationFlag.id.isNotEmpty || !validationFlag.id.isOnlyAlphabatAndNumber) {
            return;
        }

        $.ajax({
            url : "/member/check-id",
            type : "GET",
            data : 'id=' + $('#id').val()
        }).done(function(response) {

            if (response.code === responseCode.EXIST_ID) {
                $this.next().text("이미 존재하는 아이디 입니다.").show();
                $this.addClass('failure-sub-btn').removeClass('ready-sub-btn success-sub-btn');
                validationFlag.id.doesNotExist = false;
            } else if (response.code === responseCode.NOT_EXIST_ID) {
                $this.next().empty().hide();
                $this.addClass('success-sub-btn').removeClass('ready-sub-btn failure-sub-btn');
                validationFlag.id.doesNotExist = true;
            }

        }).fail(function(request, status, error) {
            validationFlag.id.doesNotExist = false;
        });


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

    $('#email').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.email.isNotEmpty = validator.checkRequiredValue($this))) {
            $this.next().text("필수값 입니다.").show();
            return;
        }

        if (!(validationFlag.email.isEmailFormat = validator.checkEmailValue($this))) {
            $this.next().text("이메일 형식이 아닙니다.").show();
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

    $('#signUpForm').on('submit', function() {
        if (!validationFlag.id.doesNotExist) {
            $('#id').siblings('.validation-msg').text("중복 확인이 필요합니다.").show();
            return false;
        }
    });

})();