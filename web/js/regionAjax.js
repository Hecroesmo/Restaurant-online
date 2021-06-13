
$.when( $.ready ).then(function() {
    $( "#firstLevel" ).change(function() {
        var secondLevel = $("#secondLevel");
        var value = $(this).val();
        
        getRegions(value, secondLevel);
    });
    
    $( "#secondLevel" ).change(function() {
        var thirdLevel = $("#thirdLevel");
        var value = $(this).val();
        
        getRegions(value, thirdLevel,);
    });
    
    $( "#thirdLevel" ).change(function() {
        var fourLevel = $("#fourLevel");
        var value = $(this).val();
        
        getRegions(value, fourLevel,);
    });
});

function getRegions(value, element) {
    $(element).empty().append(
        "<option selected>Selecione ...</option>");

    $.ajax({
        url: "HandleRegionReq",
        data: {
            name: value
        },
        type: "GET",
        dataType : "json"
    }).done(function( json ) {
        createSelect(json, element);
    }).fail(function( xhr, status, errorThrown ) {
        alert( "Sorry, there was a problem!" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    });
}

function createSelect(json, element) {
    for (let i in json) {
        $(element).append(
            "<option>" + json[i].name + "</option>");
    }
}

