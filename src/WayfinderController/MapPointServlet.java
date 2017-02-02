package WayfinderController;

import WayfinderDBController.WaypointDA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
 * Created by admin on 2/2/2017.
 */
@WebServlet(name = "MapPointServlet", urlPatterns = "/mapServlet")
public class MapPointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<String> waypointIDList = new ArrayList<String>();

        if(session.getAttribute("irc")==null)
        {
            String selR = request.getParameter("selectedRoute");

            if(selR.equalsIgnoreCase("accessRoute"))
            {
                waypointIDList = (ArrayList<String>) session.getAttribute("accessRouteString");
                session.setAttribute("selectedRoute", waypointIDList);
            }
            else
            {
                waypointIDList = (ArrayList<String>) session.getAttribute("bestRouteString");
                session.setAttribute("selectedRoute", waypointIDList);
            }

            waypointIDList.add("A1-001");
            waypointIDList.add("A1-003");
            waypointIDList.add("A1-005");session.setAttribute("selectedRoute", waypointIDList);

            ImageRenderController irc = new ImageRenderController();

            try
            {
                x = WaypointDA.getCoordinatesById(waypointIDList.get(0));
                irc.spawnWaypoints(waypointIDList);
                irc.spawnArrows(waypointIDList);
                irc.spawnCurrentIndicator(x.get(0), x.get(1));
            }catch (SQLException e){e.printStackTrace();}


            session.setAttribute("irc", irc);
            session.setAttribute("nextPoint", 1);
            System.out.println("Servlet Initial Map Spawn executed.");
            response.sendRedirect("html/WayfinderStep4.jsp");
        }
        else
        {
            ImageRenderController irc = (ImageRenderController) session.getAttribute("irc");
            waypointIDList = (ArrayList<String>) session.getAttribute("selectedRoute");
            int i = (Integer) session.getAttribute("nextPoint");
            String error = "";

            try
            {
                x = WaypointDA.getCoordinatesById(waypointIDList.get(i));
                System.out.println(waypointIDList.get(i) + " ID. Xcordinates: " + x.get(0));
                irc.spawnCurrentIndicator(x.get(0), x.get(1));
                error = request.getParameter("error");

            }catch (SQLException|NullPointerException e){e.printStackTrace();}

            if(error.equalsIgnoreCase("true"))
            {
                session.setAttribute("nextPoint", i);
                response.sendRedirect("html/WayfinderStep4.jsp");
                System.out.println("Error in MapPoint");
            }
            else
            {
                session.setAttribute("nextPoint", i+1);
                response.sendRedirect("html/WayfinderStep4.jsp");
                System.out.println("MapPoint executed");
            }

            System.out.println("Servlet Subsequent Spawn executed.");
        }
    }
}
