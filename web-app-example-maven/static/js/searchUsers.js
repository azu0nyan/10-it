console.log("js loaded")
function setupListeners(){
    console.log("Setting up listeners...")
    //Находим элементы по их id в html коде
    var input = document.getElementById("searchWindow");
    var output = document.getElementById("searchResult")

    input.addEventListener("input", (event) => {
        //Конструируем и отправляем запрос на searchUsersReq
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/searchUsersReq?query=" + input.value)
        //При выполнении запроса выполняем следующую функцию
        xhr.onload = function() {
            if (xhr.status == 200) {
                console.log("response :" + xhr.responseText)
                var resArr = JSON.parse(xhr.responseText)
                var html = ""
                for (var i = 0; i < resArr.length; i++) {
                    html += "<tr><td>" + resArr[i].id + "</td><td> " + resArr[i].login + "</td></tr>"
                }
                html = "<table><tr><th> Индекс </th><th> Имя</th><tr>" + html + "</table>"
                output.innerHTML = html
            }
       }
       console.log("Sending search request :" + input.value);
       xhr.send();
    });
}
window.onload=setupListeners()