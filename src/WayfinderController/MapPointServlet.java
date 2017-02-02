package WayfinderController;

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
@WebServlet(name = "MapPointServlet", urlPatterns = "")
public class MapPointServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();

        if(session.getAttribute("irc")==null)
        {

            ArrayList<String> waypointIDList = new ArrayList<String>();
            String selR = request.getParameter("selectedRoute");

            if(selR.equalsIgnoreCase("accessRoute"))
            {
                session.setAttribute("selectedRoute", "accessRoute");
                waypointIDList = (ArrayList<String>) session.getAttribute("accessRouteString");
            }
            else
            {
                session.setAttribute("selectedRoute", "bestRoute");
                waypointIDList = (ArrayList<String>) session.getAttribute("bestRouteString");
            }

            ImageRenderController irc = new ImageRenderController();

            try
            {
                irc.spawnWaypoints(waypointIDList);
                irc.spawnArrows(waypointIDList);
                irc.spawnCurrentIndicator(200, 810);
            }catch (SQLException e){e.printStackTrace();}

            session.setAttribute("irc", irc);
            System.out.println("Servlet Origin Scan executed.");
            response.sendRedirect("html/WayfinderStep4.jsp");
        }
        else
        {

        }


        ImageRenderController irc = new ImageRenderController();
        RoutingController rc = new RoutingController();

        ArrayList<String> waypointIDList = rc.routeBest("A1-005", "A1-014");
        //irc.spawnWaypoints(waypointIDList);

        Scanner sc = new Scanner(System.in);
        //manual spawn current indicator on position 1 ( first position, which is point 5 in the routing result)
        irc.spawnCurrentIndicator(885, 810);
        System.out.print("Position 1 spawned, Position 2? (0/1): ");
        if(Integer.parseInt(sc.next()) == 1)
        {
            //manual spawn current image on position 2 ( second position, whic is point 4 in the routing result)
            irc.spawnCurrentIndicator(885, 550);
        }
        sc.nextLine();
        System.out.print("Position 2 spawned, Position 3? (0/1): ");
        if(Integer.parseInt(sc.next()) == 1)
        {
            irc.spawnCurrentIndicator(510, 810);
        }
        sc.nextLine();

        System.out.print("Spawn arrows? (0/1): ");
        if(Integer.parseInt(sc.next()) == 1)
        {
            //irc.spawnArrows(waypointIDList);
        }
    }
}
