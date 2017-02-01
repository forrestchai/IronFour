package WayfinderController;

import WayfinderDBController.WaypointDA;
import WayfinderModel.Point;
import WayfinderModel.Route;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by User on 2/1/2017.
 */
public class RoutingController {
    private ArrayList<Point> pointList;
    private ArrayList<Point> accessPointList;
    private ArrayList<Point> accessBorderList;
    private ArrayList<Point> universalPoints;

    public RoutingController()
    {
        try
        {
            pointList = WaypointDA.getPointList();
            accessPointList = WaypointDA.getAccessPointList();
            accessBorderList = WaypointDA.getAccessBorderList();
            universalPoints = WaypointDA.getUniversalPoints();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> route(String start, String dest)
    {
        ArrayList<String> routingResult = new ArrayList<String>();
        Route r = new Route(start, dest);
        r.set

        return routingResult;
    }
}
