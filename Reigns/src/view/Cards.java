import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cards extends JPanel implements MouseMotionListener, MouseListener {

    // COSTANT
    private final static int BORDER_RADIUS = 35;
   
    // COLOR
    private Color brown;
    private Color blackTransparent;

    private int xCard;
    private int yCard;
    private int cardWidth;
    private int cardHeight;

    private String CARD_IMAGE = "img/characters/random.png";

    private BufferedImage img = null;

    private boolean animation = false; 

    
    public Cards(/*String rightChoose, String leftChoose, Image img*/) {
        setOpaque(false);
        //setPreferredSize(new Dimension(1250, 800));
        
        brown = new Color(35, 20 , 3);
        blackTransparent = new Color(0, 0, 0, 128); // 0-255 per rosso, verde, blu, 0-255 per trasparenza

        loadImage(CARD_IMAGE);
        addMouseMotionListener(this);
        addMouseListener(this);

        cardWidth = 336;
        cardHeight = 340;
        xCard = 1280/2 - 169;
        yCard = 258;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawRoundImage(g2d, img, xCard, yCard, cardWidth, cardHeight, BORDER_RADIUS);
        //g2d.drawImage(img, xCard, yCard, cardWidth, cardHeight , null);
        g2d.setColor(blackTransparent);
        g2d.fillRoundRect(xCard, yCard, cardWidth, cardHeight / 5, BORDER_RADIUS, BORDER_RADIUS);
        
        // String
        g2d.setColor(Color.WHITE);
        //g2d.drawString("Yes", xCard, yCard );

        //g2d.drawString("No", xCard, yCard);
        
        g2d.dispose(); // Rilascia le risorse di disegno e libera la memoria
    }

    private void drawRoundImage(Graphics2D g2d, Image image, int x, int y, int width, int height, int borderRadius) {
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(x, y, width, height, borderRadius, borderRadius);

        g2d.setClip(roundRect);
        g2d.drawImage(image, x, y, width, height, this);
        g2d.setClip(null);
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
            animation = true;
        } else {
            System.out.println("La risposta è No");
            animationL();
            animation = true;
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

    // Load the background image from a file
    private void loadImage(String fileImage) {
        try {
            this.img = ImageIO.read(new File(fileImage));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean getAnimationStatus() {
        return animation;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Card Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Cards cardPanel = new Cards();
            frame.add(cardPanel);

            frame.pack();
            frame.setVisible(true);
        });
    }

    
}
