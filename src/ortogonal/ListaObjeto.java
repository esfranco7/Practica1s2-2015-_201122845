package ortogonal;

public class ListaObjeto {
    private NodoListaCarro mBase = null;
	public void borrarPorId(int pId){
		int pos = buscarPorId( pId );
		borrarPorPosicion( pos );
	}
	public void borrarPorPosicion(int pPos){
		NodoListaCarro temp = mBase;
		int pos = 0;
		if(mBase == null){
			return;
		}
		if(mBase.getSiguiente() == null){
			if( pos == pPos ){
				mBase = null;
			}
			return;
		}else{
			if(pPos == pos){
				mBase = mBase.getSiguiente();
					return;
			}
		}
		NodoListaCarro actual = mBase.getSiguiente();
		pos = 1;
		while(actual != null){
			if(pos == pPos){
				temp.setSiguiente(actual.getSiguiente());
				return;
			}
			pos++;
			temp = actual;
			actual = actual.getSiguiente();
		}	
	}
	public int getSize(){
		NodoListaCarro temp = mBase;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.getSiguiente();
		}
		return size;
	}
	public Objeto getCarroPorPosicion(int pPos){
		NodoListaCarro temp = mBase;
		int size = 0;
		while( temp != null )	
		{
			if(size == pPos){
				return temp.getDato();
			}
			size++;
			temp = temp.getSiguiente();
		}	
		return null;
	}
	public int buscarPorId(int pId){
		NodoListaCarro temp = mBase;
		int pos = 0;
		while(temp != null){
			if(temp.getDato().getId() == pId){
				return pos;
			}
			pos++;
			temp = temp.getSiguiente();
		}	
		return -1;
	}
	public void insertarObjeto(Objeto pCarro){
		if(pCarro == null){
			return;
		}
		NodoListaCarro temp = new NodoListaCarro();
		temp.setDato(pCarro);
		if(mBase == null){
			mBase = temp;
			return;
		}
		temp.setSiguiente(mBase);
		mBase = temp;	
	}
	public void dPrint(){
		System.out.println(toString());
	}
	public String toString(){
		StringBuilder b = new StringBuilder();
		NodoListaCarro temp = mBase;
		b.append("ListaCarro[ \n");
		while(temp != null){
			b.append( temp.toString() );
			b.append( "\n" );
			temp = temp.getSiguiente();
		}
		b.append( "]" );
		return b.toString();
	}
}