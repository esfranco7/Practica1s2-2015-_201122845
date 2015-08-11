package ortogonal;

public class NodoListaCarro {
 //Clas Nodo
	private Objeto mDato = null; //Carro: donde estan todos los datos del carro
	private NodoListaCarro mSiguiente = null; //apuntador siguiente
	private NodoListaCarro mAnterior = null;

    public NodoListaCarro getMAnterior() {
        return mAnterior;
    }

    public void setMAnterior(NodoListaCarro mAtras) {
        this.mAnterior = mAtras;
    }
	
	public NodoListaCarro(){
		//Constructor	
	}
	
	//Set y get del carro..con mDato
	public void setDato( Objeto pCarro ){
		mDato = pCarro;
	}
	
	public Objeto getDato(){
		return mDato;
	}
	//Set y get de el apuntador siguiente
	public void setSiguiente(NodoListaCarro pSiguiente){
		mSiguiente = pSiguiente;
	}
	
	public NodoListaCarro getSiguiente(){
		return mSiguiente;
	}
	
	//Concatena todos los datos en un String..
	public String toString(){
		if( mDato == null ){
			return "";
		}
		
		StringBuilder b = new StringBuilder();
		b.append( "NodoListaCarro[ " );
		b.append( mDato.toString() );
		b.append( " ]");
		return b.toString();
	}
}
