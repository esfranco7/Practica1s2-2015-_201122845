/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import supermario.estructuras.Graphviz;
import supermario.estructuras.ListaDoble;
import supermario.estructuras.MatrizOrtogonal;
import gui.CargaObjetos;

/**
 *
 * @author esfranco7
 */
public class SuperMario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
       ObjetoJuego a = new ObjetoJuego();
       ObjetoJuego b = new ObjetoJuego();
       ObjetoJuego c = new ObjetoJuego();
       ObjetoJuego d = new ObjetoJuego();
       ObjetoJuego e = new ObjetoJuego();
       ObjetoJuego f = new ObjetoJuego();
       
       a.setNombre("a");
       b.setNombre("b");
       c.setNombre("c");
       d.setNombre("d");
       e.setNombre("e");
       f.setNombre("f");
       
       
      
       CargaObjetos objetos = new CargaObjetos();
       objetos.setVisible(true);
           
     
        MatrizOrtogonal matriz = new MatrizOrtogonal();
       
        
        /**
        Game game = new Game();
        JFrame frame = new JFrame("supermario");
        frame.add(game);
        frame.setVisible(true);
        frame.setSize(550, 530);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.start();
       */
    }
    
}
