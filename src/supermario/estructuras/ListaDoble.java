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
public class ListaDoble {
    
    class NodoDoble{
        ObjetoJuego objeto;
        NodoDoble next;
        NodoDoble ant;
        NodoDoble(ObjetoJuego a)
        {
            this.objeto=a;
            this.next=null;
            this.ant=null;
        }
    }

    NodoDoble primero;
    NodoDoble ultimo;

    public NodoDoble getPrimero() {
        return primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }
    
    public ListaDoble()
    {
        primero=null;
        ultimo=null;
    }
 
    public boolean estaVacio()
    {
        if(primero==null) 
            return true;
        else return false;
    }
 
    public void insertar(ObjetoJuego dat)
    {
        if(estaVacio())
        {
            NodoDoble nuevo=new NodoDoble(dat);
            primero=nuevo;
            ultimo=nuevo;
        }
        else
        {
            NodoDoble nuevo=new NodoDoble(dat);
            ultimo.next=nuevo;
            nuevo.ant=ultimo;
            ultimo=nuevo;
        }
    }
 
    public void borrar(int a)
    {//para borrar con posicion del nodo
        NodoDoble w=primero;
        NodoDoble y;
        for(int i=0;i<a;i++)
        {
            y=w.ant;
            w=w.next;
        }
        y=w.ant;
        System.out.print("Borrado el dato en la posicion: "+a);
    }
 
    public boolean delete(String num)
    {//para borrar con dato del nodo
        NodoDoble anterior=null;
        NodoDoble actual=primero;
        while(actual!=ultimo)
        {
            if(actual.objeto.getNombre()==num)
            {
                if(anterior==null)
                {
                    primero=actual.next;
                    primero.ant=null;
                }
                else{
                    anterior.next=actual.next;
                    NodoDoble temporal;
                    temporal=actual.next;
                    temporal.ant=anterior;
                }
                System.out.println("Borrado el dato: "+num);
                return true;
            }
            anterior=actual;
            actual=actual.next;
        }
        if(num==ultimo.objeto.getNombre())
        {
            ultimo=actual.ant;
            System.out.println("Borrado el dato: "+num);
            return true;
        } 
        System.out.println("Dato "+num+" no encontrado");
        return false;
    }
 
        public void imprimir(String seleccion)
    {
        NodoDoble actual;
        if(seleccion=="cola"){
            actual=primero;
            while(actual!=ultimo)
            {
                System.out.print(actual.objeto.getNombre()+"-->");
                actual=actual.next;
            }
                    System.out.print(actual.objeto.getNombre());
        }else if(seleccion=="pila"){
          actual=ultimo;
            while(actual!=primero)
            {
                System.out.print(actual.objeto.getNombre()+"-->");
                actual=actual.ant;
            }
                    System.out.print(actual.objeto.getNombre());  
        }
 
    }

}
    
    

