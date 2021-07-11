document.querySelector("#deleteeigenaarbutton").addEventListener("click", function () {
    let eigenaar = document.querySelector("#deleteeigenaar").value;

    fetch("/restservices/eigenaar/"+ eigenaar, {method: 'DELETE'})
        .then(response => console.log(response));
});