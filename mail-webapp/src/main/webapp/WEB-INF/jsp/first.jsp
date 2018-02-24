
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>测试</title>
</head>
<body>
<c:forEach var = "item" items="${demo}">
    <tr>${item}</tr>
</c:forEach>

</body>
</html>
