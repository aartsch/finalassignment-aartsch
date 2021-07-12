let eigenaar = "achternaam";
fetch("/restservices/aquarium/"+ eigenaar).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let aquariumDiv = document.querySelector("#allAfspraken");
    for (let aquarium of myJson) {
        aquariumDiv.innerHTML = aquariumDiv.innerHTML + aquarium.naam + aquarium.lengte + aquarium.breedte +  aquarium.hoogte +  aquarium.bodemsoort + aquarium.watersoort +  "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/toebehoren").then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let toebehorenDiv = document.querySelector("#Toebehoren");
    for (let toebehoren of myJson) {
        toebehorenDiv.innerHTML = toebehorenDiv.innerHTML + toebehoren.model + toebehoren.serienummer + toebehoren.omschrijving + "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/bewoner" ).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let bewonerDiv = document.querySelector("#Bewoner");
    for (let bewoner of myJson) {
        bewonerDiv.innerHTML = bewonerDiv.innerHTML + bewoner.soortnaam + bewoner.kleurnaam + bewoner.aantal + bewoner.groepsDier + bewoner.type + "<br/>";
    }

}).catch(error => console.log(error))

fetch("/restservices/ornament/" + eigenaar).then(function (response) {
    if (response.ok) return response.json();
}).then(myJson => {
    let ornamentDiv = document.querySelector("#Ornamenten");
    for (let ornament of myJson) {
        ornamentDiv.innerHTML = ornamentDiv.innerHTML + ornament.naam + ornament.omschrijving + ornament.kleur + ornament.kanOpLuchtPomp + "<br/>";
    }

}).catch(error => console.log(error))






