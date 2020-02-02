package pl.coderslab.servletjee.servlet.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name="Get2", urlPatterns = {"/get2"})
public class Get2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();

        for (String key : parameters.keySet()){
            resp.getWriter().println(key + " : " + Arrays.toString(parameters.get(key)));
        }
    }
}
