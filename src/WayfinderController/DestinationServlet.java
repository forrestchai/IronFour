package WayfinderController;

import WayfinderDBController.WaypointDA;
import WayfinderModel.Waypoint;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * Created by User on 2/1/2017.
 */
@WebServlet(name = "DestinationServlet", urlPatterns = "/selectDestination")
public class DestinationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        session.setAttribute("destName", request.getParameter("name"));
        session.setAttribute("destId", request.getParameter("id"));

        System.out.println("Servlet executed.");
        response.sendRedirect("html/WayfinderStep2.jsp");
    }













}
