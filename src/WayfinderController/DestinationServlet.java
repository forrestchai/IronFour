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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Waypoint> waLa = new ArrayList<Waypoint>();
        ArrayList<Waypoint> waWa = new ArrayList<Waypoint>();
        ArrayList<Waypoint> waDept = new ArrayList<Waypoint>();
        ArrayList<Waypoint> waAll = new ArrayList<Waypoint>();

        try{
            waLa = WaypointDA.getLandmarkWaypoints();
            waWa = WaypointDA.getWardWaypoints();
            waDept = WaypointDA.getDeptWaypoint();
            waAll = WaypointDA.getDeptWaypoint();
        }catch (SQLException e){e.printStackTrace();}


        HttpSession session = request.getSession();
        session.setAttribute("landList", waLa);
        session.setAttribute("wardList", waWa);
        session.setAttribute("deptList", waDept);
        session.setAttribute("allList", waAll);

        response.sendRedirect("/html/WayfinderStep4.jsp");
        System.out.println("Servlet executed.");

    }













}
