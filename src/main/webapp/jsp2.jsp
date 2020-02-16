<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count JSTL</title>
</head>
<body>
<div>Liczby:</div>
    <c:if test="${start!=null}">
        <c:forEach var="i" begin="${start}" end="${end}">
            <div><c:out value="${i}"></c:out></div>
        </c:forEach>
    </c:if>
</body>
</html>
