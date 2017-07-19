package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexandru.Vlad on 7/19/2017.
 */
public class HelloWorldServletForward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "";

        // Set the response type
        response.setContentType("text/html");

        String atrib = (String) request.getAttribute("someAttribute");

        response.getWriter().write("Hello <b>" + request.getParameter("user") + " "
                + "</b> from the Forward Servlet! " + atrib);

    }

}
