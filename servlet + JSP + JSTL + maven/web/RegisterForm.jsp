<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Registration</title>
        <style>
            section{
                position: relative;
                left: 35%;
                height: 250px;
                width: 30%;
                margin-bottom: 10px;

                -webkit-border-radius: 3px;
                -moz-border-radius: 3px;
                border-radius: 3px;
                background-color: #81f6e3;
            }
            span{
                font-style: italic;
                font-size: 14px;
            }
            .register-header{
                font-style: italic;
                padding-top: 20px;
                display: block;
                text-align: center;
                font-size: 25px;
            }
            .input-div{
                margin-top: 20px;
                text-align: center;
            }
            .btn{
                margin-top: 20px;
                position: relative;
            }
            .register-btn{
                width: 16%;
                left: 42%;
            }
            .login-btn{
                margin-top: 0;
                width: 16%;
                left: 42%;
            }
            .error-message{
                font-style: italic;
                color: red;
                font-weight: bold;
                font-size: 18px;
                display: block;
                text-align: center;

                padding: 10px;
            }
        </style>
    </head>
    <body>

        <section>
            <span class="register-header">Registration</span>

            <c:if test="${not empty errorMessage}">
                <span class="error-message">${errorMessage}</span>
            </c:if>

            <form method="post" action="register">

                <div class="input-div">
                    <span>Username:</span>
                    <input type="text" name="username"/>
                </div>

                <div class="input-div">
                    <span>Password:</span>
                    <input type="password" name="password"/>
                </div>

                <input class="btn register-btn" type="submit" value="Submit"/>
            </form>

            <form method="get" action="LoginForm.jsp">
                <input class="btn login-btn" type="submit" value="Login"/>
            </form>
        </section>
    </body>
</html>
