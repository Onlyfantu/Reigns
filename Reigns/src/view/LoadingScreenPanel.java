import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameState;

public class LoadingScreenPanel extends JPanel {

    private final static String LOADINGSCREEN_LOGO = "img/menu_logo.png";
    private final static String[] menuString = {"Building the castle...", "Handing out the cards...", "Forging alliances...", "Preparing the throne for the ruler..."};

    private JLabel loadingLabel;

    private BufferedImage img = null;
    private MainGUI mainGUI;
    private Timer timer;
    private int TIME = 10000;
    private Random random;
    private int randomNumber;

    public LoadingScreenPanel(MainGUI mainGUI) {
        super();
        setBackground(Color.BLACK);
        loadImage(LOADINGSCREEN_LOGO);

        this.mainGUI = mainGUI;
        random = new Random();
        randomNumber = random.nextInt(4);
        
        initLabel();
        add(loadingLabel);
        
        startTimer();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                showMenuPanel();
            }
        };
        timer = new Timer();
        timer.schedule(task, TIME);
    }

    public void showMenuPanel() {
        timer.cancel();
        mainGUI.changeGameState(GameState.MENU);
    }

    public void initLabel() {
        loadingLabel = new JLabel();
        loadingLabel.setText(menuString[randomNumber]);
        loadingLabel.setForeground(Costants.lightBrown);
        loadingLabel.setFont(Costants.medievalFont);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Label
        FontMetrics fontMetrics = g.getFontMetrics(getFont());
        loadingLabel.setBounds(getWidth() / 2 - fontMetrics.stringWidth(menuString[randomNumber]) / 2 - 10, 160, getWidth(), getHeight());
        
        // Image
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight(); 
        g.drawImage(img,(getWidth() - imgWidth)/2 , (getHeight()- imgHeight)/2, null);

        // Border
        g.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);

        // Border
        g.setColor(Costants.gold);
        g.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);
           
    }

    private void loadImage(String fileImage) {
        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

