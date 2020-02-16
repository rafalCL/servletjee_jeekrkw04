package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieSetLanguage", urlPatterns = {"/setLanguage"})
public class CookieSetLanguage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/setLanguage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        Cookie c = new Cookie("language", language);
        c.setPath("/");

        resp.addCookie(c);

        if(language.equals("pl")) {
            resp.getWriter().println("Zapisano język:" + language);
        } else if(language.equals("en")){
            resp.getWriter().println("Saved language:" + language);
        } else {
            resp.getWriter().println("Nie wybrano języka");
        }
    }
}
