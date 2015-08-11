/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario.estructuras;

import supermario.ObjetoJuego;

/**
 *
 * @author esfranco7
 */
public class MatrizOrtogonal {
    
    Raiz raiz;
    ListaDoble col = new ListaDoble();
    ListaDoble fil = new ListaDoble();
    
    public MatrizOrtogonal(){
    raiz = new Raiz();
    ObjetoJuego x0 = new ObjetoJuego();
    ObjetoJuego x1 = new ObjetoJuego();
    ObjetoJuego y0 = new ObjetoJuego();
    ObjetoJuego y1 = new ObjetoJuego();
    ObjetoJuego y2 = new ObjetoJuego();
    ObjetoJuego y3 = new ObjetoJuego();
    y0.setY(0);
    col.insertar(y0);
    y1.setY(1);
    col.insertar(y1);
    y2.setY(2);
    col.insertar(y2);
    y3.setY(3);
    col.insertar(y3);
    x0.setX(0);
    fil.insertar(x0);
    x1.setX(1);
    fil.insertar(x1);
    raiz.setColumnas(col);
    raiz.setFilas(fil);
    }
    
    public void agregarFila(){
        int i = fil.getUltimo().objeto.getX()+1;
        ObjetoJuego temp = new ObjetoJuego();
        temp.setX(i);
        fil.insertar(temp);
    }
    
    public void agregarColumna(){
        int i = col.getUltimo().objeto.getY()+1;
        ObjetoJuego temp = new ObjetoJuego();
        temp.setY(i);
        col.insertar(temp);
    }
    
    public void insertar(ObjetoJuego objeto){
        
    }
    
}
