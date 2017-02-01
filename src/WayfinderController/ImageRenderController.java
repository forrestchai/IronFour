package WayfinderController;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2/1/2017.
 */
public class ImageRenderController {
    private final static String BACKIMAGESRC = "originalMap.png";
    private final static String SPAWNABLESRC1 = "waypoint.png";
    private final static String SPAWNABLESRC2 = "knot.png";
    private final static String SPAWNABLESRC3 = "arrow.png";
    private final static String SPAWNABLESRC4 = "currentIndicator.png";
    private BufferedImage backImage;
    private BufferedImage waypoint;
    private BufferedImage knot;
    private BufferedImage arrow;
    private BufferedImage currentIndicator;



    public ImageRenderController()
    {
        this.setBackImage(null);
        this.setWaypoint(null);
        this.setArrow(null);
        this.setKnot(null);
        this.setCurrentIndicator(null);
        try
        {
            backImage = ImageIO.read(new File(this.getBACKIMAGESRC()));
            waypoint = ImageIO.read(new File(this.getSPAWNABLESRC1()));
            knot = ImageIO.read(new File(this.getSPAWNABLESRC2()));
            arrow = ImageIO.read(new File(this.getSPAWNABLESRC3()));
            currentIndicator = ImageIO.read(new File(this.getSPAWNABLESRC4()));


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

    public BufferedImage getArrow() {
        return arrow;
    }

    public void setArrow(BufferedImage arrow) {
        this.arrow = arrow;
    }

    public BufferedImage getKnot() {
        return knot;
    }

    public void setKnot(BufferedImage knot) {
        this.knot = knot;
    }

    public BufferedImage getCurrentIndicator() {
        return currentIndicator;
    }

    public void setCurrentIndicator(BufferedImage currentIndicator) {
        this.currentIndicator = currentIndicator;
    }

    public void spawnWaypoint(int offX, int offY) {
        System.out.println(offX + " " + offY);
        Graphics2D wp2d = backImage.createGraphics();
        wp2d.drawImage(this.getWaypoint(), offX, offY, null);
    }

    public void spawnKnot(int offX, int offY) {
        Graphics2D knot2d = backImage.createGraphics();
        knot2d.drawImage(this.getKnot(), offX, offY, null);
    }

    public void spawnArrow(int offX, int offY) {
        Graphics2D arrow2d = backImage.createGraphics();
        arrow2d.drawImage(this.getArrow(), offX, offY, null);
    }

    public void spawnCurrentIndicator(int offX, int offY) {
        Graphics2D ci2d = backImage.createGraphics();
        ci2d.drawImage(this.getCurrentIndicator(), offX, offY, null);
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
}
