/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario;

import java.awt.Graphics;

/**
 *
 * @author esfranco7
 */
public class Pared extends ObjetoJuego{
    Texturas tex;
    
    public Pared(int x, int y, Texturas tex) {
        this.x = x;
        this.y = y;   
        this.tex = tex;
        this.imagen = tex.pared;
    }
    
    public void tick(){
      
    }
    
    public void render(Graphics g){
        g.drawImage(tex.pared,x, y,null);
        
    }
}
