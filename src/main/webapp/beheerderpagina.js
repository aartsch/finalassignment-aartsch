document.querySelector("#deleteeigenaarbutton").addEventListener("click", async function () {
    let eigenaar = document.querySelector("#deleteeigenaar").value;
    let element = document.querySelector("#postresponse");

    let response = await fetch("/restservices/eigenaar/"+ eigenaar, {method: 'DELETE'})
    element.textContent = "Statuscode: " + response.status;
        // .then(response => console.log(response));
});

