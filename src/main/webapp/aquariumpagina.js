let eigenaar = "achternaam";
fetch("/restservices/afspraken"+ eigenaar, fetchOptions).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let afspraakDiv = document.querySelector("#allAfspraken");
    for (let afspraak of myJson) {
        afspraakDiv.innerHTML = afspraakDiv.innerHTML + "datum: " + afspraak.datum + " afspraakID: " + afspraak.id + " klant: " + afspraak.klant +  " afspraakdetails: " + afspraak.afspraakdetails + " Gewerkte uren: " + afspraak.urenGewerkt + " Urengevalideerd: " + afspraak.urenGevalideerd + "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/toebehoren" + eigenaar).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let toebehorenDiv = document.querySelector("#Toebehoren");
    for (let toebehoren of myJson) {
        toebehorenDiv.innerHTML = toebehorenDiv.innerHTML + toebehoren.model + toebehoren.serienummer + toebehoren.omschrijving + "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/bewoner" + eigenaar).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let bewonerDiv = document.querySelector("#Bewoner");
    for (let bewoner of myJson) {
        bewonerDiv.innerHTML = bewonerDiv.innerHTML + bewoner.soortnaam + bewoner.kleurnaam + bewoner.aantal + bewoner.groepsDier + bewoner.type + "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/ornament" + eigenaar).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let ornamentDiv = document.querySelector("#Ornamenten");
    for (let ornament of myJson) {
        ornamentDiv.innerHTML = ornamentDiv.innerHTML + ornament.naam + ornament.omschrijving + ornament.kleur + ornament.kanOpLuchtPomp + "<br/>";
    }

}).catch(error => console.log(error))






