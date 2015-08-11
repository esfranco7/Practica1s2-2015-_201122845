package ortogonal;

public class NodoMatriz {
//Direccionamiento de la matriz con el movimiento de los nodos...
	private NodoMatriz arriba = null;
	private NodoMatriz abajo = null;
	private NodoMatriz derecha = null;
	private NodoMatriz izquierda = null;
	
	private int x = 0;
	private int y = 0;
	
	private ListaObjeto elementos = null;
	
	public NodoMatriz(){
		//Constructor
	}
		//Los set y gets...
	public void setX(int x){
		this.x = x;
	}
	
	public int getX(){
		return x;	
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	
		
	public void dPrint(){
		if(elementos != null){
			elementos.dPrint();
		}
	}
	//agragar los objetos...como nodos.. nodo donde estan los datos elementos
	//nodo donde esta la x
	//nodo donde esta la y
	public void agregarObjeto(Objeto objeto){
		
		if(objeto == null){
			return;
		}
		
		if(elementos == null){
			y = objeto.getY();
			x = objeto.getX();
			elementos = new ListaObjeto();
		}
		
		elementos.insertarObjeto(objeto);
	}
	
	//set y gets....
	public void setElementos(ListaObjeto pElementos){
		elementos = pElementos;
	}
	
	public ListaObjeto getElementos(){
		return elementos;
	}
	
	public void setArriba(NodoMatriz arriba){
		this.arriba = arriba;
	}
	
	public void setAbajo(NodoMatriz abajo){
		this.abajo = abajo;
	}
	
	public void setDerecha(NodoMatriz derecha){
		this.derecha = derecha;
	}
	
	public void setIzquierda(NodoMatriz izquierda){
		this.izquierda = izquierda;
	}
	
	public NodoMatriz getArriba(){
		return arriba;
	}
	
	public NodoMatriz getAbajo(){
		return abajo;
	}
	
	public NodoMatriz getDerecha(){
		return derecha;
	}
	
	public NodoMatriz getIzquierda(){
		return izquierda;
	}

}
