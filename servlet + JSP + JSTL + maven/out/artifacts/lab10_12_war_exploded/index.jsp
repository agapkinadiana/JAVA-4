<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp" %>
<html>
  <head>
    <title>Index.jsp</title>
    <style>
      span{
        font-style: italic;
        margin-right: 10px;
      }
      .container{
        position: relative;
        width: 200px;
        height: 200px;
        margin: 10px;
        padding: 15px;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
      }
      .lab11-12{
        margin-left: 300px;
        margin-top: -245px;
        background-color: #fff7d1;
        border: 2px solid #fff7d1;
      }
      .lab10{
        background-color: #fbdecf;
        border: 2px solid #fbdecf
      }

      .lab13 {
        margin-left: 600px;
        margin-top: -245px;
        background-color: #d8ffee;
        border: 2px solid #cdf4e3;
      }
      .login{
        position: relative;
        top: 30%;
        left: 10%;
      }
      h3 {
        font-style: italic;
        alignment: center;
      }
    </style>
  </head>
  <body>

    <div class="container lab10">
      <h3>Lab10:</h3>
      <span>Several info via servlet: </span>
      <form method="get" action="get_servlet_info">
        <input type="submit" value="Show Info"/>
      </form>
      <span>Code inside a JSP page</span>
    </div>

    <div class="container lab11-12">
      <h3>Lab 11-12:</h3>
      <form method="get" action="LoginForm.jsp">
        <input class="login" type="submit" value="Go to login"/>
      </form>
    </div>

    <div class="container lab13">
      <h3>Lab13:</h3>
      <form method="get" action="JSTL/main.jsp">
        <input type="submit" value="Show"/>
      </form>
    </div>
  </body>
</html>
