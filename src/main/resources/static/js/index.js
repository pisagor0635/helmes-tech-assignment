$(document).ready(function () {
    $("#trId").hide()
    $("#frmSector").submit(function (event) {
        event.preventDefault();
        submitForm();
    });

    $.ajax({
        url: "/getSectorList",
        type: 'GET',
        dataType: 'json', // added data type
        success: function (data) {
            data.forEach(function (sector) {
                    if (sector.parentId === 0) {
                        $('#ddSector').append($('<option>', {
                            value: sector.id,
                            text: sector.sectorName
                        }));
                    } else {
                        if (!sector.hasChild && sector.parentId === 1) {
                            $('#ddSector').append($('<option>', {
                                value: sector.id,
                                text: sector.sectorName
                            }));
                        }
                        if (!sector.hasChild) {
                            $('#ddSector optgroup[value="' + sector.parentId + '"]').append($('<option>', {
                                value: sector.id,
                                text: sector.sectorName
                            }));
                        } else {
                            $('#ddSector').append($('<optgroup>', {
                                value: sector.id,
                                label: sector.sectorName
                            }));
                        }
                    }
                }
            );
        },
        error: function (request, error) {
            alert(" Can't do because: " + error);
        },
    });

});

function submitForm() {
    if ($("#txtName").val().length == 0 || !$("#chkAggree").is(":checked")) {
        alert("All fields are mandatory!")
        return false;
    }
    var id = $("#lblId").text() == "" ? 0 : $("#lblId").text();

    $.ajax({
        method: "POST",
        url: "/saveUser",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify({
            id: id,
            fullName: $("#txtName").val(),
            sector: $("#ddSector").val(),
            termAgreed: $("#chkAggree").is(":checked")
        }),
        success: function (data) {
            if (id == 0) {
                alert("Record saved successfully")
                $("#btnSubmit").text("Update")
            } else {
                alert("Record updated successfully")
            }
            $("#lblId").text(data.id)
            $("#trId").show()
        }
    });
}