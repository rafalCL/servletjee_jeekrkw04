package pl.coderslab.servletjee.servlet.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Get1", urlPatterns = {"/get1"})
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String startStr = req.getParameter("start");
            String endStr = req.getParameter("end");
            // convert to int
            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);

            for (int i = start; i < end; i++) {
                resp.getWriter().println("<p>" + i + "</p>");
            }
        } catch (NumberFormatException e){
            resp.getWriter().println("nieprawidlowe argumenty");
        }
    }
}
