package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie1Del", urlPatterns = {"/deleteCookie"})
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c = new Cookie("User", "");
        c.setPath("/");
        c.setMaxAge(0);
        resp.addCookie(c);

        resp.getWriter().println("Usunięto ciasteczko");
    }
}
