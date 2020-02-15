package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Cookie1Get", urlPatterns = {"/showCookie"})
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies==null){
            resp.getWriter().println("Nie ustawiono ciasteczek");
            return;
        }

        String value = null;
        for (Cookie c : cookies){
            if("User".equals(c.getName())){
                value = c.getValue();
            }
        }

        resp.getWriter().println("Wartość ciasteczka: " + value);
    }
}
