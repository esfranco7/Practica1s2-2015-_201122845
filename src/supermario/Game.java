/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author esfranco7
 */
public class Game extends Canvas implements Runnable{
    public final int WIDTH = 320;
    public final int HEIGHT = WIDTH/9*12;
    public final int SCALE = 2;
    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(320,320*12/9,BufferedImage.TYPE_INT_RGB);
    public BufferedImage mariosprite,koopasprite,goombasprite,paredsprite,fichasprite,hongosprite,castillosprite,suelosprite;
    private BufferedImage background = null;
    private Mario mario;
    private Koopa koopa;
    private Goomba goomba;
    private Pared pared;
    private Hongo hongo;
    private Texturas tex;
    private Ficha ficha;
    private Castillo castillo;
   
    
    public void init(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            mariosprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/mario1.gif");
            background = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/background1.gif");
            koopasprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/koopa1.gif");
            goombasprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/goomba1.gif");
            paredsprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/pared1.gif");
            fichasprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/ficha1.gif");
            hongosprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/hongo1.gif");
            castillosprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/castillo1.gif");
            suelosprite = loader.loadImage("/home/esfranco7/Desktop/SuperMario/src/res/suelo1.gif");
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        addKeyListener(new KeyInput(this));
        tex = new Texturas(this);
        mario = new Mario(0,445,tex);
        koopa = new Koopa(200,445,tex);
        goomba = new Goomba(300,445,tex);
        pared = new Pared(100,100,tex);
        ficha = new Ficha(150,150,tex);
        hongo = new Hongo(250,250,tex);
        castillo = new Castillo(350,325,tex);
    }
    
    public Game(){
        init();
        this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        this.setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        this.setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
    }
    
   public synchronized void start(){
       if(running)
           return;
       
       running = true;
       thread = new Thread(this);
       thread.start();
   }
   
   public synchronized void stop(){
       if(!running)
           return;
       
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.exit(1);
   }
   
    public void run() {
        long last = System.nanoTime();
        final double ticks = 60.0;
        double ns = 1000000000/ticks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            long now = System.nanoTime();
            delta+=(now-last)/ns;
            last = now;
            if(delta>=1){
                updates++;
                tick();
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer > 1000){
                timer+=1000;
                //System.out.println(updates +"Ticks, FPS"+frames);
                updates=0;
                frames=0;
            }
            
        }
        stop();
    }
    
    private void tick(){
        mario.tick();        
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, 500,400,this);
        g.drawImage(background,0,0,null);
        mario.render(g);
        koopa.render(g);
        goomba.render(g);
        pared.render(g);
        ficha.render(g);
        hongo.render(g);
        castillo.render(g);
        g.dispose();
        bs.show();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key==KeyEvent.VK_LEFT){
            mario.setVelX(-4);
        }else if(key==KeyEvent.VK_RIGHT){
            mario.setVelX(4);
        }else if(key==KeyEvent.VK_UP || key==KeyEvent.VK_SPACE && mario.y==445){
            mario.setVelY(-5);
        }else if(key==KeyEvent.VK_DOWN){
            mario.setVelY(5);
        }
    }

    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
        
        if(key==KeyEvent.VK_LEFT){
            mario.setVelX(0);
        }else if(key==KeyEvent.VK_RIGHT){
            mario.setVelX(0);
        }else if(key==KeyEvent.VK_UP || key==KeyEvent.VK_SPACE){
            mario.setVelY(3);
        }else if(key==KeyEvent.VK_DOWN){
            mario.setVelY(0);
        }
    }
    
    
}
