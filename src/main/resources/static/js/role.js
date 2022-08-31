
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(role, status) {
            $('#idEdit').val(role.id);
            $('#descriptionEdit').val(role.description);
            $('#detailsEdit').val(role.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(role, status) {
            $('#idDetails').val(role.id);
            $('#descriptionDetails').val(role.description);
            $('#detailsDetails').val(role.details);
            $('#lastModifiedByDetails').val(role.lastModifiedBy);
            $('#lastModifiedDateDetails').val(role.lastModifiedDate);
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