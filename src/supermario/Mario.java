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
public class Mario extends ObjetoJuego {
    
    int velX = 0;
    int velY = 0;
    Texturas tex;
    
    public Mario(int x, int y,Texturas tex){
        this.x = x;
        this.y = y;   
        this.tex = tex;
        this.imagen = tex.mario;
    }
    
    public void tick(){
        x+=velX;
        y+=velY;
        if(x<0)
            x=0;
        if(x>400-32)
            x=400-32;
        if(y<0)
            y=0;
        if(y>=445)
            y=445;
    }
    
    public void render(Graphics g){
        g.drawImage(tex.mario,x, y,null);
        
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    
}
