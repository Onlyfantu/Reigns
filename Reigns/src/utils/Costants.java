import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Costants {

    // Color
    public static final Color brown = new Color(35, 20, 3);
    public static final Color gold = new Color(195, 166, 90);
    public static final Color lightBrown = new Color(189, 168, 103);
    public static final Color blackTransparent = new Color(0, 0, 0, 128);

    // Font 
    public static final Font medievalFont = new Font("Gabriola", Font.BOLD, 24);
    public static final Font medievalFontPlain = new Font("Gabriola", Font.PLAIN, 20);
    public static final Font buttonFont = new Font("Gabriola", Font.PLAIN, 20);

    // Dim Panel
    public static final int DEFAULT_WIDTH = 1280;
    public static final int DEFAULT_HEIGHT = 720;
       
    public static void loadImage(String fileImage, BufferedImage img) {
        try {
            img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}




