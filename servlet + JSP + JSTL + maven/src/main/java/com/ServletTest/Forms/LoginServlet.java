package com.ServletTest.Forms;

import com.ServletTest.Classes.DataProcessor;
import com.ServletTest.Classes.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String errorMessage = null;

        Cookie lastSession = new Cookie("Session", new Date().toString());
        Cookie Times = new Cookie("Times", "0");

        if(username.isEmpty() || password.isEmpty()){
            errorMessage = "You should to fill both fields";
        }else {
            if(DataProcessor.IsSuchUserExist(username, password)){
                request.setAttribute("name", username);

                Cookie [] cookies = request.getCookies();
                for(int i =0; i< cookies.length; i++)
                {
                    if(cookies[i].getName().equals("Session"))
                        request.setAttribute("last", cookies[i].getValue());
                    else if(cookies[i].getName().equals("Times"))
                    {
                        request.setAttribute("times", cookies[i].getValue());
                        Integer s = Integer.parseInt(cookies[i].getValue())+1;
                        Times = new Cookie("Times", s.toString());
                    }
                }

                response.addCookie(lastSession);
                response.addCookie(Times);

                User user = User.Initialize();
                user.setUsername(username);
                user.setPassword(password);

                request.setAttribute("user", user);
                request.getRequestDispatcher("Welcome.jsp").include(request, response);
            }
            else{
                errorMessage = "Invalid credentials. Try to register";
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        if(errorMessage != null)
            request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage", null);
        request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
    }
}
