package WayfinderDBController;

import WayfinderModel.Waypoint;
import wayfinder.db.DBController;
import WayfinderModel.Point;

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
        int pointX = myRs.getInt(3);
        int pointY = myRs.getInt(4);
        String listValue = myRs.getString(5);
        boolean access = myRs.getBoolean(6);
        double coeff = myRs.getDouble(7);
        int count = myRs.getInt(8);
        int feedbackAmt = myRs.getInt(9);
        String cpString = myRs.getString(10);

        return new Waypoint(id, name, pointX, pointY, listValue, access, coeff, count, feedbackAmt, cpString);
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

    public static ArrayList<Waypoint> getLandmarkWaypoints() throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint WHERE id LIKE 'A%';");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            waypointList.add(convertToWaypoint(myRs));
        }
        return waypointList;
    }

    public static ArrayList<Waypoint> getWardWaypoints() throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint WHERE id LIKE 'B%';");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            waypointList.add(convertToWaypoint(myRs));
        }
        return waypointList;
    }

    public static ArrayList<Waypoint> getDeptWaypoint() throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint WHERE id LIKE 'B%';");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            waypointList.add(convertToWaypoint(myRs));
        }
        return waypointList;
    }

    public static ArrayList<Waypoint> getWaypointById(String id) throws SQLException{
        ArrayList<Waypoint> waypointList = new ArrayList<Waypoint>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM waypoint WHERE id="+id+";");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            waypointList.add(convertToWaypoint(myRs));
        }
        return waypointList;
    }

    public static ArrayList<Point> getPointList() throws SQLException
    {
        ArrayList<Point> pointList = new ArrayList<Point>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM WAYPOINT WHERE ID NOT LIKE 'A1-02%';");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            pointList.add((Point)convertToWaypoint(myRs));
        }
        return pointList;
    }

    public static ArrayList<Point> getAccessPointList()throws SQLException
    {
        ArrayList<Point> accessPointList = new ArrayList<Point>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM WAYPOINT WHERE access = 1;");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            accessPointList.add((Point)convertToWaypoint(myRs));
        }
        for(Point p: accessPointList)
        {
            if(p.getId().equalsIgnoreCase("A1-002"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-020");
            }else if(p.getId().equalsIgnoreCase("A1-004"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-021");
            }else if(p.getId().equalsIgnoreCase("A1-007"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-020");
                p.getConnectedPointList().add("A1-021");
            }else if(p.getId().equalsIgnoreCase("A1-008"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-021");
            }else if(p.getId().equals("A1-010"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-020");
            }else if(p.getId().equals("A1-012"))
            {
                p.getConnectedPointList().clear();
                p.getConnectedPointList().add("A1-021");
            }
        }
        return accessPointList;
    }

    public static ArrayList<Point> getAccessBorderList()throws SQLException
    {
        ArrayList<Point> accessBorderList = new ArrayList<Point>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM WAYPOINT WHERE ACCESSBORDER = 1;");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            accessBorderList.add((Point)convertToWaypoint(myRs));
        }
        return accessBorderList;
    }

    public static ArrayList<Point> getUniversalPoints()throws SQLException
    {
        ArrayList<Point> universalPoints = new ArrayList<Point>();
        ArrayList<Waypoint> allPoints = getAllWaypoint();
        for(Waypoint wp: allPoints)
        {
            universalPoints.add((Point)wp);
        }

        return universalPoints;
    }
}
