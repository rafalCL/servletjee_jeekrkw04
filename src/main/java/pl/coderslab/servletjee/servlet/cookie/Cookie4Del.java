package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie4Del", urlPatterns = {"/removeCookie"})
public class Cookie4Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameOfCookieToDelete = req.getParameter("nameOfCookieToDelete");

        Cookie c = new Cookie(nameOfCookieToDelete, "");
        c.setPath("/");
        c.setMaxAge(0);
        resp.addCookie(c);

        resp.getWriter().println("Usunięto: " + nameOfCookieToDelete);
    }
}
