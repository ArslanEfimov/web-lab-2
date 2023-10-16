let elt = document.getElementById('calculator');
const selectR = document.getElementById('R-text');

elt.addEventListener("click", function (e) {
    let calculatorRect = elt.getBoundingClientRect();
    x = e.clientX - calculatorRect.left;
    y = e.clientY - calculatorRect.top;
    const mathCoordinates = calculator.pixelsToMath({x: x, y: y});
    sendCoordinates(e, selectR.value);
});
selectR.addEventListener('change', () =>{
    drawGraph();
})
let calculator = Desmos.GraphingCalculator(elt, {
    keypad: false,
    expressions: false,
    settingsMenu: false,
    invertedColors: true,
    xAxisLabel: 'x',
    yAxisLabel: 'y',
    xAxisStep: 0.5,
    yAxisStep: 0.5,
    xAxisArrowMode: Desmos.AxisArrowModes.POSITIVE,
    yAxisArrowMode: Desmos.AxisArrowModes.POSITIVE
});

const selectX = document.getElementById('coordinate-x');
const inputY = document.getElementById('Y-text');


function drawDots(x, y) {
    calculator.setExpression({
        id: x + '' + y,
        latex: '\\left(' + x + ',' + y + '\\right)',
        color: '#0fd736',
        pointStyle: Desmos.Styles.CROSS
    })
}

// Добавляем прослушиватель событий к форме
        function drawGraph() {
            // Предотвращаем стандартную отправку формы

            // Получаем выбранные значения
            const xValue = parseFloat(selectX.value);
            const yValue = parseFloat(inputY.value);
            const rValue = parseFloat(selectR.value);
            calculator.setMathBounds({
                left: -5,
                right: 5,
                bottom: -5,
                top: 5
            });

            // Строим область на графике на основе выбранных значений

            calculator.setExpression({
                id: '1',
                latex: 'y\\le\\sqrt{(' + rValue + '^{2}-x^{2})}\\ \\left\\{x\\le0\\right\\}\\left\\{y\\ge0\\right\\}',
                color: '#c74440',
            });

            calculator.setExpression({
                id: '2',
                latex: 'y\\ \\le\\ -x+' + rValue + '\\ \\left\\{x\\ge0\\right\\}\\left\\{y\\ge0\\right\\}',
                color: '#c74440',
            });
            calculator.setExpression({
                id: '3',
                latex: 'y\\le\\ 0\\ \\ \\left\\{0\\le x\\le\\frac{' + rValue + '}{2}\\right\\}\\left\\{y\\ge-' + rValue + '\\right\\}',
                color: '#c74440',
            });

        }










