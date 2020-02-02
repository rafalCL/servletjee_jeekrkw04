package pl.coderslab.servletjee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Servlet11", urlPatterns = {"/servlet11"})
public class Servlet11 extends HttpServlet {

// jakbyscie chcieli init/destroy to tu
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        System.out.println("to jest inicjalizacja servletu");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello First Servlet");
        resp.getWriter().println("Content11");
    }
}
