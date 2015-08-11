package ortogonal;

import supermario.ObjetoJuego;

public class Objeto {
    private int mId = 0;
	private ObjetoJuego objeto;
        private int x;
        private int y;
	
	public Objeto(){
		
	}
	
	public String toString(){
	//Para que una todo en una cadena...
		StringBuilder b = new StringBuilder();
		b.append( "Objeto[ " );
		if(objeto !=null){
                b.append( objeto.getNombre() );
                }else{
                b.append( "vacio" );
                }
		b.append( " ]" );
		return b.toString();
	}
	//Todos los set y get de Id, Modelo, Marca y Color
	public void setId(int pId){
		mId = pId;	
	}
	
	public int getId(){
		return mId;	
	}

    public ObjetoJuego getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoJuego objeto) {
        this.objeto = objeto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
	
	
}