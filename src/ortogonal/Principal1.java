package ortogonal;

import supermario.ObjetoJuego;

public class Principal1{
	
	Principal1(){
		Objeto a = new Objeto();
                Objeto b = new Objeto();
                Objeto c = new Objeto();
                Objeto d = new Objeto();
                Objeto e = new Objeto();
                
		ObjetoJuego obj = new ObjetoJuego();
                obj.setNombre("mario");
		
		a.setId(1);
		a.setX(0);
                a.setY(0);
                a.setObjeto(obj);
              
                b.setId(2);
		b.setX(0);
                b.setY(1);
               
                c.setId(3);
		c.setX(0);
                c.setY(2);
               
                d.setId(4);
		d.setX(1);
                d.setY(0);
             
                e.setId(5);
		e.setX(1);
                e.setY(1);
                
                Matriz mat = new Matriz();
              
		mat.insertar2(a);
                mat.insertar2(b);
                mat.insertar2(c);
                mat.insertar2(d);
                mat.insertar2(e);
                
		mat.dPrint();
		
	}
public static void main(String arg[]){
	new Principal1();

}
}
