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

        return value.length > 0;
    };

    /*
    * TODO: 오직 영문자와 숫자 입력 여부 확인
    */
    var _checkOnlyAlphabatAndNumberValue = function($dom) {
        return new RegExp(/^[a-z0-9+]*$/).test($dom.val());
    };

    /*
    * TODO: 최소 입력 제한 확인
    */
    var _checkMinimumInputValue = function($dom, min) {
        return $dom.val().length >= min;
    };

    /*
    * TODO: 두 입력값 일치 여부 확인
    */
    var _checkSameValue = function($dom1, $dom2) {
        return $dom1.val() === $dom2.val();
    };

    /*
    * TODO: 이메일 형식 확인
    */
    var _checkEmailValue = function($dom) {
        return new RegExp(/^([\.0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[a-zA-Z_-]+){1,2}$/).test($dom.val());

    };

    return {
        checkRequiredValue : _checkRequiredValue,
        checkOnlyAlphabatAndNumberValue : _checkOnlyAlphabatAndNumberValue,
        checkMinimumInputValue : _checkMinimumInputValue,
        checkSameValue : _checkSameValue,
        checkEmailValue : _checkEmailValue
    }
})();