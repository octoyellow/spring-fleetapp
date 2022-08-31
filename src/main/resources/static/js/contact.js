
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href')

        $.get(href, function(contact, status) {
            $('#txtIdEdit').val(contact.id);
            $('#txtFirstnameEdit').val(contact.firstname);
            $('#txtLastnameEdit').val(contact.lastname);
            $('#txtEmailEdit').val(contact.email);
            $('#txtMobileEdit').val(contact.mobile);
            $('#txtPhoneEdit').val(contact.phone);
            $('#txtRemarksEdit').val(contact.remarks);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(contact, status) {
            $('#txtIdDetails').val(contact.id);
            $('#txtFirstnameDetails').val(contact.firstname);
            $('#txtLastnameDetails').val(contact.lastname);
            $('#txtEmailDetails').val(contact.email);
            $('#txtMobileDetails').val(contact.mobile);
            $('#txtPhoneDetails').val(contact.phone);
            $('#txtRemarksDetails').val(contact.remarks);
            $('#remarksDetails').val(invoice.remarks);
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