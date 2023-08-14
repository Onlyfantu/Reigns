package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Character {

    private String nome;
    private BufferedImage immagine;
    private String descrizione;

  
    public Character(String nome, String img, String descrizione) {
        this.nome = nome; 
        this.descrizione = descrizione; 
        try {
            this.immagine = ImageIO.read(new File(img)); 
        } catch (IOException ioe) {
            ioe.printStackTrace(); 
        }
    }

    public String getNome() {
        return this.nome;
    }

    public BufferedImage getImmagine() {
        return this.immagine;
    }

    public String getDescrizione() {
        return this.descrizione;
    }
}
