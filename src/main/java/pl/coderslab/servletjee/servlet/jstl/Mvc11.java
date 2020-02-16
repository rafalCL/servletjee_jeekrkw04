package pl.coderslab.servletjee.servlet.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc11", urlPatterns = {"/mvc11"})
public class Mvc11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String role = req.getParameter("role");
        try {
            final String roleFormatted = "ROLE_" + role.toUpperCase();

            req.setAttribute("userRole", roleFormatted);
        } catch (Exception e){
            e.printStackTrace();
        } // catch

        req.getRequestDispatcher("/jsp1.jsp")
                .forward(req, resp);
    } // doGet
}
