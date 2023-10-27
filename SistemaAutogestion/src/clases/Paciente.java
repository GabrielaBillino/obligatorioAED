package clases;

import tads.Lista;

public class Paciente implements Comparable <Paciente>{
    private String nombre;
    private int CI;
    private String direccion;
    private Lista listaConsultas;
    private Lista listaHistoriaClinica;

    public Paciente(String nombre, int CI, String direccion) {
        this.nombre = nombre;
        this.CI = CI;
        this.direccion = direccion;
        listaConsultas = new Lista();
        listaHistoriaClinica = new Lista();  
    }

    public Paciente(int CI) {
        this.CI = CI;
        listaConsultas = new Lista();
        listaHistoriaClinica = new Lista();
    }

    
    public Lista getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(Lista listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public int compareTo(Paciente p) {
        if(this.CI == p.getCI()) return 0;
        else if (this.CI > p.getCI()) return 1; 
        else return -1;
    }
    
    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + getNombre() + ", CI=" + getCI() + ", direccion=" + getDireccion() + '}';
    }
    
}
