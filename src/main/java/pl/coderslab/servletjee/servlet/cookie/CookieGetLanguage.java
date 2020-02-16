package pl.coderslab.servletjee.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieGetLanguage", urlPatterns = {"/getLanguage"})
public class CookieGetLanguage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String languageFromCookie = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("language")){
                languageFromCookie = c.getValue();
            }
        }

        if(languageFromCookie==null){
            resp.getWriter().println("Strona działa w języku domyślnym");
            return;
        }

        if(languageFromCookie.equals("pl")) {
            resp.getWriter().println("Strona działa w języku polskim");
        } else if(languageFromCookie.equals("en")){
            resp.getWriter().println("English version of page");
        } else {
            resp.getWriter().println("Strona działa w języku domyślnym");
        }
    }
}
