import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.GameState;

public class IconController implements MouseListener {
    private MainGUI mainGUI;
    private GameIcon gameIcon;
    private WarningDialog dialog;

    public IconController(MainGUI mainGUI, GameIcon gameIcon) {
        this.mainGUI = mainGUI;
        this.gameIcon = gameIcon;

        dialog = new WarningDialog(mainGUI, "Warning", "Are you sure to return to menu?");
        
        gameIcon.addMouseListener(this);
    } 


    public WarningDialog getDialog() {
        return dialog;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == gameIcon.getBackIcon()) {
            dialog.setVisible(true);
        } else if (e.getSource() == gameIcon.getExitIcon()) {
            System.exit(0);
        } else if (e.getSource() == gameIcon.getOptionIcon()) {
            mainGUI.changeGameState(GameState.SETTINGS);
        }
    }
        

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
            
    
    }
}

