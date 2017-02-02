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
import java.util.ArrayList;
import java.util.Scanner;

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
//
//            if(selR.equalsIgnoreCase("accessRoute"))
//            {
//                session.setAttribute("selectedRoute", "accessRoute");
//                waypointIDList = (ArrayList<String>) session.getAttribute("accessRouteString");
//            }
//            else
//            {
//                session.setAttribute("selectedRoute", "bestRoute");
//                waypointIDList = (ArrayList<String>) session.getAttribute("bestRouteString");
//            }
            waypointIDList.add("A1-001");
            waypointIDList.add("A1-003");
            waypointIDList.add("A1-005");


            ImageRenderController irc = new ImageRenderController();

            for(int i=0; i<waypointIDList.size(); i++)
            {
                System.out.println("STUFF "+waypointIDList.get(i));
            }

            try
            {
                x = WaypointDA.getCoordinatesById(waypointIDList.get(0));
                irc.spawnWaypoints(waypointIDList);
                irc.spawnArrows(waypointIDList);
                irc.spawnCurrentIndicator(x.get(0), x.get(1));
            }catch (SQLException e){e.printStackTrace();}

            session.setAttribute("irc", irc);
            session.setAttribute("currentPoint", 0);
            System.out.println("Servlet Initial Map Spawn executed.");
            response.sendRedirect("html/WayfinderStep4.jsp");
        }
        else
        {
            ImageRenderController irc = (ImageRenderController) session.getAttribute("irc");
            waypointIDList = (ArrayList<String>) session.getAttribute("selectedRoute");
            int i = Integer.parseInt((String) session.getAttribute("currentPoint"));

            try
            {
                x = WaypointDA.getCoordinatesById(waypointIDList.get(i));
                irc.spawnCurrentIndicator(x.get(0), x.get(1));
            }catch (SQLException e){e.printStackTrace();}

            if(request.getParameter("error").equalsIgnoreCase("true"))
                session.setAttribute("currentPoint", i);
            else
                session.setAttribute("currentPoint", i+1);

            System.out.println("Servlet Subsequent Spawn executed.");
            response.sendRedirect("html/WayfinderStep4.jsp");
        }
    }
}
