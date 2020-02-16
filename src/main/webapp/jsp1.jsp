<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSTL</title>
</head>
<body>
    <c:out value="${userRole}" default="guest"></c:out>
</body>
</html>
