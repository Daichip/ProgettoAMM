function createElement(utente){
var link = $("<a>")
            .attr("href", "Bacheca?user=" + utente.id)
            .html(utente.nome + " " + utente.cognome);
    
    return $("<li>").append(link);
}

function listaVuota(){
    var warning = $("<p>")
            .html("Nessun utente corrisponde");
    return warning;
}


function stateSuccess(data){
    var utList = $("#sidePersone ul");

    $(utList).empty();
    if(!jQuery.isEmptyObject(data))
    {
        for(var instance in data){
                $(utList).append(createElement(data[instance]));
                ///console.log(createElement(data[instance]));  /// Stampa di controllo per i valori
        }
    }
    else
    {
        $(utList).append(listaVuota());
    }
}


function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#bottoneRicercaUtente").click(function(){

        var utCercato = $("#ricerca")[0].value;

        $.ajax({
            url: "Filter",
            data:{
                cmd: "search",
                utCercato: utCercato
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});

function trySearch()
{
    var utCercato = $("#ricerca")[0].value;
    $.ajax({
            url: "Filter",
            data:{
                cmd: "search",
                utCercato: utCercato
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
}