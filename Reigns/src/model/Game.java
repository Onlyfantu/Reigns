
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private String[] kingName = { "Jack", "Aldo", "Pippo", "Lele" };
    private int currentYear = 1000;
    //private ArrayList<Cards> cards;
    private Random random;
    private int randomNumber;
    private Cards cards;

    public Game() {
        random = new Random();
        randomNumber = random.nextInt(4);
        cards = new Cards(null, null, null);
        
    
    }

    public void startGame(String selectedGameName) {
        System.out.println("Starting a new game: " + kingName[randomNumber]);
        
    }

    private void generateNewCard() {
        if(cards.getAnimationStatus() == true) {
            System.out.println("New card generated.");
        }
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Inizializza e avvia la finestra del launcher
            GameLauncher launcher = new GameLauncher();
            launcher.setVisible(true);
        });
    }
}

class GameLauncher extends JFrame {
    private String[] possibleGameNames = { "Adventure", "Mystery", "Action", "Strategy" };
    private JButton playButton;

    public GameLauncher() {
        setTitle("Game Launcher");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        add(playButton);
    }

    private void startNewGame() {
        Random random = new Random();
        int randomIndex = random.nextInt(possibleGameNames.length);
        String selectedGameName = possibleGameNames[randomIndex];

        // Creare e avviare la nuova partita con il nome selezionato
        Game newGame = new Game();
        newGame.startGame(selectedGameName);
    }
}
