package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie4Show", urlPatterns = {"/showAllCookies"})
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies==null){
            resp.getWriter().println("Nie ustawiono ciasteczek");
            return;
        }


        for (Cookie c : cookies){
            String link = "<div><a href='removeCookie?nameOfCookieToDelete=%s'>%s</a></div>";
            String linkText = c.getName() + " : " + c.getValue();
            resp.getWriter().println(String.format(link, c.getName(), linkText));
        }
    }
}
