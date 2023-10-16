<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Web-Lab-1</title>
    <link rel="stylesheet" href = "css/mainstyles.css">
    <link rel="stylesheet" href = "css/table.css">
</head>
<body>
<div id = "header">
    <p>Ефимов Арслан Альбертович P3232</p>
    <p>Вариант - 1305</p>
</div>
<div id = container>
    <div id = "middle-zone">
        <div id = "top-selection">
            Enter coordinates
        </div>
        <form action = "${pageContext.request.contextPath}/controller" method = "post" id = "coordinates-form">
            <div id = "left-selection">
                <div id = "X-text">
                    <label for="X-text"></label>
                    <label for = "coordinate-x">Choose X: </label>
                    <select id = "coordinate-x" name = "X">
                        <option value = "-4">X: -4</option>
                        <option value = "-3">X: -3</option>
                        <option value = "-2">X: -2</option>
                        <option value = "-1">X: -1</option>
                        <option value = "0">X: 0</option>
                        <option value = "1">X: 1</option>
                        <option value = "2">X: 2</option>
                        <option value = "3">X: 3</option>
                        <option value = "4">X: 4</option>
                    </select>
                </div>
                <div id = "coordinate-y">
                    <label for="Y-text"></label>
                    <input id = "Y-text" type = "text" name  = "Y" required placeholder = "Enter Y" maxlength="7"/>
                    <label for = "coordinate-y">Enter Y: </label>
                </div>
                <div id = "coordinate-r">
                    <label for = "R-text">Enter R: </label>
                    <select id = "R-text"  name = "R">
                        <option value = "1"> R: 1 </option>
                        <option value = "1.5"> R: 1.5 </option>
                        <option value = "2"> R: 2 </option>
                        <option value = "2.5"> R: 2.5 </option>
                        <option value = "3"> R: 3 </option>
                    </select>
                </div>
            </div>
            <div id = "button-container">
                <div id = "sub-button">
                    <button id = "submit-button" class = "button-result" type="submit"><span class = "button-result-text">Perform a check</span></button>
                </div>
                <div id = "clr-button">
                    <button id = "clear-button" class = "button-clear" type="submit" onclick="return confirm('Вы уверены?');"><span class = "button-clear-text">Clear</span></button>
                </div>
            </div>
        </form>
    </div>

    <div id = "image-selection">
        <div id="calculator">
            <jsp:include page = "jsp/dots.jsp"/>
        </div>
    </div>

    <div id = "table-selection">
        <table id = "table" class = "result-table">
            <thead>
            <tr class = "table-header">
                <th scope = "col">X</th>
                <th scope = "col">Y</th>
                <th scope = "col">R</th>
                <th scope = "col">Текущее время</th>
                <th scope = "col">Время исполнения</th>
                <th scope = "col">Результат</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean scope = "session" id = "tableDataList" class = "com.arslanefimov.lab2.model.AllTableData"/>
            <c:forEach var="data" items="${tableDataList.tableDataList}">
            <tr class="table-row">
                <td>${data.x}</td>
                <td>${data.y}</td>
                <td>${data.r}</td>
                <td>${data.dateTime}</td>
                <td>${data.leadTime}</td>
                <td>${data.result ? "<span class = \"hit\">Попадание</span>" : "<span class = \"miss\">Промах</span>"}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type = "text/javascript" src="js/validate.js"></script>
<script src="https://www.desmos.com/api/v1.8/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6"></script>
<script type ="text/javascript" src="js/sendRequest.js"></script>
<script src="js/Graph.js"></script>
</body>
</html>