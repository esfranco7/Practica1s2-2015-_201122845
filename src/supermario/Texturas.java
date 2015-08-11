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
public class Texturas {
    
    public BufferedImage mario,koopa,goomba,pared,ficha,hongo,castillo,suelo;
    private SpriteSheet mariosprite;
    private SpriteSheet koopasprite;
    private SpriteSheet goombasprite;
    private SpriteSheet paredsprite;
    private SpriteSheet fichasprite;
    private SpriteSheet hongosprite;
    private SpriteSheet castillosprite;
    private SpriteSheet suelosprite;
    private Game game;
    
    public Texturas(Game game){
        
      this.game = game;
      mariosprite = new SpriteSheet(game.mariosprite);
      koopasprite = new SpriteSheet(game.koopasprite);
      goombasprite = new SpriteSheet(game.goombasprite);
      paredsprite = new SpriteSheet(game.paredsprite);
      fichasprite = new SpriteSheet(game.fichasprite);
      hongosprite = new SpriteSheet(game.hongosprite);
      castillosprite = new SpriteSheet(game.castillosprite);
      suelosprite = new SpriteSheet(game.suelosprite);
      getTexturas();
    }

    private void getTexturas() {
       mario = mariosprite.grabImage(1, 1, 32, 32);
       koopa =koopasprite.grabImage(1, 1, 32, 32);
       goomba = goombasprite.grabImage(1, 1, 32, 32);
       pared = paredsprite.grabImage(1, 1, 32, 32);
       ficha = fichasprite.grabImage(1, 1, 32, 32);
       hongo = hongosprite.grabImage(1, 1, 32, 32);
       castillo = game.castillosprite.getSubimage(0, 0, 160, 153);
    }
}
