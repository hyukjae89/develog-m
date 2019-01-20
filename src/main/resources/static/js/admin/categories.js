(function() {
    'use strict';

    var csrfToken = null,
        csrfHeader = null;

    $('.categorySaveBtn').on('click', function() {

        var $row = $(this).parent();

        if (csrfToken == null) {
            csrfToken = $('#csrf').data('token');
        }
        if (csrfHeader == null) {
            csrfHeader = $('#csrf').data('header');
        }

        $.ajax({
            url: '/admin/categories',
            method: "post",
            contentType: "application/json",
            data: JSON.stringify({
                id: $row.find('.categoryId').val(),
                name: $row.find('.categoryName').val(),
                ordering: $row.find('.categoryOrdering').val(),
                isVisible: $row.find('.categoryIsVisible').val()
            }),
            beforeSend : function(xhr) {
                xhr.setRequestHeader(csrfHeader, csrfToken);
            }
        }).done(function(response) {
            if (response.code == responseCode.SUCCESS) {
                location.href = "/admin/categories";
            }
        }).fail(function() {

        });
    });

    $('.categoryDelBtn').on('click', function() {
        var $row = $(this).parent();

        if (csrfToken == null) {
            csrfToken = $('#csrf').data('token');
        }
        if (csrfHeader == null) {
            csrfHeader = $('#csrf').data('header');
        }

        if (!confirm("정말 삭제하시겠습니까?")) {
            return;
        }

        $.ajax({
            url: '/admin/categories',
            method: "delete",
            contentType: "application/json",
            data: $row.find('.categoryId').val(),
            beforeSend : function(xhr) {
                xhr.setRequestHeader(csrfHeader, csrfToken);
            }
        }).done(function(response) {
            if (response.code == responseCode.SUCCESS) {
                location.href = "/admin/categories";
            }
        }).fail(function() {

        });
    });
})();