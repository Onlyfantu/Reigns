import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CustomDialog extends JDialog {

    public CustomDialog(MainGUI mainGUI, String title, String txt) {
        super(mainGUI, title, true);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Costants.brown);
        contentPane.setLayout(null);
        
        // Create and configure a JTextArea
        JTextArea messageArea = new JTextArea(txt);
        messageArea.setBackground(Costants.brown);
        messageArea.setFont(Costants.medievalFontPlain);
        messageArea.setForeground(Costants.gold);
        messageArea.setLineWrap(true); // Abilita l'avvolgimento del testo
        messageArea.setWrapStyleWord(true); // Avvolgi il testo alla fine di una parola
        messageArea.setEditable(false); // Impedisci la modifica del testo
        messageArea.setFocusable(false);
        messageArea.setBounds(20, 20, 350, 100); // Imposta le dimensioni e la posizione del JTextArea
        
        // Add the JTextArea to the content pane
        contentPane.add(messageArea);

        // Add the content pane to the dialog
        setContentPane(contentPane);

        // Set dimensions & center the dialog
        setSize(400, 200);
        setLocationRelativeTo(mainGUI);
    }
}


