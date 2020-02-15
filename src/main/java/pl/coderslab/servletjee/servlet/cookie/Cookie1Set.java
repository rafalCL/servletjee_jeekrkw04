package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie1Set", urlPatterns = {"/setCookie"})
public class Cookie1Set extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User``` na `CodersLab`, z ważnością `24h`
        Cookie c = new Cookie("User", "CodersLab");
        c.setPath("/");
        c.setMaxAge(24 * 60 * 60);
        resp.addCookie(c);

        resp.getWriter().println("Dodano ciasteczko");
    }
}
