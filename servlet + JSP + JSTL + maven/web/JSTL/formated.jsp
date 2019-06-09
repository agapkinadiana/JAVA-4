<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--  Основные теги создания циклов, определения условий, вывода информации на страницу--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%-- Теги для форматирования и интернационализации информации--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:setLocale value="en-EN"/>
    Date in English format<br>
    today: <fmt:formatDate value="${now}"/>
    <h3>_________________________</h3>

    <fmt:setLocale value="ru-RU"/>
    Russian format<br>
    today: <fmt:formatDate value="${now}"/>
    <h3>_________________________</h3>

    time styles<br>
    (short): <fmt:formatDate value="${now}"
                             type="time" timeStyle="short"/><br/>
    (medium):<fmt:formatDate value="${now}"
                             type="time" timeStyle="medium"/><br/>
    (long): <fmt:formatDate value="${now}"
                            type="time" timeStyle="long"/>
    <h3>_________________________</h3>

    <c:set var="currentNumber" value="118000"/>
    <c:out value="outing format of numbers : ${currentNumber}"/> <br/>
    default format :
    <fmt:formatNumber value="${currentNumber}" /><br/>
    percents :
    <fmt:formatNumber value="${currentNumber}"
                      type="percent"/><br/>
    <fmt:setLocale value="be-BY"/>
    BYN :
    <fmt:formatNumber value="${currentNumber}"
                      type="currency"/><br/>
    Euro :
    <fmt:setLocale value="fr-FR"/>
    <fmt:formatNumber value= "${currentNumber}" type="currency"/>
    <h3>_________________________</h3>

    <c:set var = "now" value = "20-10-2010" />
    <fmt:parseDate value = "${now}" var = "parsedEmpDate" pattern = "dd-MM-yyyy" />
    Parsed Date: <c:out value = "${parsedEmpDate}" />
</body>
</html>
