package WayfinderController;

import WayfinderDBController.RouteDA;
import WayfinderDBController.WaypointDA;
import WayfinderModel.Route;
import WayfinderModel.Waypoint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 12/14/2016.
 */
@WebServlet(name = "WayfinderStep3Servlet", urlPatterns = "/wayfinderstep3")
public class WayfinderStep3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        ArrayList<String> routeIDList = RouteDA.getDummyRoute3();
//        ArrayList<Route> routeList = null;
//        try {
//            RouteDA rd = new RouteDA();
//            routeList = rd.getRouteList(routeIDList);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ArrayList<String> waypointIDList = WaypointDA.getDummyWaypoint3();
//        ArrayList<Waypoint> waypointList = null;
//        try {
//            waypointList = WaypointDA.getWaypointList(waypointIDList);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("routeList", routeList);
//        session.setAttribute("waypointList", waypointList);
//
//        response.sendRedirect("/html/WayfinderStep4.jsp");
//        System.out.println("Servlet executed.");

    }
}
