(function() {
    'use strict';

    $('#categoryManagement').on('click', function() {
        $('#contentsWrap').load('/admin/categories');
    });
})();