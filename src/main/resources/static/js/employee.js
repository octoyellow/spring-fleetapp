
$('document').ready(function(){

    $('.table #editButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href')

        $.get(href, function(employee, status) {
            $('#txtUsernameEdit').val(employee.username);
            $('#txtIdEdit').val(employee.id);
            $('#ddlTitleEdit').val(employee.title);
            $('#txtInitialsEdit').val(employee.initials);
            $('#txtSSNEdit').val(employee.socialSecurityNumber);
            $('#txtFirstnameEdit').val(employee.firstname);
            $('#txtLastnameEdit').val(employee.lastname);
            $('#txtOthernameEdit').val(employee.othername);
            $('#ddlGenderEdit').val(employee.gender);
            $('#ddlNationalityEdit').val(employee.countryid);
            $('#txtAddressEdit').val(employee.address);

            var dob = employee.dateOfBirth.substr(0, 10);
            var hireDate = employee.hireDare.substr(0, 10);
            $('#txtDateOfBirthEdit').val(dob);
            $('#txtHireDateEdit').val(hireDate);
            $('#ddlStateEdit').val(employee.stateid);
            $('#txtCityEdit').val(employee.city);
            $('#txtPhoneEdit').val(employee.phone);
            $('#txtMobileEdit').val(employee.mobile);
            $('#ddlMaritalStatusEdit').val(employee.maritalStatus);
            $('#txtEmailEdit').val(employee.email);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
        });

        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(employee, status) {
            $('#txtIdDetails').val(employee.id);
            $('#ddlTitleDetails').val(employee.title);
            $('#txtInitialsDetails').val(employee.initials);
            $('#txtSSNDetails').val(employee.socialSecurityNumber);
            $('#txtFirstnameDetails').val(employee.firstname);
            $('#txtLastnameDetails').val(employee.lastname);
            $('#txtOthernameDetails').val(employee.othername);
            $('#ddlGenderDetails').val(employee.gender);
            $('#ddlNationalityDetails').val(employee.countryid);
            $('#txtAddressDetails').val(employee.address);

            $('#txtDateOfBirthDetails').val(employee.dateOfBirth.substr(0, 10));
            $('#txtHireDateDetails').val(employee.hireDate.substr(0, 10));
            $('#ddlStateDetails').val(employee.stateid);
            $('#txtCityDetails').val(employee.city);
            $('#txtPhoneDetails').val(employee.phone);
            $('#txtMobileDetails').val(employee.mobile);
            $('#ddlMaritalStatusDetails').val(employee.maritalStatus);
            $('#txtEmailDetails').val(employee.email);
            $('#ddlJobTitleDetails').val(employee.jobtitleid);
            $('#ddlEmployeeTypeDetails').val(employee.employeetypeid);
        });
        $('#detailsModal').modal();
    });

    $('.table #deleteButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

    $('.table #photoButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#photoModal #employeePhoto').attr('src', href);
        $('#photoModal').modal();
    });
});