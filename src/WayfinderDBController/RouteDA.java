package WayfinderDBController;

import WayfinderModel.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import WayfinderModel.Waypoint;
import wayfinder.db.DBController;

/**
 * Created by admin on 12/13/2016.
 */
public class RouteDA {

    public Route getRoute(String routeId) throws SQLException {
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM route WHERE id = '" + routeId + "';");
        myRs = myStmt.executeQuery();
        myRs.next();
        return convertToRoute(myRs);
    }

    public ArrayList<Route> getRouteList(ArrayList<String> idList)throws SQLException{
        ArrayList<Route> routeList = new ArrayList<Route>();
        for(int i=0; i<idList.size(); i++){
            System.out.println(idList.size() + " :TRUESIZE" );
            routeList.add(getRoute(idList.get(i)));
            System.out.println(routeList.size());
        }
        return routeList;
    }

    public static Route convertToRoute(ResultSet myRs) throws SQLException{
        String id = myRs.getString(1);
        String parentA = myRs.getString(2);
        System.out.println(parentA);
        String parentB = myRs.getString(3);
        boolean access = myRs.getBoolean(4);
        boolean avail = myRs.getBoolean(5);
        String desciption = myRs.getString(6);
        System.out.println(desciption);

        return new Route(id, parentA, parentB, access, avail, desciption);
    }

    public static ArrayList<Route> getAllRoute() throws SQLException{
        ArrayList<Route> routeList = new ArrayList<Route>();
        DBController dbController = new DBController();
        Connection myConn = dbController.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        myStmt = myConn.prepareStatement("SELECT * FROM route;");
        myRs = myStmt.executeQuery();
        while(myRs.next())
        {
            routeList.add(convertToRoute(myRs));
        }
        return routeList;
    }

}
