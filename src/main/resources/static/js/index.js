$(document).ready(function () {
    $("#frmSector").validate()
    $("#trId").hide()
    $("#frmSector").submit(function (event) {
        event.preventDefault();
        submitForm();
    });

    $('#chkAggree').bind('change', function () {
        if ($(this).is(':checked'))
            document.getElementById("lblCheckValidation").style.display = 'none';
    });

    $.ajax({
        url: "/getSectorList",
        type: 'GET',
        dataType: 'json', // added data type
        success: function (data) {
            data.forEach(function (sector) {
                    if (sector.parentId === 0) {
                        $('#ddSector').append($('<optgroup>', {
                            value: sector.id,
                            label: sector.sectorName
                        }));
                    } else {
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
    if (!$("#chkAggree").is(":checked")) {
        document.getElementById("lblCheckValidation").style.display = 'block';
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