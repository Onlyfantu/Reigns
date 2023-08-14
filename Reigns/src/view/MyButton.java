import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyButton extends JPanel {

    private String txt;
    private boolean mouseOver;
    private int x, y, width, height;

    public MyButton(String txt/*  int x, int y, int width, int height*/){
        super();
        this.txt = txt; 
        /*this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;*/
    }

    public void paint(Graphics g){
        super.paintComponent(g);

        //Body
        drawBody(g);

        //Border
        g.setColor(Costants.gold);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        //Text
        drawText(g);
    }

    private void drawBody(Graphics g) {
            g.setColor(Costants.brown);
            g.fillRect(0, 0, getWidth(), getHeight());

            if (mouseOver) {
                g.setColor(Costants.lightBrown);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
    }

    public void drawText(Graphics g) {
        
        FontMetrics fontMetrics = g.getFontMetrics();
        
        int textWidth = fontMetrics.stringWidth(txt);
        int textHeight = fontMetrics.getHeight();                                      
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() - textHeight) / 2 + fontMetrics.getAscent();
        
        g.setColor(Costants.gold);
        g.setFont(Costants.buttonFont);
        g.drawString(txt, x, y);

        if(mouseOver) {
            g.setColor(Costants.brown);
            g.drawString(txt, x, y);
        }
    }

    //------------------------------------------------------------------------
    // Getter & Setter
    //------------------------------------------------------------------------

    public String getTxt() {
        return txt;
    }

    public void setMouseOver(boolean b) {
        mouseOver = b;
    }

}

