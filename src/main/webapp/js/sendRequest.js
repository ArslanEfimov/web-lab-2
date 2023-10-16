
function sendCoordinates(e, r){
    let calculatorRect = elt.getBoundingClientRect();
    const x = e.clientX - calculatorRect.left;
    const y = e.clientY - calculatorRect.top;
    const mathCoordinates = calculator.pixelsToMath({x: x, y: y});
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/web-lab-2-1.0-SNAPSHOT/controller");
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(`X=${mathCoordinates.x}&Y=${mathCoordinates.y}&R=${r}`);


    xhr.onload = () => {
        if (xhr.status === 200){
            window.location.href = 'jsp/result.jsp';
        }
        if(xhr.status===400){
            window.location.href = 'jsp/badRequest.jsp'
        }
    }

}