import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    // Static constant
    private final static int BORDER_RADIUS = 30;

    private final static String GAMEPANEL_BACKGROUND = "img/background.png";

    // Instance fields
    private BufferedImage img = null;

    private TextEventPanel textEvent;
    private PowerIconPanel powerIcon;

    private Cards gameCards;
    private MainGUI mainGUI;
    private StartCard startCard;

    private GameIcon menuIcon;            

    public GamePanel(MainGUI mainGUI) {
        super();
        this.mainGUI = mainGUI;
        loadImage(GAMEPANEL_BACKGROUND);
        
        initComponents();
              
    } 

    private void initComponents() {
        textEvent = new TextEventPanel();
        powerIcon = new PowerIconPanel();
        menuIcon = new GameIcon(mainGUI);
        startCard = new StartCard();

        add(textEvent);
        add(powerIcon);
        add(menuIcon);
        add(startCard);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna il background
        drawBackground(g);

        // Aggiorna le dimensioni e la posizione dei componenti
        updateComponentBounds();
    }

    public void drawBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Image
        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        // Central rect
        g2d.setColor(Costants.lightBrown);
        g2d.fillRect(getWidth() / 3, 0, getWidth() / 3, getHeight());
 
        // Top rect
        g2d.setColor(Costants.brown);
        g2d.fillRect(getWidth() / 3, 0, getWidth() / 3, getHeight() / 6);
 
        // Below rect
        g2d.setColor(Costants.brown);
        g2d.fillRect(getWidth() / 3, (getHeight() - getHeight() / 5) + getHeight() / 12 , getWidth() / 3, (getHeight() / 5) );
 
        // Border
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);
 
        // Background card
        drawBackgroundCard(g2d);
    }

    public void drawBackgroundCard(Graphics2D g2d) {
        int xCard = getWidth()/3 + getWidth()/29;
        int yCard = getHeight()/2 - getHeight()/7;
        int cardWidth = getWidth()/3 - 2 *(xCard - getWidth()/3);
        int cardHeight = getHeight() - getHeight()/2 - getHeight()/30;

        g2d.setColor(Costants.brown);
        g2d.fillRoundRect(xCard, yCard, cardWidth, cardHeight, BORDER_RADIUS, BORDER_RADIUS);
    }


    public void updateComponentBounds() {
        // Posiziona i componenti come desiderato
        textEvent.setBounds(0, 0, getWidth(), getHeight());
        powerIcon.setIconBounds(this);
        menuIcon.setIconBounds(this);
        startCard.setBounds(0, 0, getWidth(), getHeight());
    }

    // Load the background image from a file
    private void loadImage(String fileImage) {
        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
