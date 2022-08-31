
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(vehicleHire, status) {
            $('#idEdit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);
            $('#ddlLocationEdit').val(vehicleHire.locationid);
            $('#ddlClientEdit').val(vehicleHire.clientid);

            var dateIn = vehicleHire.dateIn.substr(0, 10);
            var dateOut = vehicleHire.dateOut.substr(0, 10);
            $('#dateInEdit').val(vehicleHire.dateIn);
            $('#dateOutEdit').val(vehicleHire.dateOut);
            $('#timeInEdit').val(vehicleHire.timeIn);
            $('#timeOutEdit').val(vehicleHire.timeOut);
            $('#remarksEdit').val(vehicleHire.remarks);
            $('#priceEdit').val(vehicleHire.price);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(vehicleHire, status) {
            $('#idDetails').val(vehicleHire.id);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#ddlLocationDetails').val(vehicleHire.locationid);
            $('#ddlClientDetails').val(vehicleHire.clientid);

            var dateIn = vehicleHire.dateIn.substr(0, 10);
            var dateOut = vehicleHire.dateOut.substr(0, 10);
            $('#dateInDetails').val(vehicleHire.dateIn);
            $('#dateOutDetails').val(vehicleHire.dateOut);
            $('#timeInDetails').val(vehicleHire.timeIn);
            $('#timeOutDetails').val(vehicleHire.timeOut);
            $('#remarksDetails').val(vehicleHire.remarks);
            $('#priceDetails').val(vehicleHire.price);
        });
        $('#detailsModal').modal();
    });

    $('.table #deleteButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});