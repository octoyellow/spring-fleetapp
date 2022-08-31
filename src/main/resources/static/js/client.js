
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href')

        $.get(href, function(client, status) {
            $('#txtIdEdit').val(client.id);
            $('#txtNameEdit').val(client.name);
            $('#txtDetailsEdit').val(client.details);
            $('#txtWebsiteEdit').val(client.website);
            $('#txtAddressEdit').val(client.address);
            $('#ddlStateEdit').val(client.stateid);
            $('#ddlCountryEdit').val(client.countryid);
            $('#txtCityEdit').val(client.city);
            $('#txtEmailEdit').val(client.email);
            $('#txtMobileEdit').val(client.mobile);
            $('#txtPhoneEdit').val(client.phone);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(state, status) {
            $('#idDetails').val(state.id);
            $('#nameDetails').val(state.name);
            $('#websiteDetails').val(state.website);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
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