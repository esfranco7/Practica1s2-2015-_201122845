/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario;

import java.awt.image.BufferedImage;

/**
 *
 * @author esfranco7
 */
public class SpriteSheet {
    private BufferedImage image;
    
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage grabImage(int col, int fil, int largo, int ancho){
        BufferedImage img = image.getSubimage((col*32)-32, (fil*32)-32, 32, 32);
        return img;
    }
    
}
