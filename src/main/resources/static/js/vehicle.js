
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href')

        $.get(href, function(vehicle, status) {
            $('#txtIdEdit').val(vehicle.id);
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
            $('#txtNameEdit').val(vehicle.name);
            $('#txtVehicleNumberEdit').val(vehicle.vehiclenumber);
            var regDate = vehicle.txtRegistrationDate;
            $('#txtRegistrationDateEdit').val(regDate);
            $('#txtDescriptionEdit').val(vehicle.description);
            var acqDate = vehicle.txtAcquisitionDate;
            $('#txtAcquisitionDateEdit').val(acqDate);
            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlLocationEdit').val(vehicle.locationid);
            $('#txtPowerEdit').val(vehicle.power);
            $('#txtFuelCapacityEdit').val(vehicle.fuelcapacity);
            $('#txtNetWeightEdit').val(vehicle.netweight);
            $('#txtRemarksEdit').val(vehicle.remarks);
            $('#ddlEmployeeEdit').val(vehicle.vehicleid);
            $('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(vehicle, status) {
            $('#txtIdDetails').val(vehicle.id);
            $('#ddlVehicleTypeDetails').val(vehicle.vehicletypeid);
            $('#txtNameDetails').val(vehicle.name);
            $('#txtVehicleNumberDetails').val(vehicle.vehiclenumber);
            $('#txtRegistrationDateDetails').val();
            $('#txtDescriptionDetails').val(vehicle.description);
            var acqDate = vehicle.txtAcquisitionDate;
            $('#txtAcquisitionDateDetails').val(acqDate);
            $('#ddlVehicleMakeDetails').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelDetails').val(vehicle.vehiclemodelid);
            $('#ddlLocationDetails').val(vehicle.locationid);
            $('#txtPowerDetails').val(vehicle.power);
            $('#txtFuelCapacityDetails').val(vehicle.fuelcapacity);
            $('#txtNetWeightDetails').val(vehicle.netweight);
            $('#txtRemarksDetails').val(vehicle.remarks);
            $('#ddlEmployeeDetails').val(vehicle.vehicleid);
            $('#ddlVehicleStatusDetails').val(vehicle.vehiclestatusid);
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