import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameState;

public class MainGUI extends JFrame {

    private JPanel cardsPanel;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private OptionMenuPanel optionMenuPanel;
    private LoadingScreenPanel loadingScreenPanel;
    private HowToPlayPanel howToPlayPanel;
    
    private Audio backgroundMusic;

    public MainGUI() {
        super("Reigns");
        this.setPreferredSize(new Dimension(Costants.DEFAULT_WIDTH, Costants.DEFAULT_HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true); // Removes the window border
        addLogo();

        cardsPanel = new JPanel(new CardLayout()); // Utilizza CardLayout come layout manager
        initClasses();

        // Aggiungi i pannelli al cardsPanel con nomi corrispondenti agli stati del gioco
        cardsPanel.add(loadingScreenPanel, GameState.LOADING.toString());
        cardsPanel.add(menuPanel, GameState.MENU.toString());
        cardsPanel.add(gamePanel, GameState.PLAY.toString());
        cardsPanel.add(optionMenuPanel, GameState.SETTINGS.toString());
        cardsPanel.add(howToPlayPanel, GameState.HOWTOPLAY.toString());

        this.add(cardsPanel); // Aggiungi il cardsPanel alla finestra principale

        changeGameState(GameState.gameState);

        startBackgroundMusic();
        // Avvia la riproduzione dell'audio di sfondo
        if (backgroundMusic != null) {
            backgroundMusic.play();
        }

        this.pack();
        this.setLocationRelativeTo(null); // Centra la finestra
    }

    public void initClasses() {
        loadingScreenPanel = new LoadingScreenPanel(this);
        menuPanel = new MenuPanel(this);
        optionMenuPanel = new OptionMenuPanel(this);
        gamePanel = new GamePanel(this);
        howToPlayPanel = new HowToPlayPanel(this);
        
    }

    //--------------------------------------------------------------------
    // GAMESTATE
    //--------------------------------------------------------------------

    public void changeGameState(GameState state) {
        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, state.toString());

        revalidate(); // Aggiorna il layout
        repaint(); // Ridisegna la finestra
    }

    //--------------------------------------------------------------------
    // LOGO
    //--------------------------------------------------------------------

    public void addLogo() {
        ImageIcon icon = new ImageIcon("img/logo.png");
        Image logo = icon.getImage();
        setIconImage(logo);
    }

    //--------------------------------------------------------------------
    // MUSIC
    //--------------------------------------------------------------------

    private void startBackgroundMusic() {
        try {
            String backgroundMusicFilePath = "music/game_song.wav"; // Sostituisci con il percorso del tuo file audio di sfondo
            backgroundMusic = new Audio(backgroundMusicFilePath);
            backgroundMusic.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------------------
    // CLOSE MAIN WINDOW
    //--------------------------------------------------------------------

    public void closeActiveWindow() {
        Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        if (activeWindow != null) {
            activeWindow.dispose();
        }
    }

    //--------------------------------------------------------------------
    // FULL SCREEN
    //--------------------------------------------------------------------

    public void setFullScreen() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this); // Imposta la finestra a schermo intero
        } 
    }

    public void exitFullScreen() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(null); // Esci dalla modalità schermo intero
    }

    //--------------------------------------------------------------------
    // MAIN
    //--------------------------------------------------------------------
    
    public static void main(String[] args) throws Exception {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

}
