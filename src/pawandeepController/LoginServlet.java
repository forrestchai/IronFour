package pawandeepController;

import PawandeepModel.Doctor;
import PawandeepModel.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by PawandeepSingh on 14/12/16.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/Dashboard")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("username");
        String password = request.getParameter("password");

        char userType = id.charAt(0);


            Doctor dr = Doctor.getDoctor(id,password);


            if(!(dr ==null))
            {
//                Gson gson = new Gson();

//                String json = gson.toJson("p01");

//                HttpSession session = request.getSession(true);
                request.setAttribute("patientKey ","p01");
                getServletContext().getRequestDispatcher("/html/DashboardDoctor.jsp").forward(request,response);
            }
            else
            {
                PrintWriter out = response.getWriter();
                out.println("Login fail");
            }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
