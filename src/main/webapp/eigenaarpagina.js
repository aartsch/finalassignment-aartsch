document.querySelector("#postbewonerButton").addEventListener("click", function () {
    var formData = new FormData(document.querySelector("#POSTbewoner"));
    var encData = new URLSearchParams(formData.entries());

    fetch("/restservices/bewoners" , {method: 'POST', body: encData})
        .then(response => console.log(response));
});

document.querySelector("#posttoebehorenButton").addEventListener("click", function () {
    var formData = new FormData(document.querySelector("#POSTtoebehoren"));
    var encData = new URLSearchParams(formData.entries());

    fetch("/restservices/toebehorens", {method: 'POST', body: encData})
        .then(response => console.log(response));
});

document.querySelector("#postaquariumButton").addEventListener("click", function () {
    var id = "achternaam"
    var formData = new FormData(document.querySelector("#POSTAquarium"));
    var encData = new URLSearchParams(formData.entries());

    fetch("/restservices/aquarium/" + id, {method: 'POST', body: encData})
        .then(response => console.log(response));
});

document.querySelector("#deleteaquariumbutton").addEventListener("click", function () {
    let eigenaar = document.querySelector("#deleteeigenaarbutton").value;
    fetch("/restservices/aquarium/"+ eigenaar, {method: 'DELETE'})
        .then(response => console.log(response));
});