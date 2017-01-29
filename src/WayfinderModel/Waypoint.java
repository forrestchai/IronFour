package WayfinderModel;

/**
 * Created by admin on 12/13/2016.../assets/
 */
public class Waypoint {
    String id;
    String name;
    double pointX;
    double pointY;
    String listValue;
    boolean access;
    double coeff;
    int count;
    int feedBackAmt;

    public Waypoint(String id, String name, double pointX, double pointY, String listValue, boolean access, double coeff, int count, int feedBackAmt) {
        this.id = id;
        this.name = name;
        this.pointX = pointX;
        this.pointY = pointY;
        this.listValue = listValue;
        this.access = access;
        this.coeff = coeff;
        this.count = count;
        this.feedBackAmt = feedBackAmt;
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

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
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
}
