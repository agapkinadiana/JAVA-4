<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="MyTag.tld" %>

<html>
<head>
</head>
<body>
<form action="core.jsp">
    <input type="submit" value="core">
</form>

<form action="formated.jsp">
    <input type="submit" value="formated">
</form>

<form action="xml.jsp">
    <input type="submit" value="xml">
</form>

<form action="functions.jsp">
    <input type="submit" value="functions">
</form>

<form action="result.jsp" method="post">
    <my:ADSLabledTextField label="Name: " name="Firstname"/><br/>
    <my:ADSLabledTextField label="Surname: " name="Surname"/><br/>
    <my:ADSLabledTextField label="Fathername: " name="FatherName"/><br/>
    <my:ADSLabledTextField label="City: " name="City"/><br/>
    <my:ADSLabledTextField label="Street: " name="Street"/><br/><br/>
    <my:ADSsubmit/>
</body>
</html>
