import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HowToPlayPanel extends JPanel {

    private JTextArea description;
    private MyButton returnToOption;
    private MyButtonController returnToOptionController;
    private MainGUI mainGUI;
    private JScrollPane scrollPane;


    
    public HowToPlayPanel(MainGUI mainGUI) {

        this.mainGUI = mainGUI;

        setBackground(Color.BLACK);

        returnToOption = new MyButton("Return to Option");
        returnToOptionController = new MyButtonController(mainGUI, returnToOption);

        description = new JTextArea();
        description.setText("\nBenvenuto nel mondo di Reigns!\n\n" + 
                "Il tuo obiettivo é mantenerti sul trono il più a lungo possibile," + 
                "bilanciando con saggezza i diversi poteri.\n" + //
                "\n" + //
                "Regole del gioco:\n" + //
                "\n" + //
                "Le carte degli eventi appariranno una alla volta nella parte superiore dello schermo. Leggi attentamente ciascuna carta e fai la tua scelta selezionando da quattro opzioni disponibili.\r\n" + //
                "\n" + //
                "Le tue decisioni avranno conseguenze. Presta attenzione ai simboli nella parte superiore della schermata per capire come le tue scelte influenzeranno quattro aspetti chiave: Chiesa, Popolo, Militari e Tesoreria.\r\n" + //
                "\n" + //
                "Mantieni l'equilibrio: assicurati di non far abbassare troppo nessuna delle quattro barre rappresentanti gli aspetti del regno.\n" + //
                "\r\n" + //
                "Longevità sul trono: Il tuo obiettivo è mantenerti il più9 a lungo possibile come sovrano.\r\n" + //
                "\r\n" + //
                "Buona fortuna, nobile sovrano!"
            );

        description.setFont(Costants.medievalFontPlain);
        description.setForeground(Costants.lightBrown);
        description.setLineWrap(true); // Imposta il wrapping automatico del testo
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setEditable(false);
        description.setFocusable(false);

        scrollPane = new JScrollPane(description);
        
        add(description);
        add(returnToOption);
    }  

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Central 
        g.setColor(Costants.gold);
        g.drawRect(getWidth()/3, 1, getWidth()/3, getHeight() - 2);

        g.setColor(Costants.brown);
        g.fillRect(getWidth()/3 + 1, 2, getWidth()/3 - 1, getHeight() - 4);

        g.drawRect(0, 0 , getWidth() - 1, getHeight() - 1);

        description.setBounds(getWidth()/3 + 50, 1, getWidth()/3 - getWidth()/ 16, getHeight() - 120);

        returnToOption.setBounds(getWidth() / 3 + getWidth() / 25, getHeight() / 2 + getHeight() / 3 + getHeight() / 20, getWidth() / 10, getHeight() / 20);
        //scrollPane.setBounds(getWidth()/2 + getWidth()/ 7, 30, 35, getHeight() - 150);

    }
    
    
}
    