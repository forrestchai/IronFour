package WayfinderDBController;

import WayfinderModel.Waypoint;
import wayfinder.db.DBController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by admin on 12/13/2016.
 */
public class WaypointDA {

    public static Waypoint getWaypoint(String waypointId) throws SQLException {
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint WHERE id = '" + waypointId + "';");
        myRs = myStmt.executeQuery();
        myRs.next();
        return convertToWaypoint(myRs);
    }

    public static ArrayList<Waypoint> getWaypointList(ArrayList<String> idList)throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        for(int i=0; i<idList.size(); i++){
            waypointList.add(getWaypoint(idList.get(i)));
        }
        return waypointList;
    }

    public static Waypoint convertToWaypoint(ResultSet myRs) throws SQLException{
        String id = myRs.getString(1);
        String name = myRs.getString(2);
        double pointX = myRs.getDouble(3);
        double pointY = myRs.getDouble(4);
        String listValue = myRs.getString(5);
        boolean access = myRs.getBoolean(6);
        double coeff = myRs.getDouble(7);
        int count = myRs.getInt(8);
        int feedbackAmt = myRs.getInt(9);

        return new Waypoint(id, name, pointX, pointY, listValue, access, coeff, count, feedbackAmt);
    }

    public static ArrayList<Waypoint> getAllWaypoint() throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint;");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            waypointList.add(convertToWaypoint(myRs));
        }
        return waypointList;
    }
}
