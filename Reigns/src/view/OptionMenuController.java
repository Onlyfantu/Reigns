import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OptionMenuController implements MouseListener {

    private MainGUI mainGUI;
    private OptionMenuPanel optionMenuPanel;
    private boolean isFullScreen = false;

    public OptionMenuController(MainGUI mainGUI, OptionMenuPanel optionMenuPanel) {
        this.mainGUI = mainGUI;
        this.optionMenuPanel = optionMenuPanel;


        optionMenuPanel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (optionMenuPanel.getRect().contains(e.getPoint())) {
            if(isFullScreen == false){
                mainGUI.setFullScreen();
                isFullScreen = true;
                mainGUI.repaint();
                
            }
            else if(isFullScreen == true){
                mainGUI.exitFullScreen();
                isFullScreen = false;
                mainGUI.repaint();
                
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO: Implement
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO: Implement
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean getStatus() {
        return isFullScreen;
    }


}
