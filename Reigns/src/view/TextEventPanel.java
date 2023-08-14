import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEventPanel extends JPanel {

    private String startTxt = "Welcome to our Kingdom! I understand that you are new but it's very simple: you have to keep the balance between the powers. Clear?";
    private JTextArea messageArea;

    public TextEventPanel() {
        setLayout(null);
        setOpaque(false);

        // Create and configure a JTextArea
        messageArea = new JTextArea(startTxt);
        messageArea.setBackground(Costants.lightBrown);
        messageArea.setFont(Costants.medievalFontPlain);
        messageArea.setForeground(Costants.brown);
        messageArea.setLineWrap(true); // Abilita l'avvolgimento del testo
        messageArea.setWrapStyleWord(true); // Avvolgi il testo alla fine di una parola
        messageArea.setEditable(false); // Impedisci la modifica del testo
        messageArea.setFocusable(false);
 
        // Add the JTextArea to this panel
        add(messageArea);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setTextBounds();
    }

    public void setTextBounds() {
        int xTextArea = getWidth() / 3 + 30;
        int yTextArea = getHeight() / 6 + 20;
        int wTextArea = getWidth() / 3 - 2 * 30;
        int hTextArea = getHeight() / 7;

        messageArea.setBounds(xTextArea, yTextArea, wTextArea, hTextArea);
    }
}
