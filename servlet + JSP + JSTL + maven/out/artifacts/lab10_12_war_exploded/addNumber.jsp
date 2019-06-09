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
<form action="FinalOrder.jsp">
    <input type="hidden" name="FullName" value=${param.FullName}>
    <input type="hidden" name="Surname" value=${param.Surname}>
    <input type="hidden" name="LastName" value=${param.LastName}>
    <label>Telephone number</label>
    <input type="text" name="Adress" value=${param.Adress}>
    <input type="submit" value="next">
</form>
<form action="addNames.jsp" >
    <input type="hidden" name="FullName" value=${param.FullName}>
    <input type="hidden" name="Surname" value=${param.Surname}>
    <input type="hidden" name="LastName" value=${param.LastName}>
    <input type="submit" value="back">
</form>
<form action="login">
    <input type="submit" value="exit">
</form>
<%@include file="Footers/IndexFooter.jsp"%>
</body>
</html>
