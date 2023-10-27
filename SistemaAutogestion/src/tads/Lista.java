package tads;


public class Lista <T extends Comparable <T>> implements ILista <T>{
    private Nodo <T> inicio;
    
    
    public Lista (){
      this.inicio = null;
    }
    
    public Lista(Nodo <T> inicio) {
        this.inicio = inicio;
    }
    
    public Nodo getInicio() {
        return inicio;
    }
    
    public void setInicio(Nodo <T> inicio) {
        this.inicio = inicio;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    @Override
    public int cantidadElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarLista() {
        Nodo<T> pActual = this.inicio;
        while(pActual != null){
            System.out.println(pActual.getDato() + " ");
            pActual = pActual.getSiguiente();
        }
    }

    @Override
    public void vaciar() {
        this.inicio = null;
    }

    @Override
    public void agregarInicio(T dato) {
        Nodo nuevo = new Nodo<T> (dato);
        nuevo.setSiguiente(this.inicio);
        this.inicio = nuevo;       
    }

    @Override
    public void agregarFinal(T x) {
        Nodo<T> pActual = this.inicio;
        Nodo<T> nuevo = new Nodo<T>(x);
        if(esVacia()){
            this.inicio = nuevo;
        }else{
            while(pActual.getSiguiente() != null){                
                pActual = pActual.getSiguiente();
            }
            pActual.setSiguiente(nuevo);
        }
        
    }

    @Override
    public void eliminarInicio() {
        if(!esVacia()){
            this.inicio = this.inicio.getSiguiente();    
        }        
    }

    @Override
    public void eliminarFinal() {
        this.inicio.setSiguiente(null);
    }

    @Override
    public boolean estaElemento(T x) {
        Nodo<T> pActual = inicio;
        boolean estaElem = false;
        while(pActual != null && !estaElem){
            if(pActual.getDato().compareTo(x) == 0){
                estaElem = true;
            }else{
                pActual = pActual.getSiguiente();
            }
        }
        return estaElem;
    }
    
    @Override
    public void eliminarElemento(T x){
        if(!esVacia()){
            Nodo <T> actual = inicio;
            
            if(x.compareTo(inicio.getDato()) == 0){ 
                eliminarInicio();
            }else{
               while(actual.getSiguiente() != null && actual.getSiguiente().getDato().compareTo(x) !=0){              
                    actual = actual.getSiguiente();
                }
                if(actual.getSiguiente() != null){
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                }
            }            
        }
    }

    @Override
    public void agregarOrdenado(T x) {        
        if(esVacia()|| x.compareTo(this.inicio.getDato()) < 0) {
            this.agregarInicio(x);
        }else{
            Nodo<T> actual = inicio;
            while(actual.getSiguiente() != null && actual.getSiguiente().getDato().compareTo(x) < 0){
                actual = actual.getSiguiente();
            }
            Nodo<T> nuevoNodo = new Nodo<T>(x);
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);            
        }
    }

    @Override
    public Nodo obtenerElemento(T x) {
        Nodo<T> retorno = null;
        
        if(!esVacia()){
            Nodo<T> actual = inicio;
            while(actual !=null && actual.getDato().compareTo(x) != 0){
                actual = actual.getSiguiente();
            }
            if(actual !=null) retorno = actual;               
           
        }
        return retorno;        
    }
}
