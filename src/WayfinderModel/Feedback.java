package WayfinderModel;

/**
 * Created by admin on 12/13/2016.
 */
public class Feedback {
    String id;
    String routeId;
    String waypointId;
    String feedback;
    int accessible;
    int available;

    public Feedback(String id, String routeId, String waypointId, String feedback, int accessible, int available) {
        this.id = id;
        this.routeId = routeId;
        this.waypointId = waypointId;
        this.feedback = feedback;
        this.accessible = accessible;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getWaypointId() {
        return waypointId;
    }

    public void setWaypointId(String waypointId) {
        this.waypointId = waypointId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getAccessible() {
        return accessible;
    }

    public void setAccessible(int accessible) {
        this.accessible = accessible;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
