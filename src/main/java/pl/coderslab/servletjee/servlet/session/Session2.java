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
        // get new grade from form
        String newGradeStr = req.getParameter("newGrade");

        // start printing html form
        resp.getWriter().println("<html><body>");

        resp.getWriter().println("<form>");
        resp.getWriter().println("<div>Wpisz ocene <input type='number' name='newGrade'></div>");
        resp.getWriter().println("<div><input type='submit'></div>");
        resp.getWriter().println("</form>");

        // form is printed to response, now let's handle session and grades avg
        // first try get stored grades from session
        HttpSession session = req.getSession();
        List<Integer> grades = (List<Integer>)session.getAttribute("grades");
        // if there was no grades list in session then we have null here, lets test
        if (grades==null){
            // if there were no grades array in session let's create one
            grades = new ArrayList<>();
        }

        try {
            // parse input param
            int newGrade = Integer.parseInt(newGradeStr);
            // add it to grades arr
            grades.add(newGrade);
            // update session
            session.setAttribute("grades", grades);
            // now let's calculate avg
            // first sum
            double sum = 0.0;
            for (Integer grade : grades){
                sum += grade;
            }
            // now avg based on sum and count
            double avg = sum / grades.size();

            // display grades array and avg to user in browser
            resp.getWriter().println(Arrays.toString(grades.toArray()) + ", avg="+avg);

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        // close html
        resp.getWriter().println("</body></html>");
    }
}
