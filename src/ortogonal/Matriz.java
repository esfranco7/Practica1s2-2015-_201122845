
package ortogonal;

import java.util.ArrayList;

public class Matriz {
//Nodo base... q va arriba de los a�os..y la izquierda de las marcas
	private NodoMatriz base = new NodoMatriz();
	public Matriz(){
		
	}
	//metodo para imprimir el resultado
	public void dPrint(){
		//un temportal que este abajo de la base... o sea el q se va a manejar
		//por todas las fechas...
		NodoMatriz temp = base.getAbajo();
		NodoMatriz temp2 = null;
		///////////NodoMatriz temp2 = mBase.getDerecha();
		//while de la recorrido de fechas
		while(temp != null){
			System.out.println("FILA[ Y = " + temp.getY() + " ]");
			temp2 = temp.getDerecha();
			//while de recorrido de las marcas
			while(temp2 != null){
				System.out.println("COLUMNA[ X = " + temp2.getX() + " ]");
				temp2.dPrint();
				System.out.println("FINCOLUMNA[ X = " + temp2.getX() + " ]\n" );
				temp2 = temp2.getDerecha();
			}
			System.out.println("FINFILA[ Y = " + temp.getY() + " ]\n" );
			temp = temp.getAbajo();
		}
	}
/////////////////////////////////////////metodo para buscar la marca
	public NodoMatriz buscarX(int pX){
		NodoMatriz temp = base.getDerecha();
		
		while( temp != null ){
			if(temp.getX()==pX){
				System.out.println("X encontrada " + pX );
				return temp;
			}
			temp = temp.getDerecha();
		}
		
		return null;
	}
/////////////////////////////////////metodo para buscar el modelo...
	public NodoMatriz buscarY(int pY){
		NodoMatriz temp = base.getAbajo();
		
		while(temp != null){
			if(temp.getY() == pY){
				return temp;
			}
			temp = temp.getAbajo();
		}
		
		return null;
	}
/////////////////////////////////////metodo de insercion
	public void insertar(String pClav, Objeto pObjeto){
		//Si la entrada viene vacia que no la meta...
		if(pObjeto == null){
			return;
		}
		//para el nodo modelo
		int y = pObjeto.getY();
		//para el nodo marca
		int x = pObjeto.getX();
		//un temporizador para el nodo base
		NodoMatriz temp = base;
		NodoMatriz tempIzq = base;
//////----------------------El ingreso de la primera vez------------------\\\\\\
                                 ///caso1///
		if(temp.getDerecha() == null && temp.getAbajo() == null){
			//Se crea el nodo del modelo, el de la marca y el del elemento
			NodoMatriz nodoY = new NodoMatriz();
			NodoMatriz nodoX = new NodoMatriz();
			NodoMatriz nodoElemento = new NodoMatriz();
			//Se le agregan sus datos a cada nodo
			nodoY.setY(y);
			nodoX.setX(x);
			nodoElemento.agregarObjeto(pObjeto);
			//nodo modelo a punta al elemento y a la base
			nodoY.setDerecha(nodoElemento);
			nodoY.setArriba(temp);
			//la marca a punta al modelo y a la base
			nodoX.setAbajo(nodoElemento);
			nodoX.setIzquierda(temp);
			//el elemento a punta a la marca y al modelo
			nodoElemento.setArriba(nodoX);
			nodoElemento.setIzquierda(nodoY);
			// la base a punta al modelo y a la marca
			temp.setDerecha(nodoX);
			temp.setAbajo(nodoY);
			
			return;
		}
//------------------------------------------------------------------------------
	//se le pone temporal al nuevo nodo Y
		temp = base.getAbajo();
		//se le pone temporal al nuevo nodo de la X
		boolean hayY = false;
		//para saber si hay una misma marca ya repetida
		boolean hayX = false;
		while(temp != null){
			if(temp.getY() == y){
				hayY = true;
				break;		
			}
			temp = temp.getAbajo();
		}
		
////--------------------------Si hay uno igual.../******************************
	if(hayY==true){
		//el temporizador ya no es el modelo si no que el siguiente 
		temp = temp.getDerecha();
		hayX = false;
		//los recorre y mientras no sea null 
		while(temp != null){
                    /////Si en cuentra a uno que tambien sea de la misma marca
		    if(temp.getX()==x){
			hayX = true;
			break;
		    }
		temp = temp.getDerecha();
		}
          ////Si es el mismo modelo y la misma marca..../**************************
                		///Caso2///
	  if(hayX==true){
		temp.agregarObjeto(pObjeto);
		return;
	  }
/***************************************************************************/			
				///Caso3///
	 else{
		NodoMatriz temp2 = base.getDerecha();
		NodoMatriz nodoX = new NodoMatriz();
		nodoX.setX(x);
		NodoMatriz nodoElemento = new NodoMatriz();
                nodoElemento.agregarObjeto(pObjeto);
		boolean findebusqueda = false;
		while(temp2!=null){
			if(temp2.getDerecha()!=null){
				nodoX.setAbajo(nodoElemento);
				nodoX.setIzquierda(temp2);
				nodoElemento.setArriba(nodoX);
				temp2.setDerecha(nodoX);
				break;
			}
		temp2 = temp2.getDerecha();
		}
                temp = base.getAbajo();
		boolean hayY2 = false;
		NodoMatriz tempo = base.getAbajo();			
		while(tempo != null){
			if(tempo.getY() == y){
				hayY2 = true;
				break;		
			}
			tempo = tempo.getAbajo();
		}
		if(hayY2==true){
			NodoMatriz tempo2 = tempo.getDerecha();
			while(tempo2 != null){
				if(tempo2.getDerecha() == null){
					tempo2.setDerecha(nodoElemento);
					nodoElemento.setIzquierda(tempo2);
					break;
				}
			tempo2 = tempo2.getDerecha();
			}
		  }	
		  return;
		}
	}else{
		///////////////////////Caso4   y caso 5/////////////////////////
			// no hay Y
			//temporizador esta en el primer Y
        	NodoMatriz tempy = base.getAbajo();
		NodoMatriz nodoY = new NodoMatriz();
		nodoY.setY(y);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarObjeto(pObjeto);		
		while(tempy != null){
			//caso5
			if(tempy.getY()>y){
				NodoMatriz antetempy = tempy.getArriba();
				nodoY.setAbajo(tempy);
				nodoY.setArriba(antetempy);
				nodoElemento.setIzquierda(nodoY);
				nodoY.setDerecha(nodoElemento);
				tempy.setArriba(nodoY);
				antetempy.setAbajo(nodoY);
				break;
			}else{
			//caso4
			if(tempy.getAbajo() == null){
				tempy.setAbajo(nodoY);
				nodoY.setArriba(tempy);
				nodoY.setDerecha(nodoElemento);
				nodoElemento.setIzquierda(nodoY);
				break;		
				}
			}
			tempy = tempy.getAbajo();
		}
		NodoMatriz tempo = base.getDerecha();
		while(tempo!=null){
			if(tempo.getX() == x){
				NodoMatriz tempus = tempo.getAbajo();
				if(tempus!=null){
					while(tempus!=null){
						if(tempus.getY()>y){
							NodoMatriz antetemp = tempus.getArriba();
							nodoElemento.setAbajo(tempus);
							nodoElemento.setArriba(antetemp);
							antetemp.setAbajo(nodoElemento);
							tempus.setArriba(nodoElemento);
							break;
						}
					tempus = tempus.getAbajo();
					}
					break;
				}else{
					nodoElemento.setArriba(tempus);
					tempus.setAbajo(nodoElemento);
					break;
				}
			}else{
				//caso6
				if(tempo.getDerecha()==null){
					NodoMatriz nodoX = new NodoMatriz();
					nodoX.setX(x);
					tempo.setDerecha(nodoX);
					nodoX.setIzquierda(tempo);
					nodoX.setAbajo(nodoElemento);
					nodoElemento.setArriba(nodoX);
				}
			}
			tempo = tempo.getDerecha();
		}
		}
		return;
	}

public void insertar2(Objeto objeto){
	//Si la entrada viene vacia que no la meta...
	if(objeto == null){
		return;
	}
	//para el nodo Y
	int y = objeto.getY();
	//para el nodo X
	int x = objeto.getX();
	//un temporizador para el nodo base
	NodoMatriz temp = base;
	NodoMatriz tempIzq = base;
//////----------------------El ingreso de la primera vez------------------\\\\\\
                                ///caso1///
	if(temp.getDerecha() == null && temp.getAbajo() == null){
		//Se crea el nodo del modelo, el de x y el del elemento
		NodoMatriz nodoY = new NodoMatriz();
		NodoMatriz nodoX = new NodoMatriz();
		NodoMatriz nodoElemento = new NodoMatriz();
		//Se le agregan sus datos a cada nodo
		nodoY.setY(y);
		nodoX.setX(x);
		nodoElemento.agregarObjeto(objeto);
		//nodo modelo a punta al elemento y a la base
		nodoY.setDerecha(nodoElemento);
		nodoY.setArriba(temp);
		//la marca a punta al modelo y a la base
		nodoX.setAbajo(nodoElemento);
		nodoX.setIzquierda(temp);
		//el elemento a punta a la marca y al modelo
		nodoElemento.setArriba(nodoX);
		nodoElemento.setIzquierda(nodoY);
		// la base a punta al modelo y a la marca
		temp.setDerecha(nodoX);
		temp.setAbajo(nodoY);
        	return;
	}
//------------------------------------------------------------------------------
        //se le pone temporal al nuevo nodo de la fecha...
	temp = base.getAbajo();
	//se le pone temporal al nuevo nodo de la Y...
	boolean hayY = false;
	//para saber si hay una misma marca ya repetida
	boolean hayX = false;
	while(temp != null){
		if(temp.getY() == y){
			hayY = true;
			break;		
		}
	temp = temp.getAbajo();
	}
////--------------------------Si hay uno igual.../******************************
	if(hayY==true){
		//el temporizador ya no es el modelo si no que el siguiente 
		temp = temp.getDerecha();
		hayX = false;
		//los recorre y mientras no sea null 
		while(temp != null){
                    /////Si en cuentra a uno que tambien sea de la misma marca
                    if(temp.getX()==x){
			hayX = true;
			break;
                    }
		temp = temp.getDerecha();
		}
////Si es el mismo modelo y la misma marca..../**************************
							///Caso2///
		if(hayX==true){
			temp.agregarObjeto(objeto);
			return;
		}
/***************************************************************************/			
							///Caso3///
	else{
		NodoMatriz temp2 = base.getDerecha();
		NodoMatriz nodoX = new NodoMatriz();
                nodoX.setX(x);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarObjeto(objeto);
		boolean findebusqueda = false;
		while(temp2!=null){
			if(temp2.getDerecha()!=null){
        			nodoX.setAbajo(nodoElemento);
				nodoX.setIzquierda(temp2);
                		nodoElemento.setArriba(nodoX);
				temp2.setDerecha(nodoX);
				break;
			}
		temp2 = temp2.getDerecha();
		}
		temp = base.getAbajo();
		boolean hayY2 = false;
		NodoMatriz tempo = base.getAbajo();			
		while(tempo != null){
			if(tempo.getY() == y){
				hayY2 = true;
				break;		
			}
		tempo = tempo.getAbajo();
		}
		if(hayY2==true){
			NodoMatriz tempo2 = tempo.getDerecha();
			while(tempo2 != null){
                		if(tempo2.getDerecha() == null){
					tempo2.setDerecha(nodoElemento);
					nodoElemento.setIzquierda(tempo2);
					break;
				}
			tempo2 = tempo2.getDerecha();
                	}
		  }	
		  return;
		}
	}else{
		///////////////////////Caso4   y caso 5/////////////////////////
			// no hay Y
			//temporizador esta en el primer Y
		NodoMatriz tempy = base.getAbajo();
		NodoMatriz nodoY = new NodoMatriz();
		nodoY.setY(y);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarObjeto(objeto);		
		while(tempy != null){
			//caso5
			if(tempy.getY()>y){
				NodoMatriz antetempy = tempy.getArriba();
				nodoY.setAbajo(tempy);
				nodoY.setArriba(antetempy);
				nodoElemento.setIzquierda(nodoY);
				nodoY.setDerecha(nodoElemento);
				tempy.setArriba(nodoY);
				antetempy.setAbajo(nodoY);
				break;
			}else{
			//caso4
			if(tempy.getAbajo() == null){
				tempy.setAbajo(nodoY);
				nodoY.setArriba(tempy);
				nodoY.setDerecha(nodoElemento);
				nodoElemento.setIzquierda(nodoY);
				break;		
				}
			}
			tempy = tempy.getAbajo();
		}
		NodoMatriz tempo = base.getDerecha();
		while(tempo!=null){
			if(tempo.getX()==x){
				NodoMatriz tempus = tempo.getAbajo();
				if(tempus!=null){
					while(tempus!=null){
						if(tempus.getY()>y){
							NodoMatriz antetemp = tempus.getArriba();
							nodoElemento.setAbajo(tempus);
							nodoElemento.setArriba(antetemp);
							antetemp.setAbajo(nodoElemento);
							tempus.setArriba(nodoElemento);
							break;
						}
					tempus = tempus.getAbajo();
					}
					break;
				}else{
					nodoElemento.setArriba(tempus);
					tempus.setAbajo(nodoElemento);
					break;
				}
			}else{
				//caso6
				if(tempo.getDerecha()==null){
					NodoMatriz nodoX = new NodoMatriz();
					nodoX.setX(x);
					tempo.setDerecha(nodoX);
					nodoX.setIzquierda(tempo);
					nodoX.setAbajo(nodoElemento);
					nodoElemento.setArriba(nodoX);
				}
			}
			tempo = tempo.getDerecha();
		}
		}
		return;
	}
	public void Buscar(int x, int y){
		//NodoMatriz temp = mBase.getDerecha();
		NodoMatriz tempo = base.getAbajo();
		System.out.println("hola");
			while(tempo!=null){
				if(tempo.getY()==y){
					System.out.println("adios");
					break;
				}
			}
	}

}
