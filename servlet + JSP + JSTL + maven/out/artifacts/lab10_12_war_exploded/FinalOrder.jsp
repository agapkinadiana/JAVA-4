<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        label {
            font-style: italic;
            color: grey;
        }
    </style>
</head>
<body>
<%@include file="Headers/IndexHeader.jsp"%>
<label>Telephone num: ${param.Adress}</label>
<br>
<label>Name: ${param.FullName}</label>
<br>
<label>Surname: ${param.Surname}</label>
<br>
<label>Patronymic: ${param.LastName}</label>
<br>
<form action="addNumber.jsp">
    <input type="hidden" name="FullName" value=${param.FullName}>
    <input type="hidden" name="Surname" value=${param.Surname}>
    <input type="hidden" name="LastName" value=${param.LastName}>
    <input type="hidden" name="Adress" value=${param.Adress}>
    <input type="submit" value="back">
</form>
<form action="login">
    <input type="submit" value="exit">
</form>
<%@include file="Footers/IndexFooter.jsp"%>
</body>
</html>
