package com.serrvlet.session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
    private final String username = "admin";
    private final String password = "admin";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        if(this.username.equals(username) && this.password.equals(password)){
            HttpSession oldSession = request.getSession();
            if(oldSession != null){
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);
            //Above line creates a new session and saves it in the newSession object. This will also create the JSESSIONID cookie with the new value. Note that passing the Boolean parameter “false” to the getSession() returns the existing session and returns null if no session exists. Passing the parameter “true” will create a new session if no session exists.
            //setting session to expiry in 5 mins
            newSession.setMaxInactiveInterval(5*60);

            Cookie message = new Cookie("message", "Welcome");
            response.addCookie(message);
            message.setMaxAge(20*60);
            response.sendRedirect("/LoginSuccess.jsp");
           /* cookie.setSecure(true);
            cookie.setHttpOnly(true);*/
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}
