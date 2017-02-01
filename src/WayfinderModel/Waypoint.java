package WayfinderModel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 12/13/2016.../assets/
 */
public class Waypoint extends Point{
    String name;
    String listValue;
    double coeff;
    int count;
    int feedBackAmt;
    String cpString;

    public Waypoint(String id, String name, int offX, int offY, String listValue, boolean access, double coeff, int count, int feedBackAmt, String cpString) {
        super(id, offX, offY, access);
        this.name = name;
        this.listValue = listValue;
        this.coeff = coeff;
        this.count = count;
        this.feedBackAmt = feedBackAmt;
        this.cpString = cpString;
        this.setConnectedPointList(this.cpString);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
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
