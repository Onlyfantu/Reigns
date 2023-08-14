import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.FontMetrics;
import javax.swing.JPanel;

public class OptionMenuPanel extends JPanel {

    private static final String OPTION_TEXT = "Option"; 
    private static final String FULLSCREEN_TEXT = "Full Screen"; 
    private static final String SOUND_TEXT = "Sound"; 
    private static final String SOUNDEFFECT_TEXT = "Effect Sound";

    private MyButton returnToMenuButton;
    private MyButton howToPlayButton;
    private MyButton highScoresButton;

    private MainGUI mainGUI;

    private MyButtonController returnToMenuButtonController;
    private MyButtonController howToPlayButtonController;
    private MyButtonController highScoresButtonController;

    private OptionMenuController optionMenuController;

    private Rectangle rect;

    private boolean mouseOver;

    public OptionMenuPanel(MainGUI mainGUI) {
        super();
        this.mainGUI = mainGUI;
        setBackground(Color.BLACK);
        
        // Init button
        returnToMenuButton = new MyButton("Back");
        howToPlayButton = new MyButton("How to play?");
        highScoresButton = new MyButton("High Scores");

        // Make buttons interactive
        returnToMenuButtonController = new MyButtonController(mainGUI, returnToMenuButton);
        howToPlayButtonController = new MyButtonController(mainGUI, howToPlayButton);
        highScoresButtonController = new MyButtonController(mainGUI, highScoresButton);

        optionMenuController = new OptionMenuController(mainGUI, this);

        add(howToPlayButton);
        add(highScoresButton);
        add(returnToMenuButton);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fontMetrics = g.getFontMetrics(getFont());
        
        //-------------------------------------------------------------------
        // BACKGROUND PAINT
        //--------------------------------------------------------------------

        g.setColor(Costants.gold);
        g.drawRect(getWidth()/3, 1, getWidth()/3, getHeight() - 3);

        g.setColor(Costants.brown);
        g.fillRect(getWidth()/3 + 1, 2, getWidth()/3 - 1, getHeight() - 4);

        g.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);

        //--------------------------------------------------------------------
        // COMPONENT PAINT
        //--------------------------------------------------------------------
        // Da Modificare 
        
        // TITLE STRING
        g.setColor(Costants.lightBrown);
        g.setFont(Costants.medievalFont);
        g.drawString(OPTION_TEXT, getWidth()/2 - fontMetrics.stringWidth(OPTION_TEXT), getHeight()/20);

        // FULL SCREEN
        g.setFont(Costants.medievalFontPlain);
        g.drawString(FULLSCREEN_TEXT, getWidth()/3 + fontMetrics.stringWidth(FULLSCREEN_TEXT) / 2, getHeight() / 5);
        if(optionMenuController.getStatus() == true){
            g.fillRect(getWidth() / 2, getHeight() / 7 + getHeight()/32, getWidth()/ 50 , getWidth() / 50);
            repaint();
        }
        else {
           g.drawRect(getWidth() / 2, getHeight() / 7 + getHeight()/32, getWidth()/ 50 , getWidth() / 50);
           repaint();
        }
         
        
        // SOUND
        g.drawString(SOUND_TEXT, getWidth() / 3 + fontMetrics.stringWidth(FULLSCREEN_TEXT) / 2, getHeight() / 3);
        g.drawRect(getWidth() / 2, getHeight() / 4 + getHeight() / 16 , getWidth()/ 7, getHeight() / 30);

        // EFFECT SOUND
        g.drawString(SOUNDEFFECT_TEXT, getWidth() / 3+ fontMetrics.stringWidth(FULLSCREEN_TEXT) / 2, getHeight() / 3 + getHeight()/7);
        g.drawRect(getWidth() / 2, getHeight() / 2 - getHeight() / 19  , getWidth()/ 7, getHeight() / 30);

        // BUTTON BOUNDS
        int w = getWidth() / 5;
        int h = getHeight() / 20;

        highScoresButton.setBounds(getWidth() / 2 - w / 2, getHeight() / 3 + getHeight() / 4, w, h);
        howToPlayButton.setBounds(getWidth() / 2 - w / 2, getHeight() / 3 + getHeight() / 3 + getHeight() / 20, w , h);
        returnToMenuButton.setBounds(getWidth() / 3 + getWidth() / 25, getHeight() / 2 + getHeight() / 3 + getHeight() / 20, getWidth() / 10, getHeight() / 20);

    }

    public Rectangle getRect() {
        return rect = new Rectangle(getWidth() / 2, getHeight() / 7 + getHeight()/32, getWidth()/ 50 , getWidth() / 50);
    }

    public void changeStatus(boolean b) {
        mouseOver = b;
    }

}