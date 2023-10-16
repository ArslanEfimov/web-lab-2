let Y, R;
document.addEventListener("DOMContentLoaded", function (){
    document.getElementById("submit-button").addEventListener("click", click_button);
    document.getElementById("clear-button").addEventListener("click", clear_button);
});
function check_Y() {
    let X_text = document.getElementById("coordinate-x");
    let Y_text = document.getElementById("Y-text");
    let Y_value = Y_text.value;
    Y = Number(Y_value);
    if(Y_value.trim() === ""){
        Y_text.setCustomValidity("Поле не может быть пустым!");
        return false;
    }
    else if(isNaN(Y)){
        Y_text.setCustomValidity("В поле должно быть лишь число!");
        console.log("wtf")
        return false;
    }else if(Y<=-5 || Y >= 5){
        Y_text.setCustomValidity("Значения должны быть в диапозоне от -5 до 5!");
        return false;
    }
        Y_text.setCustomValidity("");
        console.log("all is good!");
        return true;
}

function click_button() {
    if(!check_Y()) return;

    let X_text = document.getElementById("coordinate-x").value;
    let Y_text = document.getElementById("Y-text").value;
    let R_text = document.getElementById("R-text").value;
    console.log(X_text, Y_text, R_text);

}

function clear_button(e) {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/web-lab-2-1.0-SNAPSHOT/controller");
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(`event=clear`);
    e.preventDefault();
    xhr.onload = () =>{
        if(xhr.status===200){
            window.location.href = 'index.jsp';
        }
    }

}


