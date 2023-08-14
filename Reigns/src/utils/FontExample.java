import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

public class FontExample {
    public static void main(String[] args) {
        try {
            // Create a font from the file OCR-A-Extended.ttf
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("font/OCRAExtendedRegular.ttf"));
            // Derive a new font with size 24 and plain style
            font = font.deriveFont(24f);
            // Use the font for a label or other component
            JLabel label = new JLabel("Hello world!");
            label.setFont(font);
        } catch (IOException | FontFormatException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}