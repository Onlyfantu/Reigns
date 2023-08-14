import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

    private MyButton playButton;
    private MyButton optionButton; 
    private MyButton exitButton;

    private MyButtonController playButtonController;
    private MyButtonController optionButtonController;
    private MyButtonController exitButtonController;

    private final static String MENU_LOGO = "img/menu_logo.png";
    private BufferedImage img = null;

    public MenuPanel(MainGUI mainGUI){
        setBackground(Color.BLACK);
        loadImage(MENU_LOGO);

        // Create buttons
        playButton = new MyButton("Play");
        optionButton = new MyButton("Option"); 
        exitButton = new MyButton("Exit");
        
        // Make buttons interactive
        playButtonController = new MyButtonController(mainGUI, playButton);
        optionButtonController = new MyButtonController(mainGUI, optionButton);
        exitButtonController = new MyButtonController(mainGUI, exitButton);
        
        // Add buttons
        add(playButton);
        add(optionButton);
        add(exitButton);      
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set position and size of buttons
        setMenuButtons();
        
        // Background 
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();

        // Border
        g.setColor(Costants.lightBrown);
        g.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);

        // Image
        g.drawImage(img,(getWidth() - imgWidth)/2 , (getHeight()- imgHeight)/6, null);   

    }

    public void setMenuButtons(){

        int w = getWidth() / 5;
        int h = getHeight() / 20;
        
        int x = (getWidth() - w) / 2;
        int y = getHeight()/2;
    
        playButton.setBounds(x, y, w, h);
        optionButton.setBounds(x, y + getHeight() / 10, w, h);
        exitButton.setBounds(x, y + 2 * getHeight() / 10, w, h);
    }

    private void loadImage(String fileImage) {
        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
   
}
