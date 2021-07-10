function login() {
    var formData = new FormData(document.querySelector("#Login"));
    var encData = new URLSearchParams(formData.entries());
    // var myWindow = window.open("", "", "width=200,height=100");
    fetch("/restservices/authentication", {method: "POST", body: encData})
        .then(function (response) {
            if (response.ok)
                return response.json(); //body will be json
            else throw "Wrong username / password"; //there is no body, just throw the error
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT)) //present in the JsonBody
        .then(window.location.href="beheerderpagina.html")
        .catch(error => console.log(error)) //will log Wrong username/password if !response.ok
}

document.querySelector("#loginbutton").addEventListener("click", login);
