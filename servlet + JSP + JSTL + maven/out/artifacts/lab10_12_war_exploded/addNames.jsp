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
            <form action="addNumber.jsp">
                <label>Имя: </label>
                <input type="text" name="FullName" value="${param.FullName}">
                <br>
                <label>Фамилия: </label>
                <input type="text" name="Surname" value="${param.Surname}">
                <br>
                <label>Отчество: </label>
                <input type="text" name="LastName" value="${param.LastName}">
                <br>
                <input type="submit" value="next">
            </form>
            <form action="login">
                <input type="submit" value="exit">
            </form>
        <%@include file="Footers/IndexFooter.jsp"%>
    </body>
</html>
