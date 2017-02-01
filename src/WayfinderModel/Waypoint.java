package WayfinderModel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 12/13/2016.../assets/
 */
public class Waypoint extends Point{
    String id;
    String name;
    double offX;
    double offY;
    String listValue;
    boolean access;
    double coeff;
    int count;
    int feedBackAmt;
    String cpString;

    public Waypoint(String id, String name, double offX, double offY, String listValue, boolean access, double coeff, int count, int feedBackAmt, String cpString) {
        this.id = id;
        this.name = name;
        this.offX = offX;
        this.offY = offY;
        this.listValue = listValue;
        this.access = access;
        this.coeff = coeff;
        this.count = count;
        this.feedBackAmt = feedBackAmt;
        this.cpString = cpString;
        this.setConnectedPointList(this.cpString);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFeedBackAmt() {
        return feedBackAmt;
    }

    public void setFeedBackAmt(int feedBackAmt) {
        this.feedBackAmt = feedBackAmt;
    }

    public void setConnectedPointList(String cpString)
    {
        ArrayList<String> connectedPointList = new ArrayList<String>();
        Scanner sc = new Scanner(cpString);
        sc.useDelimiter(";");
        while(sc.hasNext())
        {
            connectedPointList.add(sc.next());
        }
        this.setConnectedPointList(connectedPointList);
    }
}
