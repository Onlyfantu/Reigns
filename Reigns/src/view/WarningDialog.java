import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WarningDialog extends JDialog{
    private MyButton yesButton;
    private MyButton noButton;
    
    private MyButtonController yesButtonController;
    private MyButtonController noButtonController;
   

    public WarningDialog(MainGUI mainGUI,String title, String txt) {
        super(mainGUI, title, true);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Costants.brown);
        contentPane.setLayout(null); 

        // Add message
        JLabel messageLabel = new JLabel(txt);
        messageLabel.setFont(Costants.medievalFontPlain);
        messageLabel.setBounds(20, 20, 350, 30);
        messageLabel.setForeground(Costants.gold);
        contentPane.add(messageLabel);
        
        // Aggiungi pulsanti personalizzati
        yesButton = new MyButton("Yes");
        noButton = new MyButton("No");

        yesButton.setBounds(40, 70, 80, 30);
        noButton.setBounds(140, 70, 80, 30);

        yesButtonController = new MyButtonController(mainGUI, yesButton);
        noButtonController = new MyButtonController(mainGUI, noButton);

        contentPane.add(yesButton);
        contentPane.add(noButton);

        // Add panel
        setContentPane(contentPane);

        // Set dim & center the dialog
        setSize(250, 150);
        setLocationRelativeTo(mainGUI); 
    }
}
