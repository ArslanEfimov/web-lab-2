<%--
  Created by IntelliJ IDEA.
  User: arslanefimov
  Date: 03.10.2023
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<!DOCTYPE html>
<body>
<script src="https://www.desmos.com/api/v1.8/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6"></script>
<script type = "text/javascript" src="<%=request.getContextPath()%>/js/sendRequest.js"></script>
<script src="<%=request.getContextPath()%>/js/Graph.js"></script>
<jsp:useBean scope = "session" id = "tableDataList" class = "com.arslanefimov.lab2.model.AllTableData"/>
<c:forEach var = "data" items="${tableDataList.tableDataList}">
  <script>
    drawDots(${data.x}, ${data.y});
  </script>
</c:forEach>
</body>
</html>