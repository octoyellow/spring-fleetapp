
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(supplier, status) {
            $('#txtIdEdit').val(supplier.id);
            $('#txtNameEdit').val(supplier.name);
            $('#txtDetailsEdit').val(supplier.details);
            $('#txtWebsiteEdit').val(supplier.website);
            $('#txtAddressEdit').val(supplier.address);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#txtCityEdit').val(supplier.city);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#txtMobileEdit').val(supplier.mobile);
            $('#txtEmailEdit').val(supplier.email);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(supplier, status) {
            $('#txtIdDetails').val(supplier.id);
            $('#txtNameDetails').val(supplier.name);
            $('#txtDetailsDetails').val(supplier.details);
            $('#txtWebsiteDetails').val(supplier.website);
            $('#txtAddressDetails').val(supplier.address);
            $('#ddlStateDetails').val(supplier.stateid);
            $('#ddlCountryDetails').val(supplier.countryid);
            $('#txtCityDetails').val(supplier.city);
            $('#txtPhoneDetails').val(supplier.phone);
            $('#txtMobileDetails').val(supplier.mobile);
            $('#txtEmailDetails').val(supplier.email);
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