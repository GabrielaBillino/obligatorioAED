/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;


public class Cola<T extends Comparable<T>> implements ICola<T> {
    
    private Nodo<T> inicio;
    private int cantidad;
    private int tope;

    public Cola() {
        cantidad = 0;
        tope = 0;
        
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public Cola(int cantMax) {
        this.tope = cantMax;
    }
    
    @Override
    public void encolar(T dato) {
        //agregar al final
      if (!esLlena()) {
            Nodo<T> pactual = this.inicio;
            Nodo<T> nuevo = new Nodo<T>(dato);
            if (esVacia()) {
                inicio = nuevo;
                cantidad++;
            } else {
                while (pactual.getSiguiente() != null) {
                    pactual = pactual.getSiguiente();
                }
                pactual.setSiguiente(nuevo);
                cantidad++;
            }
        }  
    }

    @Override
    public void desencolar() {
        //eliminar inicio
        if (!esVacia()) {
            this.inicio = this.inicio.getSiguiente();
            cantidad--;
        }
    }

    @Override
    public Nodo<T> frente() {
      return inicio;        
    }

    @Override
    public boolean esVacia() {
       return cantidad==0;        
    }

    @Override
    public boolean esLlena() {
      return cantidad==tope;        
    }

    @Override
    public boolean eliminarElemento(Cola c, int num) {
        boolean borre = false;
        for(int i=1; i <= c.cantidad; i++){
            if((Integer)c.frente().getDato() != num){
                c.encolar(c.frente().getDato());
                c.desencolar();
            }else{
                c.desencolar();
                borre = true;
            }
        }
        return borre;
    }
    
    //Ejercicio Multiestructura
    //Eliminar Repetidos
    public void eliminarRepetidos (Cola c){
        Lista<T> aux = new Lista<T>();
        
        while(!c.esVacia()){
            T dato = (T) c.frente().getDato();
            if(aux.estaElemento(dato)){
                c.desencolar();
            }else{
                aux.agregarFinal(dato);
                c.desencolar();
            }
        }
        while (!aux.esVacia()){
            T dato = (T) aux.getInicio().getDato();
            c.encolar(dato);
            aux.eliminarInicio();
        }
        
    }
    
    
    
}
