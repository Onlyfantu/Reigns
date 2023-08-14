import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartCard extends JPanel implements MouseMotionListener, MouseListener {

    // COSTANT
    private final static int BORDER_RADIUS = 35;
   
    private int xCard;
    private int yCard;
    private int cardWidth;
    private int cardHeight;

    private String CARD_IMAGE = "img/characters/random.png";
    private BufferedImage img = null;

    private JLabel yesLabel;
    private JLabel noLabel;
    
    public StartCard() {
        setOpaque(false);
        loadImage(CARD_IMAGE);
        initLabel();

        add(yesLabel);
        add(noLabel);
    }

    public void initLabel() {

        yesLabel = new JLabel();
        yesLabel.setText("Yes");
        yesLabel.setForeground(Color.BLACK);
        yesLabel.setFont(Costants.medievalFont);

        noLabel = new JLabel();
        noLabel.setText("No");
        noLabel.setForeground(Color.WHITE);
        noLabel.setFont(Costants.medievalFont);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        xCard = getWidth()/3 + getWidth()/29;
        yCard = getHeight()/2 - getHeight()/7;
        cardWidth = getWidth()/3 - 2 *(xCard - getWidth()/3);
        cardHeight = getHeight() - getHeight()/2 - getHeight()/30;

        drawRoundImage(g2d, img, xCard, yCard, cardWidth, cardHeight, BORDER_RADIUS);

        // String rect
        g2d.setColor(Costants.blackTransparent);
        g2d.fillRoundRect(xCard, yCard, cardWidth, cardHeight / 5 , BORDER_RADIUS, BORDER_RADIUS);
        
        // String
        yesLabel.setBounds(100, 100, 10, 10);
        noLabel.setBounds(100, 100, 10, 10);
        
        g2d.dispose(); // Rilascia le risorse di disegno e libera la memoria
    }

    

    private void drawRoundImage(Graphics2D g2d, Image image, int x, int y, int width, int height, int borderRadius) {
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(x, y, width, height, borderRadius, borderRadius);

        g2d.setClip(roundRect);
        g2d.drawImage(image, x, y, width, height, this);
        g2d.setClip(null);
    }

    // Load the background image from a file
    private void loadImage(String fileImage) {
        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int getXCard() {
        return xCard;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Card Example");
            frame.setPreferredSize(new Dimension(1280, 800));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            StartCard cardPanel = new StartCard();
            frame.add(cardPanel);

            frame.pack();
            frame.setVisible(true);
        });
    }

    public void animationR() {
        Timer timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (xCard < getWidth()) {
                        xCard += 45;
                        repaint();
                    } else {
                        ((Timer) e.getSource()).stop();
                        
                    }
                }
            });
    
        timer.start();
    }

    public void animationL() {
        Timer timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (xCard < getWidth()) {
                        xCard -= 45;
                        repaint();
                    } else {
                        ((Timer) e.getSource()).stop();
                        
                    }
                }
            });
    
        timer.start();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xLineCenter = getWidth() / 2;
        if (e.getX() > xLineCenter) {
            System.out.println("La risposta è Si");
            animationR();
            //animation = true;
        } else {
            System.out.println("La risposta è No");
            animationL();
            //animation = true;
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
