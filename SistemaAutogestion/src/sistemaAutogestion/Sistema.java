package sistemaAutogestion;

import clases.*;
import java.util.Date;
import tads.*;

public class Sistema implements IObligatorio {
    
    private Lista listaMedicos;
    private Lista listaPacientes; 
    private Lista listaConsultaCerrada; //Utilizada para el punto 3.7 para generar el reporte 
    public int cantMaximaPacientexMedico;
    
    /* Retornos posibles
    OK Si pudo inicializar el sistema correctamente.
    ERROR 1. Si cantidad máxima de pacientes es <=0 o > 15
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    @Override
    public Retorno crearSistemaDeAutogestion(int maxPacientesporMedico) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        if(maxPacientesporMedico <= 0 || maxPacientesporMedico > 15){
            r.resultado = Retorno.Resultado.ERROR_1;
        }else{
          cantMaximaPacientexMedico = maxPacientesporMedico;
          listaMedicos = new Lista();
          listaPacientes = new Lista();
          r.resultado= Retorno.Resultado.OK;
        }        
        return r;
    }

    /*Retornos posibles
    OK Si pudo registrar el médico
    ERROR 1. Si ya existe un médico con igual código
    2 En caso de que la especialidad sea < 1 o >20
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    @Override
    public Retorno registrarMedico(String nombre, int codMedico, int tel, int especialidad) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        Medico unMedico = new Medico(nombre, codMedico, tel, especialidad);
        if(listaMedicos.estaElemento(unMedico)){
            r.resultado = Retorno.Resultado.ERROR_1;
        }else if (especialidad < 1 || especialidad > 20){
                r.resultado = Retorno.Resultado.ERROR_2;
            }
            else{
                listaMedicos.agregarOrdenado(unMedico);
                r.resultado = Retorno.Resultado.OK;
            }
        return r;
        
        
    }
    
    @Override
    public Retorno eliminarMedico(int codMedico) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
   
        Medico unMedico = new Medico(codMedico); 
        if(!listaMedicos.estaElemento(unMedico)){
            // En caso de que no exista un medico con ese codigo
            r.resultado = Retorno.Resultado.ERROR_1;
        }else if(!unMedico.getListaAgenda().esVacia()){  //La agenda se crea por día cuando se agenda un paciente         
                    r.resultado = Retorno.Resultado.ERROR_2; 
               }else{
                    listaMedicos.eliminarElemento(unMedico);
                    r.resultado = Retorno.Resultado.OK; 
                }
        return r;
    }    

    /*Retornos posibles
    OK Si se pudo crear el paciente.
    ERROR 1. En caso de que ya exista un paciente con igual CI
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/    
    @Override
    public Retorno agregarPaciente(String nombre, int CI, String direccion) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        
        Paciente unPaciente = new Paciente(nombre, CI, direccion);
        if(listaPacientes.estaElemento(unPaciente)){
            // En caso de que ya exista un paciente con igual CI
            r.resultado = Retorno.Resultado.ERROR_1;
        }else{
            listaPacientes.agregarFinal(unPaciente);
            r.resultado = Retorno.Resultado.OK; 
        }
        return r;
    }
    
    /*Retornos posibles
    OK Si pudo eliminar el paciente.
    ERROR 1.- En caso de que no exista un paciente con esa CI
    2 - En caso de que el paciente haya agendado alguna vez una consulta -- Este punto no va para la primera entrega
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/  
    @Override
    public Retorno eliminarPaciente(int CI) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
   
        Paciente unPaciente = new Paciente(CI);
        if(!listaPacientes.estaElemento(unPaciente)){
            // En caso de que no exista un paciente con esa CI
            r.resultado = Retorno.Resultado.ERROR_1;
        }else if(!unPaciente.getListaConsultas().esVacia()){            
                    r.resultado = Retorno.Resultado.ERROR_2; 
               }else{
                    listaPacientes.eliminarElemento(unPaciente);
                    r.resultado = Retorno.Resultado.OK; 
                }
        return r;
    }
    
    /*Se realiza la reserva de una nueva consulta con un médico. 
    Dicha reserva queda en estado “pendiente” hasta que el paciente anuncie su llegada.
    En ese caso pasará a “en espera” y una vez atendido por el médico pasará a estado “cerrada”.
      Cada reserva tiene un número que se asigna en forma automática comenzando en 1.*/
    @Override
    public Retorno reservaConsulta(int codMedico, int ciPaciente, Date fecha) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno cancelarReserva(int codMedico, int ciPaciente) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno anunciaLlegada(int codMedico, int CIPaciente) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno terminarConsultaMedicoPaciente(int CIPaciente, int codMedico, String detalleDeConsulta) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno cerrarConsulta(String codMédico, Date fechaConsulta) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listarMédicos() {
         Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        listaMedicos.mostrarLista();
        r.resultado = Retorno.Resultado.OK;
        
        return r;
    }

    /*Retornos posibles
    OK Si se muestran todos los médicos
    ERROR No hay errores
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/  
    @Override
    public Retorno listarPacientes() {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
   
        listaPacientes.mostrarLista();
        r.resultado = Retorno.Resultado.OK; 

        return r;
    }

    @Override
    public Retorno listarConsultas(int codMédico) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno listarPacientesEnEspera(String codMédico, Date fecha) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno consultasPendientesPaciente(int CIPaciente) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno historiaClínicaPaciente(int ci) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno reporteDePacientesXFechaYEspecialidad(int mes, int año) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    //sirve para carga la lista agenda de medico, va a tener los días que atiende
    /*Retornos posibles OK Si pudo registrar el día de consulta
    ERROR 1. Si no existe un médico con dicho código
            2 En caso de que ya exista registrada una fecha de consulta para el médico */
    @Override
    public Retorno registrarDiaDeConsulta(int codMedico, Date fecha) {
        Retorno r = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
   
        Medico unMedico = new Medico(codMedico);        
        
        if(listaMedicos.estaElemento(unMedico)){ 
             Nodo nodoMedico = listaMedicos.obtenerElemento(unMedico);
             Medico otroMedico = (Medico) nodoMedico.getDato();
             Agenda unaAgenda = new Agenda(fecha);
            if (otroMedico.getListaAgenda().esVacia()){  
                
                otroMedico.agregarListaAgenda(unaAgenda);            
                r.resultado = Retorno.Resultado.OK;        
            }else if(otroMedico.getListaAgenda().estaElemento(unaAgenda.getFecha())){
                  r.resultado = Retorno.Resultado.ERROR_2;
            }
        }else{
            r.resultado = Retorno.Resultado.ERROR_1;
        } 
        
        return r;
    }

  
}
   

    


