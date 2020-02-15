package pl.coderslab.servletjee.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="Session2", urlPatterns = {"/session2"})
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newGradeStr = req.getParameter("newGrade");

        resp.getWriter().println("<html><body>");

        resp.getWriter().println("<form>");
        resp.getWriter().println("<div>Wpisz ocene <input type='number' name='newGrade'></div>");
        resp.getWriter().println("<div><input type='submit'></div>");
        resp.getWriter().println("</form>");

        HttpSession session = req.getSession();
        List<Integer> grades = (List<Integer>)session.getAttribute("grades");

        if (grades==null){
            grades = new ArrayList<>();
        }

        try {
            int newGrade = Integer.parseInt(newGradeStr);
            grades.add(newGrade);
            session.setAttribute("grades", grades);
            double sum = 0.0;
            for (Integer grade : grades){
                sum += grade;
            }
            double avg = sum / grades.size();

            resp.getWriter().println(Arrays.toString(grades.toArray()) + ", avg="+avg);

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        resp.getWriter().println("</body></html>");
    }
}
