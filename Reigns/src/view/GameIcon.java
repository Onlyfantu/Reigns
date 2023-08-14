import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameIcon extends JPanel {

    private JLabel returnToMenuLabel;
    private JLabel optionLabel;
    private JLabel exitLabel;

    private ImageIcon returnToMenuIcon;
    private ImageIcon optionIcon;
    private ImageIcon exitIcon;

    private MainGUI mainGUI;
    
    public GameIcon(MainGUI mainGUI) {
        setOpaque(false);
        this.mainGUI = mainGUI;
        
        initComponent();

        //Add label
        add(returnToMenuLabel);
        add(optionLabel);
        add(exitLabel);
              
    }

    public void initComponent() {
        returnToMenuIcon = new ImageIcon("img/back_icon.png");
        optionIcon = new ImageIcon("img/option_icon.png");
        exitIcon = new ImageIcon("img/exit_icon.png");

        //JLabel for icon
        returnToMenuLabel = new JLabel(returnToMenuIcon);
        exitLabel = new JLabel(exitIcon);
        optionLabel = new JLabel(optionIcon);

        // Aggiungi ascoltatori di eventi alle icone
        returnToMenuLabel.addMouseListener(new IconController(mainGUI, this));
        exitLabel.addMouseListener(new IconController(mainGUI, this));
        optionLabel.addMouseListener(new IconController(mainGUI, this));
 

    }

    public void setIconBounds(JPanel p){

        int distance = p.getWidth()/13;
        int x = p.getWidth() / 3 + p.getWidth()/14;
        int y = (p.getHeight() - p.getHeight() / 5) + p.getHeight() / 9;

        //Panel bounds
        setBounds(x, y, distance*4, returnToMenuIcon.getIconHeight());

        //Position
        returnToMenuLabel.setBounds(0, 0, returnToMenuIcon.getIconWidth(), returnToMenuIcon.getIconHeight());
        optionLabel.setBounds(distance, 0, optionIcon.getIconWidth(), optionIcon.getIconHeight());
        exitLabel.setBounds(2 * distance, 0, exitIcon.getIconWidth(), exitIcon.getIconHeight());
        
    }

    //------------------------------------------------------------------------
    // Getter 
    //------------------------------------------------------------------------

    public JLabel getBackIcon() {
        return returnToMenuLabel;
    }

    public JLabel getOptionIcon() {
        return optionLabel;
    }

    public JLabel getExitIcon() {
        return exitLabel;
    }

}