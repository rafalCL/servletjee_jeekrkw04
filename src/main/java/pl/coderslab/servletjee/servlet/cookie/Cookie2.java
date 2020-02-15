package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie2", urlPatterns = {"/addToCookies"})
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");

        Cookie c = new Cookie(key, value);
        c.setPath("/");
        c.setMaxAge(24 * 60 * 60);
        resp.addCookie(c);

        resp.getWriter().println("Dodano: "+ key + " : "+value);
    }
}
