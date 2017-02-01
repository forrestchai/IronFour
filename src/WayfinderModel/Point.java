package WayfinderModel;

import java.util.ArrayList;

/**
 * Created by admin on 1/31/2017.
 */
public class Point {
    private String id;
    private double offX;
    private double offY;
    private boolean access;
    private ArrayList<String> connectedPointList;

    public Point()
    {

    };

    public Point(String id, double offX, double offY, boolean access)
    {
        this.setId(id);
        this.setOffX(offX);
        this.setOffY(offY);
        this.setAccess(access);
    }

    public ArrayList<String> getConnectedPointList() {
        return connectedPointList;
    }

    public void setConnectedPointList(ArrayList<String> connectedPointList) {
        this.connectedPointList = connectedPointList;
    }

    public double getOffX() {
        return offX;
    }

    public void setOffX(double offX) {
        this.offX = offX;
    }

    public double getOffY() {
        return offY;
    }

    public void setOffY(double offY) {
        this.offY = offY;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance(String id1, String id2)
    {
        double distance = 0;

        return distance;
    }
}
