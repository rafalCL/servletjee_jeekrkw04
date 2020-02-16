package pl.coderslab.servletjee.servlet.jstl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc12", urlPatterns = {"/mvc12"})
public class Mvc12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String startStr = req.getParameter("start");
        final String endStr = req.getParameter("end");

        try{
            Integer start = Integer.parseInt(startStr);
            Integer end = Integer.parseInt(endStr);
            start += 10;
            end += 10;
            req.setAttribute("start", start);
            req.setAttribute("end", end);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("/jsp2.jsp")
                .forward(req, resp);
    } // doGet
}
