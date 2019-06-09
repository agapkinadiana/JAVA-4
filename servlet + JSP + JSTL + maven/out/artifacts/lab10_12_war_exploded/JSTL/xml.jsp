<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <c:import var="booksInformation" url="books.xml"/>
    <x:parse xml="${booksInformation}" var="info"/>
    first book :
    <x:out select="$info/books/book[1]/name"/><br>
    second book :
    <x:out select="$info/books/book[2]/name"/>
    <h3>_________________________</h3>

    <x:choose>
        <x:when select="$info/books/book[1]/author = 'Patsei NV'">
            book is writen by Natalia Vladimirivna
        </x:when>
        <x:when select="$info/books/book[1]/author = 'Smelov VV'">
            book is writen by Vladimir Vladislavovich
        </x:when>
        <x:otherwise>
            Unknown author
        </x:otherwise>
    </x:choose>
    <h3>_________________________</h3>

    <c:import url="stule.xsl" var="style"/>
    <x:transform xml="${info}" xslt="${style}"/>
</body>
</html>
