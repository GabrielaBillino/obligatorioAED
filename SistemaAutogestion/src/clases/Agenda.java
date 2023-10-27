
package clases;

import java.util.Date;
import tads.Cola;
import tads.Lista;

public class Agenda implements Comparable <Agenda>{
    private Lista listaConsultasPendiente; //tiene máximo hasta 15 pacientes
    private Lista listaEsperaPacienteTotem; //Son los pacientes que tienen consulta en el día de hoy y tienen consulta Pendiente
    private Cola listaEsperaPorNro;
    private Date fecha;

    
    public Agenda() {
        listaConsultasPendiente = new Lista();
        listaEsperaPacienteTotem = new Lista(); 
        listaEsperaPorNro = new Cola();
        fecha = new Date ();
    }
    public Agenda(Date fecha) {
        listaConsultasPendiente = new Lista();
        listaEsperaPacienteTotem = new Lista(); 
        listaEsperaPorNro = new Cola();
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    
    public Lista getListaConsultasPendiente() {
        return listaConsultasPendiente;
    }

    public void setListaConsultasPendiente(Lista listaConsultasPendiente) {
        this.listaConsultasPendiente = listaConsultasPendiente;
    }

    public Lista getListaEsperaPacienteTotem() {
        return listaEsperaPacienteTotem;
    }

    public void setListaEsperaPacienteTotem(Lista listaEsperaPacienteTotem) {
        this.listaEsperaPacienteTotem = listaEsperaPacienteTotem;
    }

    public Cola getListaEsperaPorNro() {
        return listaEsperaPorNro;
    }

    public void setListaEsperaPorNro(Cola listaEsperaPorNro) {
        this.listaEsperaPorNro = listaEsperaPorNro;
    }

    @Override
    public int compareTo(Agenda o) {
        return this.fecha.compareTo(o.fecha);
    }
    
    

}
