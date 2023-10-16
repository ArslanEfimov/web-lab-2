<%--
  Created by IntelliJ IDEA.
  User: arslanefimov
  Date: 12.10.2023
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bad request</title>
    <link rel = "stylesheet" href = "<%=request.getContextPath()%>/css/badRequest.css"/>
</head>
<body>
<div id = main-selection>
    <img src = "https://i.imgur.com/GpY6bTJ.png" class = "bad-req-image"/>
    <a href="${pageContext.request.contextPath}/index.jsp">
        <p>Плохой запрос, пожалуйста, вернитесь на начальную странциу</p>
    </a>
</div>
</body>
</html>
