package WayfinderController;

import WayfinderDBController.WaypointDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by User on 2/1/2017.
 */
@WebServlet(name = "QRServlet", urlPatterns = "/qrscan")
public class QRServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();

        if(session.getAttribute("usage").equals("origin")){
            String name="";
            String id = request.getParameter("id");
            System.out.println("Org id: "+ id);

            try
            {
                name = WaypointDA.getWaypointById(id).getName();
            }catch(SQLException e){e.printStackTrace();}

            session.setAttribute("orgId", id);
            System.out.println("Org Name: "+ name);
            session.setAttribute("orgName", name);

            System.out.println("Servlet Origin Scan executed.");
            response.sendRedirect("html/WayfinderStep3.jsp");
        }
        else if(session.getAttribute("usage").equals("map")){
            session.setAttribute("currId", request.getParameter("id"));

            System.out.println("Servlet Progress Scan executed: id = " +request.getParameter("id"));
            response.sendRedirect("html/WayfinderStep2.jsp");
        }

    }
}
