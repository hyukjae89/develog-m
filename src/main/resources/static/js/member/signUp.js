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
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        if (!(validationFlag.id.isOnlyAlphabatAndNumber = validator.checkOnlyAlphabatAndNumberValue($this))) {
            showMessage($this.attr('id'), '아이디는 소문자 또는 소문자와 숫자 조합만 가능합니다.');
            return;
        }

        if (idValue !== $this.val()) {
            validationFlag.id.doesNotExist = false;
            idValue = $this.val();
            $('#idCheckBtn').addClass('ready-sub-btn').removeClass('failure-sub-btn success-sub-btn');
        }

        hideMessage($this.attr('id'));
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
                showMessage($this.attr('id'), '이미 존재하는 아이디 입니다.');
                $this.addClass('failure-sub-btn').removeClass('ready-sub-btn success-sub-btn');
                validationFlag.id.doesNotExist = false;
            } else if (response.code === responseCode.NOT_EXIST_ID) {
                hideMessage($this.attr('id'));
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
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        if (!(validationFlag.password.isMoreThan8 = validator.checkMinimumInputValue($this, 8))) {
            showMessage($this.attr('id'), '비밀번호는 8자 이상입니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#passwordConfirm').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.password.isMatch = validator.checkSameValue($this, $('#password')))) {
            showMessage($this.attr('id'), '입력한 비밀번호와 일치하지 않습니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#name').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.name.isNotEmpty = validator.checkRequiredValue($this))) {
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#email').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.email.isNotEmpty = validator.checkRequiredValue($this))) {
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        if (!(validationFlag.email.isEmailFormat = validator.checkEmailValue($this))) {
            showMessage($this.attr('id'), '이메일 형식이 아닙니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#passwordQuestion').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.passwordQuestion.isNotEmpty = validator.checkRequiredValue($this))) {
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#passwordAnswer').on('blur', function() {
        var $this = $(this);

        if (!(validationFlag.passwordAnswer.isNotEmpty = validator.checkRequiredValue($this))) {
            showMessage($this.attr('id'), '필수값 입니다.');
            return;
        }

        hideMessage($this.attr('id'));
    });

    $('#signUpForm').on('submit', function() {

        if (!validationFlag.id.isNotEmpty) {
            showMessage('id', '필수값 입니다.');
            return false;
        }

        if (!validationFlag.id.isOnlyAlphabatAndNumber) {
            showMessage('id', '아이디는 소문자 또는 소문자와 숫자 조합만 가능합니다.');
            return false;
        }

        if (!validationFlag.id.doesNotExist) {
            showMessage('id', '중복 확인이 필요합니다.');
            return false;
        }

        if (!validationFlag.password.isNotEmpty) {
            showMessage('password', '필수값 입니다.');
            return false;
        }

        if (!validationFlag.password.isMoreThan8) {
            showMessage('password', '비밀번호는 8자 이상입니다.');
            return false;
        }

        if (!validationFlag.password.isMatch) {
            showMessage('passwordConfirm', '입력한 비밀번호와 일치하지 않습니다.');
            return false;
        }

        if (!validationFlag.name.isNotEmpty) {
            showMessage('name', '필수값 입니다.');
            return false;
        }

        if (!validationFlag.email.isNotEmpty) {
            showMessage('email', '필수값 입니다.');
            return false;
        }

        if (!validationFlag.email.isEmailFormat) {
            showMessage('email', '이메일 형식이 아닙니다.');
            return false;
        }

        if (!validationFlag.passwordQuestion.isNotEmpty) {
            showMessage('passwordQuestion', '필수값 입니다.');
            return false;
        }

        if (!validationFlag.passwordAnswer.isNotEmpty) {
            showMessage('passwordAnswer', '필수값 입니다.');
            return false;
        }

        return true;
    });

    var showMessage = function(domId, message) {
        $('#' + domId).siblings('.validation-msg').text(message).show();
    };

    var hideMessage = function(domId) {
        $('#' + domId).siblings('.validation-msg').empty().hide();
    };

})();