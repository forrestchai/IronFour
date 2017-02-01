package WayfinderController;

import WayfinderDBController.WaypointDA;
import WayfinderModel.Point;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by User on 2/1/2017.
 */
public class RoutingController {
    private ArrayList<Point> pointList;
    private ArrayList<Point> accessPointList;
    private ArrayList<Point> accessBorderList;

    public RoutingController()
    {
        try
        {
            pointList = WaypointDA.getPointList();
            accessPointList = WaypointDA.getAccessPointList();
            accessBorderList = WaypointDA.getAccessBorderList();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
