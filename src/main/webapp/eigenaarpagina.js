document.querySelector("#postbewonerButton").addEventListener("click", async function () {
    var formData = new FormData(document.querySelector("#POSTbewoner"));
    var encData = new URLSearchParams(formData.entries());
    let element = document.querySelector("#postresponse");

    let response = await fetch("/restservices/bewoners" , {method: 'POST', body: encData})
    element.textContent = "Statuscode: " + response.status;
});

document.querySelector("#posttoebehorenButton").addEventListener("click", async function () {
    var formData = new FormData(document.querySelector("#POSTtoebehoren"));
    var encData = new URLSearchParams(formData.entries());
    let element = document.querySelector("#postresponse");

    let response = await fetch("/restservices/toebehorens", {method: 'POST', body: encData})
    element.textContent = "Statuscode: " + response.status;
});

document.querySelector("#postaquariumButton").addEventListener("click", async function () {
    var id = "achternaam"
    var formData = new FormData(document.querySelector("#POSTAquarium"));
    var encData = new URLSearchParams(formData.entries());
    let element = document.querySelector("#postresponse");

    let response = await fetch("/restservices/aquarium/" + id, {method: 'POST', body: encData})
    element.textContent = "Statuscode: " + response.status;
});

document.querySelector("#deleteaquariumbutton").addEventListener("click", async function () {
    let aquarium = document.querySelector("#deleteeigenaar").value;
    let element = document.querySelector("#postresponse");

    let response = await fetch("/restservices/aquarium/"+ aquarium, {method: 'DELETE'})
    element.textContent = "Statuscode: " + response.status;
});