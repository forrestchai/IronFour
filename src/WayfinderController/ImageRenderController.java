package WayfinderController;
import WayfinderDBController.WaypointDA;
import WayfinderModel.Point;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 2/1/2017.
 */
public class ImageRenderController {
    private final static String BACKIMAGESRC = "originalMap.png";
    private final static String SPAWNABLESRC1 = "waypoint.png";
    private final static String SPAWNABLESRC2 = "north.png";
    private final static String SPAWNABLESRC3 = "south.png";
    private final static String SPAWNABLESRC4 = "east.png";
    private final static String SPAWNABLESRC5 = "west.png";
    private final static String SPAWNABLESRC6 = "currentIndicator.png";
    private BufferedImage backImage;
    private BufferedImage waypoint;
    private BufferedImage north;
    private BufferedImage south;
    private BufferedImage east;
    private BufferedImage west;
    private BufferedImage currentIndicator;
    private int previousCurrentX;
    private int previousCurrentY;



    public ImageRenderController()
    {
        this.setBackImage(null);
        this.setWaypoint(null);
        this.setNorth(null);
        this.setSouth(null);
        this.setEast(null);
        this.setWest(null);
        this.setCurrentIndicator(null);
        this.setPreviousCurrentX(-1);
        this.setPreviousCurrentY(-1);
        try
        {
            backImage = ImageIO.read(new File(this.getBACKIMAGESRC()));
            waypoint = ImageIO.read(new File(this.getSPAWNABLESRC1()));
            north = ImageIO.read(new File(this.getSPAWNABLESRC2()));
            south = ImageIO.read(new File(this.getSPAWNABLESRC3()));
            east = ImageIO.read(new File(this.getSPAWNABLESRC4()));
            west = ImageIO.read(new File(this.getSPAWNABLESRC5()));
            currentIndicator = ImageIO.read(new File(this.getSPAWNABLESRC6()));


        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public static String getBACKIMAGESRC() {
        return BACKIMAGESRC;
    }

    public static String getSPAWNABLESRC1() {
        return SPAWNABLESRC1;
    }

    public static String getSPAWNABLESRC2() {
        return SPAWNABLESRC2;
    }

    public static String getSPAWNABLESRC3() {
        return SPAWNABLESRC3;
    }

    public static String getSPAWNABLESRC4() {
        return SPAWNABLESRC4;
    }

    public static String getSPAWNABLESRC5() {
        return SPAWNABLESRC5;
    }

    public static String getSPAWNABLESRC6() {
        return SPAWNABLESRC6;
    }

    public int getPreviousCurrentX() {
        return previousCurrentX;
    }

    public void setPreviousCurrentX(int previousCurrentX) {
        this.previousCurrentX = previousCurrentX;
    }

    public int getPreviousCurrentY() {
        return previousCurrentY;
    }

    public void setPreviousCurrentY(int previousCurrentY) {
        this.previousCurrentY = previousCurrentY;
    }

    public BufferedImage getBackImage() {
        return backImage;
    }

    public void setBackImage(BufferedImage backImage) {
        this.backImage = backImage;
    }

    public BufferedImage getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(BufferedImage waypoint) {
        this.waypoint = waypoint;
    }

    public BufferedImage getNorth() {
        return north;
    }

    public void setNorth(BufferedImage north) {
        this.north = north;
    }

    public BufferedImage getSouth() {
        return south;
    }

    public void setSouth(BufferedImage south) {
        this.south = south;
    }

    public BufferedImage getEast() {
        return east;
    }

    public void setEast(BufferedImage east) {
        this.east = east;
    }

    public BufferedImage getWest() {
        return west;
    }

    public void setWest(BufferedImage west) {
        this.west = west;
    }

    public BufferedImage getCurrentIndicator() {
        return currentIndicator;
    }

    public void setCurrentIndicator(BufferedImage currentIndicator) {
        this.currentIndicator = currentIndicator;
    }

    public void spawnWaypoint(int offX, int offY) {
        Graphics2D wp2d = backImage.createGraphics();
        wp2d.drawImage(this.getWaypoint(), offX - this.getWaypoint().getWidth()/2, offY - this.getWaypoint().getHeight()/2, null);
        updateGeneratedImage();
    }

    public void spawnNorth(int offX, int offY, int height) {
        Graphics2D n2d = backImage.createGraphics();
        n2d.drawImage(this.getNorth(), offX, offY, this.getNorth().getWidth(), height, null);
        updateGeneratedImage();

    }

    public void spawnSouth(int offX, int offY, int height) {
        Graphics2D s2d = backImage.createGraphics();
        s2d.drawImage(this.getSouth(), offX, offY, this.getSouth().getWidth(), height, null);
        updateGeneratedImage();
    }

    public void spawnEast(int offX, int offY, int width) {
        Graphics2D e2d = backImage.createGraphics();
        e2d.drawImage(this.getEast(), offX, offY, width, this.getEast().getHeight(), null);
        updateGeneratedImage();
    }

    public void spawnWest(int offX, int offY, int width) {
        Graphics2D w2d = backImage.createGraphics();
        w2d.drawImage(this.getWest(), offX, offY, width, this.getWest().getHeight(), null);
        updateGeneratedImage();
    }

    public void spawnCurrentIndicator(int offX, int offY) {
        if(this.getPreviousCurrentX() != -1 && this.getPreviousCurrentY() != -1)
        {
            this.spawnWaypoint(this.getPreviousCurrentX(), this.getPreviousCurrentY());
        }
        Graphics2D ci2d = backImage.createGraphics();
        ci2d.drawImage(this.getCurrentIndicator(), offX - this.getCurrentIndicator().getWidth()/2, offY - this.getCurrentIndicator().getHeight()/2, null);
        this.setPreviousCurrentX(offX);
        this.setPreviousCurrentY(offY);
        updateGeneratedImage();
    }

    public void spawnWaypoints(ArrayList<String> idList) throws SQLException
    {
        ArrayList<Integer> offXList = new ArrayList<Integer>();
        ArrayList<Integer> offYList = new ArrayList<Integer>();
        ArrayList<Point> points = new ArrayList<Point>();

        for(String id: idList)
        {
            points.add((Point) WaypointDA.getWaypoint(id));
        }

        for(Point p: points)
        {
            offXList.add((int)p.getOffX());
            offYList.add((int)p.getOffY());
        }
        for(int i = 0; i < offXList.size(); i++)
        {
            spawnWaypoint(offXList.get(i), offYList.get(i));
        }

    }

    public void spawnArrows(ArrayList<String> idList)throws SQLException
    {
        ArrayList<Integer> offXList = new ArrayList<Integer>();
        ArrayList<Integer> offYList = new ArrayList<Integer>();
        ArrayList<Point> points = new ArrayList<Point>();

        for(String id: idList)
        {
            points.add((Point) WaypointDA.getWaypoint(id));
        }
        for(Point p: points)
        {
            offXList.add((int)p.getOffX());
            offYList.add((int)p.getOffY());
        }
    }

    public void updateGeneratedImage()
    {
        try
        {
            File output = new File("generatedMap.png");
            ImageIO.write(this.getBackImage(), "png", output);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[]args) throws SQLException
    {
        ImageRenderController irc = new ImageRenderController();
        RoutingController rc = new RoutingController();

        ArrayList<String> waypointIDList = rc.routeBest("A1-005", "A1-014");
        irc.spawnWaypoints(waypointIDList);

        Scanner sc = new Scanner(System.in);
        //manual spawn current indicator on position 1 ( first position, which is point 5 in the routing result)
        irc.spawnCurrentIndicator(885, 810);
        System.out.print("Position 1 spawned, Position 2? (0/1): ");
        if(Integer.parseInt(sc.next()) == 1)
        {
            //manual spawn current image on position 2 ( second position, whic is point 4 in the routing result)
            irc.spawnCurrentIndicator(695, 810);
        }
        sc.nextLine();
        System.out.print("Position 2 spawned, Position 3? (0/1): ");
        if(Integer.parseInt(sc.next()) == 1)
        {
            irc.spawnCurrentIndicator(510, 810);
        }
        sc.nextLine();

        System.out.print("Spawn arrows? (0/1): ");


    }
}
