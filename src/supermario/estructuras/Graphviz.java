/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermario.estructuras;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import supermario.estructuras.ListaDoble.NodoDoble;

/**
 *
 * @author esfranco7
 */
public class Graphviz {
    
    public Graphviz(ListaDoble lista) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("ListaDoble.dot");
        writer.println("digraph simple {");
        writer.println("rankdir=LR;");
        NodoDoble actual = lista.getPrimero();
        NodoDoble ultimo = lista.getUltimo();
        while(actual!=ultimo)
        {
            writer.println("\""+actual.objeto.getNombre()+"\"->\""+actual.next.objeto.getNombre()+"\"");
            actual=actual.next;
        }
        actual = lista.getUltimo();
        NodoDoble primero = lista.getPrimero();
        while(primero!=actual)
        {
            writer.println("\""+actual.objeto.getNombre()+"\"->\""+actual.ant.objeto.getNombre()+"\"");
            actual=actual.ant;
        }
                writer.println("}");
                writer.close();
    }
    
    public Graphviz(MatrizOrtogonal orto) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter("MatrizOrtogonal.dot");
        writer.println("digraph simple {");
        writer.println("\"0\"->\"Y0\"");
        NodoDoble actual = orto.fil.getPrimero();
        NodoDoble ultimo = orto.fil.getUltimo();
        while(actual!=ultimo)
        {
            writer.println("\"Y"+actual.objeto.getX()+"\"->\"Y"+actual.next.objeto.getX()+"\"");
            actual=actual.next;
        }
        writer.println("\"0\"->\"X0\"[constraint=false];");
        actual = orto.col.getPrimero();
        ultimo = orto.col.getUltimo();
        while(actual!=ultimo)
        {
            writer.println("\"X"+actual.objeto.getY()+"\"->\"X"+actual.next.objeto.getY()+"\"[constraint=false];");
            actual=actual.next;
        }
        writer.println("}");
        writer.close();
    }
    
}
