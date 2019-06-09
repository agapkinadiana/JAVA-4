<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp" %>
<html>
    <head>
        <title>Welcome</title>
        <style>
            h1 {
                font-style: italic;
                color: #49e1d3;
            }

            h4 {
                font-style: italic;
                color: grey;
            }
        </style>
    </head>
    <body>
    <%@include file="Headers/IndexHeader.jsp"%>
        <a href="LoginForm.jsp" style="font-style: italic; color: lightgray">Log out</a><br>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String good;
        if(Calendar.getInstance().getTime().getHours() < 17)
            good = "Good morning, ";
        else
            good = "Good evening, ";
    %>
    <h1>
        <%= good%> ${name}
    </h1>
    <h4>
        Last session was: ${last}
    </h4>
    <h4>
    Number of visits: ${times}
    </h4>
    <form action="addNames.jsp">
        <input type="submit" value="next">
    </form>
    <%@include file="Footers/IndexFooter.jsp"%>
    </body>
</html>
