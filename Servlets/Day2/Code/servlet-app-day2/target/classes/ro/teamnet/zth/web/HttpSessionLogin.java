package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Alexandru.Vlad on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        Cookie[] cookies = request.getCookies();

        if(username.equals("admin") && password.equals("admin")){
            response.getWriter().write("Welcome back " + username + "!\n");
            for(Cookie c : cookies){
                response.getWriter().write(c + "\n");
            }
            response.getWriter().write("Session id:" + request.getRequestedSessionId());
        } else {
            httpSession.setAttribute("session",httpSession);
            httpSession.setAttribute("user",username);
            RequestDispatcher requestDispatcher =
                    request.getRequestDispatcher("/views/loginFail.jsp");
            requestDispatcher.forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
