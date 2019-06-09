<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:out value="228-156*2 = "/><c:out value="${228-156*2}"/>
    <h3>_________________________</h3>

    <c:set var="hello" scope="page" value="Hello my dear friend"/> <c:out value="${hello}"/>
    <c:remove var="hello" scope="page"/>
    <h3>_________________________</h3>

    <c:set var="str" scope="page" value="${852}"/>
    <c:if test="${str > 850}">
        str = <c:out value="${str}"/>
    </c:if>
    <h3>_________________________</h3>

    <c:set var="dig" scope="page" value="${15}"/>
    <c:choose>
        <c:when test="${dig <= 20}">
            less than 20
        </c:when>
        <c:when test="${dig > 20}">
            more than 20
        </c:when>
        <c:otherwise>
            nothing
        </c:otherwise>
    </c:choose>
    <h3>_________________________</h3>

    <c:forEach var="clip" items="${headerValues}" varStatus="сounter">
        <tr>
            <td>${сounter.count}></td>
            <td>${clip.key.toString()}</td>
        </tr>
        <br/>
    </c:forEach>
</body>
</html>
