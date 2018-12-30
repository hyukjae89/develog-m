var validator = (function() {
    'use strict';

    /*
    * TODO: 필수값 확인
    */
    var _checkRequiredValue = function($dom) {

        var value = $dom.val();

        // 공백 검사
        var regex = /^[\0]*$/;
        if (!regex.test(value)) {
            value = value.replace(/\s+/g, '');
            $dom.val(value);
        }

        // 입력란 길이 검사
        if (value.length === 0) {
            return false;
        }

        return true;
    };

    /*
    * TODO: 영문 확인
    */
    var _checkOnlyEnglishValue = function($dom) {

    };

    /*
    * TODO: 최소 입력 제한 확인
    */
    var _checkMinimumInputValue = function($dom, min) {

        if ($dom.val().length < min) {
            return false;
        }

        return true;
    };

    /*
    * TODO: 두 입력값 일치 여부 확인
    */
    var _checkSameValue = function($dom1, $dom2) {

        if ($dom1.val() !== $dom2.val()) {
            return false;
        }

        return true;
    };

    return {
        checkRequiredValue : _checkRequiredValue,
        checkOnlyEnglishValue : _checkOnlyEnglishValue,
        checkMinimumInputValue : _checkMinimumInputValue,
        checkSameValue : _checkSameValue
    }
})();