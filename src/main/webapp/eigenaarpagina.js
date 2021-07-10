document.querySelector("#deleteaquariumbutton").addEventListener("click", function () {
    let eigenaar = "achternaam";

    fetch("restservices/aquarium/"+ eigenaar, {method: 'DELETE'})
        .then(response => console.log(response));
});



fetch("/restservices/afspraken"+ eigenaar, fetchOptions).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let afspraakDiv = document.querySelector("#allAfspraken");
    for (let afspraak of myJson) {
        afspraakDiv.innerHTML = afspraakDiv.innerHTML + "datum: " + afspraak.datum + " afspraakID: " + afspraak.id + " klant: " + afspraak.klant +  " afspraakdetails: " + afspraak.afspraakdetails + " Gewerkte uren: " + afspraak.urenGewerkt + " Urengevalideerd: " + afspraak.urenGevalideerd + "<br/>";
    }

}).catch(error => console.log(error))

