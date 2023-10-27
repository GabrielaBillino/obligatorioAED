package clases;

import java.util.Date;
import tads.Lista;


public class Medico implements Comparable <Medico>{
    private String nombre;
    private int codMedico;
    private int tel;
    private int especialidad;  
    private Lista listaAgenda;
    
       
    public Medico(String nombre,int codMedico, int tel, int especialidad) {
        this.nombre = nombre;
        this.tel = tel;
        this.especialidad = especialidad;
        this.codMedico = codMedico;
        this.listaAgenda = new Lista();            
    }

    public Medico(int codMedico) {
        this.codMedico = codMedico;
        this.nombre = "";
        this.tel = 0;
        this.especialidad = 0;
        this.listaAgenda = new Lista();       
    }

    public Lista getListaAgenda() {
        return listaAgenda;
    }   
          
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarListaAgenda(Agenda unaAgenda) {
        
        this.listaAgenda.agregarFinal(unaAgenda);
    }

    
    public int getCodMedico() {
        return this.codMedico;
    }

    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }
    
    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public int compareTo(Medico o) {
        int comparacionPorCodMedico = Integer.compare(this.codMedico, o.codMedico);
    
        if (comparacionPorCodMedico == 0) {
            // Si los códigos de médico son iguales, comparamos por nombre
            return 0;
        }else{ 
            if(this.nombre.compareTo(o.getNombre()) == 0){ 
                //En el caso que exista ya el nombre se ordena por le codMedico
                return Integer.compare(this.codMedico, o.codMedico);
            }else{
                  return this.nombre.compareTo(o.getNombre());
            }
          
        }  
        
    }
      
    @Override
    public String toString() {
        return "Medico{" + "nombre=" + nombre + ", tel=" + tel + ", especialidad=" + especialidad + ", codMedico=" + codMedico + '}';
    }
    
    
}
