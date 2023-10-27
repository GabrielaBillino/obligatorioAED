package clases;

import java.util.Date;



public class Consulta implements Comparable <Consulta>{
    private int codMedico;
    private int ciPaciente;
    private Date fechaConsulta;
    private String descripcion;
    private String estado; //Los estados son: pendiente, enEspera, cerrada, cancelada, noAsistio   
    private int id;
    private static int ultimoId = 0;
    

    public Consulta(int codMedico, int ciPaciente, Date fechaConsulta, String descripcion) {
        this.codMedico = codMedico;
        this.ciPaciente = ciPaciente;
        this.fechaConsulta = fechaConsulta;
        this.descripcion = descripcion;
        this.estado = "pendiente";
        ultimoId++; 
        this.id = ultimoId;       
    }
     
    public int getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    public int getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(int ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Consulta o) {
         if(this.id == o.getId()) return 0;
        else if (this.id > o.getId()) return 1; 
        else return -1;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codMedico=" + codMedico + ", ciPaciente=" + ciPaciente + ", fechaConsulta=" + fechaConsulta + ", descripcion=" + descripcion + ", estado=" + estado + ", id=" + id + '}';
    }
    
    

   
    
    
    

   

   
    
    
}
