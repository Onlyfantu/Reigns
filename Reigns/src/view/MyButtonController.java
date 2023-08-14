import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.GameState;

public class MyButtonController implements MouseListener {
    private MainGUI mainGUI;
    private MyButton myButton;
    private CustomDialog dialog;

    public MyButtonController(MainGUI mainGUI, MyButton myButton) {
        this.mainGUI = mainGUI;
        this.myButton = myButton;

        myButton.addMouseListener(this);

        dialog = new CustomDialog(mainGUI, "Welcome to Reings", "In this game you can make decisions by clicking the mouse left or right.\nGood Game");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1){ // only works with the left button
            // MAIN BUTTON CONTROLLER
            if (myButton.getTxt().equals("Play")) {
                mainGUI.changeGameState(GameState.PLAY);
                dialog.setVisible(true);

            } 
            else if (myButton.getTxt().equals("Option")) {
                mainGUI.changeGameState(GameState.SETTINGS);                     
            } 
            else if (myButton.getTxt().equals("Exit")) { 
                System.exit(0);
            }
            
            // OPTION BUTTON CONTROLLER
            else if (myButton.getTxt().equals("Back")) { // Da modificare --> deve ritornare lo stato precedente
                mainGUI.changeGameState(GameState.MENU); 
            }
            else if(myButton.getTxt().equals("How to play?")) {
                mainGUI.changeGameState(GameState.HOWTOPLAY);
            }
            else if(myButton.getTxt().equals("Return to Option")) {
                mainGUI.changeGameState(GameState.SETTINGS);
            }
      
            // DIALOG BUTTON CONTROLLER
            else if (myButton.getTxt().equals("Yes")) {
                mainGUI.changeGameState(GameState.MENU);
                mainGUI.closeActiveWindow();
            } else if (myButton.getTxt().equals("No")) {  
                mainGUI.closeActiveWindow();
            } 
    

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
        myButton.setMouseOver(true); 
        myButton.repaint(); 
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        myButton.setMouseOver(false); 
        myButton.repaint();        
    
    }
}

