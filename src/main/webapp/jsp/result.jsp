<%--
  Created by IntelliJ IDEA.
  User: arslanefimov
  Date: 02.10.2023
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href = "<%=request.getContextPath()%>/css/mainstyles.css">
    <link rel="stylesheet" href = "<%=request.getContextPath()%>/css/table.css">
</head>
<body>
<div id = "header">
    <p>Ефимов Арслан Альбертович P3232</p>
    <p>Вариант - 1305</p>
</div>

<div id = container>
    <div id = "back-button">
        <a href="<%=request.getContextPath()%>/index.jsp">
            <button id = "home-button" class = "button-to-home" type = "submit"><span class = "button-home-text">Back to home page</span></button>
        </a>
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
            <tr class = "table-row">
                <td><%=session.getAttribute("nextX")%></td>
                <td><%=session.getAttribute("nextY")%></td>
                <td><%=session.getAttribute("nextR")%></td>
                <td><%=session.getAttribute("nextDateTime")%></td>
                <td><%=session.getAttribute("nextExecuteTime")%></td>
                <td><%=session.getAttribute("nextResult")%></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</body>
</html>
