
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(statusValue, status) {
            $('#idEdit').val(statusValue.id);
            $('#descriptionEdit').val(statusValue.description);
            $('#detailsEdit').val(statusValue.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(statusValue, status) {
            $('#idDetails').val(statusValue.id);
            $('#descriptionDetails').val(statusValue.description);
            $('#detailsDetails').val(statusValue.details);
            $('#lastModifiedByDetails').val(statusValue.lastModifiedBy);
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});