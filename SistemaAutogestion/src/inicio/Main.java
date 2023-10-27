package inicio;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import tads.*;
import sistemaAutogestion.*;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Prueba unaPrueba = new Prueba();
        Sistema unSistema = new Sistema();
                
        unaPrueba.inicializarResultadosPrueba();
        p1_CreacionSistema(unaPrueba, unSistema);
        
        //Pruebas medico
        p2_registrarMedico (unaPrueba, unSistema);
        p11_listarMedicos (unaPrueba, unSistema);
        
        p3_eliminarMedico (unaPrueba, unSistema);
        p11_listarMedicos (unaPrueba, unSistema);
        
       
        // Pruebas pacientes
        p4_agregarPaciente(unaPrueba, unSistema);
        p12_listarPacientes(unaPrueba, unSistema);
        
        p5_eliminarPaciente(unaPrueba, unSistema);
        p12_listarPacientes(unaPrueba, unSistema);
        
      
        //Segunda entrega del obligatorio
        p6_registrarDiaDeConsulta(unaPrueba, unSistema);
        
        
        
        unaPrueba.imprimirResultadosPrueba();     
        
    }
    
    public static void p1_CreacionSistema(Prueba unaPrueba, Sistema unSistema){
        unaPrueba.ver(unSistema.crearSistemaDeAutogestion(6).resultado, Retorno.Resultado.OK, "Se inicializa el sistema correctamente con cantidad 6");
        unaPrueba.ver(unSistema.crearSistemaDeAutogestion(-1).resultado, Retorno.Resultado.ERROR_1, "No se crea el sistema. Cantidad <= 0");
        unaPrueba.ver(unSistema.crearSistemaDeAutogestion(16).resultado, Retorno.Resultado.ERROR_1, "No se crea el sistema. Cantidad > 15");
    }
    
    public static void p2_registrarMedico (Prueba unaP, Sistema unS){
        unaP.ver(unS.registrarMedico("Gabriela Billino", 6666666, 24093044, 6).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 6666666");
        unaP.ver(unS.registrarMedico("Gabriela Billino", 123, 3243477, 3).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 123");
        unaP.ver(unS.registrarMedico("Toddy Billino", 123, 3243432, 3).resultado, Retorno.Resultado.ERROR_1, "Ya existe un medico con el codigo 123");
        unaP.ver(unS.registrarMedico("Federico Nogues", 1234, 32434324, 23).resultado, Retorno.Resultado.ERROR_2, "La especialidad debe de ser entre 1 y 20");
        unaP.ver(unS.registrarMedico("Federico Garcia", 1233333222, 20800055, 4).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 1233333222");
        unaP.ver(unS.registrarMedico("Federico Nogues", 123222, 22080094, 4).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 123222");
        unaP.ver(unS.registrarMedico("Ana Rodriguez", 165334, 26235056, 5).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el coodigo 165334");
        unaP.ver(unS.registrarMedico("Martina Diaz", 34, 26238085, 7).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 34");
        unaP.ver(unS.registrarMedico("Carlos Perez", 36, 29020000, 8).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 36");
        unaP.ver(unS.registrarMedico("Gabriela Billino", 23, 22099433, 6).resultado, Retorno.Resultado.OK, "Se ingreso el medico con exito, con el codigo 23");
    }
    
    public static void p3_eliminarMedico (Prueba unaP, Sistema unS){
        unaP.ver(unS.eliminarMedico(123).resultado, Retorno.Resultado.OK, "Se elimino el medico con exito con codMedico 123");
        unaP.ver(unS.eliminarMedico(123).resultado, Retorno.Resultado.ERROR_1, "No existe medico con codMedico 123");
        unaP.ver(unS.eliminarMedico(165334).resultado, Retorno.Resultado.OK, "Se elimino el medico con exito con codMedico 165334");
    }
    
    public static void p11_listarMedicos (Prueba unaP, Sistema unS){
        unaP.ver(unS.listarMédicos().resultado, Retorno.Resultado.OK, "Se muestra la lista de medicos correctamente");     
    }
   
    public static void p4_agregarPaciente (Prueba unaP, Sistema unS){
        unaP.ver(unS.agregarPaciente("Virginia Diaz", 23468290, "Capitan Videla 3177").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 23468290"); 
        unaP.ver(unS.agregarPaciente("Virginia Operti", 47168590, "Capitan Videla 3155").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 47168590"); 
        unaP.ver(unS.agregarPaciente("Virginia Operti", 47168108, "Cuareim 2515").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 47168108"); 
        unaP.ver(unS.agregarPaciente("Pedro García", 47168108, "Minas 2345").resultado, Retorno.Resultado.ERROR_1, "Ya existe un paciente con CI 47168108");
        
        unaP.ver(unS.agregarPaciente("Juana Rodriguez", 32233625, "Cuareim 3422").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 32233625"); 
        unaP.ver(unS.agregarPaciente("Ana Gonzalez", 68112548, "Burgues 3212").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 68112548"); 
        unaP.ver(unS.agregarPaciente("Roberto Fernandez", 14567246, "Magallanes 6784").resultado, Retorno.Resultado.OK, "Se agrega correctamente el paciente con CI 14567246"); 
    }
    
    public static void p5_eliminarPaciente (Prueba unaP, Sistema unS){
        unaP.ver(unS.eliminarPaciente(47168108).resultado, Retorno.Resultado.OK, "Se elimina correctamente el paciente de CI 47168108"); 
        unaP.ver(unS.eliminarPaciente(47168108).resultado, Retorno.Resultado.ERROR_1, "No existe paciente con CI 47168108");
        unaP.ver(unS.eliminarPaciente(57944354).resultado, Retorno.Resultado.ERROR_1, "No existe paciente con CI 57944354");
     
    }
    
        
    public static void p12_listarPacientes (Prueba unaP, Sistema unS){
        unaP.ver(unS.listarPacientes().resultado, Retorno.Resultado.OK, "Se muestra la lista de pacientes correctamente");     
    }
    
    
    //Metodos correspondiente a la segunda entrega del obligatorio
    //*******************************************************************************
    
    public static void p6_registrarDiaDeConsulta(Prueba unaP, Sistema unS){
       LocalDate fecha1 = LocalDate.of(2023, 10, 25); // Crear una fecha LocalDate
       LocalDate fecha2 = LocalDate.of(2023, 10, 26); // Crear una fecha LocalDate
        // Convertir LocalDate a Date
        Date fechaDate = Date.from(fecha1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaDate2 = Date.from(fecha2.atStartOfDay(ZoneId.systemDefault()).toInstant());
       
        unaP.ver(unS.registrarDiaDeConsulta(6666666, fechaDate).resultado, Retorno.Resultado.OK, "Se ingreso el dia 01/11/2023 para el medico 6666666");
        unaP.ver(unS.registrarDiaDeConsulta(6666666, fechaDate2).resultado, Retorno.Resultado.ERROR_2, "Ya existe el dia 01/11/2023 para el medico 6666666");
        unaP.ver(unS.registrarDiaDeConsulta(999999999, new Date(2023,11,2)).resultado, Retorno.Resultado.ERROR_1, "No existe un medico con el codigo 999999999");
        unaP.ver(unS.registrarDiaDeConsulta(36, new Date(123,11,3)).resultado, Retorno.Resultado.OK, "Se ingreso el dia 03/11/2023 para el medico 36");
        
    }
    
    public static void p6_reservaConsulta (Prueba unaP, Sistema unS){
        unaP.ver(unS.reservaConsulta(36, 23468290, new Date(023,11,3)).resultado, Retorno.Resultado.OK, "Se registro la coonsulta con exito.");
    }
  
}
