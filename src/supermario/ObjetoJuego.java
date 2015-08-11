/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author esfranco7
 */
public class ObjetoJuego {
    
    String nombre;
    protected int x;
    protected int y;
    protected BufferedImage imagen;

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   
}
