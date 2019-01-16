(function() {
    'use strict';

    $('.categoryDelBtn').on('click', function() {
        $(this).parent().remove();
    });
})();