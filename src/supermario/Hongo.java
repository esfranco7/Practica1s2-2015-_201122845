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
public class Hongo extends ObjetoJuego{
    Texturas tex;
    
    public Hongo(int x, int y, Texturas tex) {
        this.x = x;
        this.y = y;   
        this.tex = tex;
        this.imagen = tex.hongo;
    }
    
    public void tick(){
      
    }
    
    public void render(Graphics g){
        g.drawImage(tex.hongo,x, y,null);
        
    }
}
