package sistemaAutogestion;

import java.util.Date;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    /*pre: Crea la estructura necesaria para representar el sistema de Autogestión indicando la
    cantidad maxima de pacientes para el medico por día.
    post: Retorna OK si pudo inicializar el sistema correctament.
    ERROR_1 Si cantidad máxima de pacientes es <=0 o > 15
    NO_IMPLEMENTADA Cuando aún no se implemento Es el tipo de retorno por defecto. */
    public Retorno crearSistemaDeAutogestion(int maxPacientesporMedico);
    
     /*pre: Dar de alta el medico con los datos recibidos por parametro
    post: Retorna OK si pudo registrar el medico correctamente y lo ingresa a la lista de medicos de forma ordenada
    alfabeticamente.
    Retorna ERROR_1 Si ya existe un médico con igual código, ERROR_2 En caso de que la especialidad sea < 1 o >20 y
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno registrarMedico(String nombre,int codMedico,int tel, int especialidad); 
    
    /*pre: Dar de baja el medico por el codMedico recibido por parametro
    post: Retorna OK si pudo eliminar el medico correctamente, para esto verifica que la lista de consultas pendientes
    esté vacía.
    Retorna ERROR_1 En caso de que no exista un médico con ese código, ERROR_2 Si tiene pacientes registrados para su
    consulta, ya sea con número reservado o en sala de espera.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public  Retorno eliminarMedico(int codMedico); 
    
    /*pre: Dar de alta el paciente con los datos recibidos por parametro
       post: Retorna OK si pudo registrar el paciente correctamente y lo ingresa a la lista de pacientes.
       Retorna ERROR_1 Si ya existe un paciente con igual cedula.
       NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno agregarPaciente(String nombre, int CI, String direccion); 
    
    /*pre: Dar de baja el paciente por la cedula recibida por parametro
    post: Retorna OK si pudo eliminar el paciente correctamente, para esto verifica que la lista de consultas 
    esten vacias, la cerradas están en la historia clinica.
    Retorna ERROR_1 En caso de que no exista un paciente con esa cedula,
    ERROR_2 En caso de que el paciente haya agendado alguna vez una consulta
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno eliminarPaciente(int CI); 

     /*
    **************** GESTIÓN DE CONSULTAS **************************************
    */
      
    /*pre: Dar de alta una consulta para el medido,paciente en la fecha recibida por parametro
    post: Retorna OK Se realiza la apertura del consulta correctamente.
    Retorna ERROR_1 En caso de que no exista la ci del paciente
    ERROR_2 En caso de que no exista el codMédico.
    ERROR_3 En caso de que el médico ya tenga una consulta con ese paciente
    ERROR_4 Si en dicha fecha ya existe previamente creado un día de consulta para el médico
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno reservaConsulta(int codMedico, int ciPaciente, Date fecha);
    
    /*pre: El paciente desea cancelar la reserva. Solo se pueden cancelar las reservas que estén en estado “pendiente” .
    post: Retorna OK Si se pudo cancelar la reserva.
    Retorna ERROR_1 En caso de que no exista la ci del paciente
    ERROR_2 En caso de que no exista el codMédico.
    ERROR_3 En caso de que, ese paciente no haya tenido una reserva con ese médico o esté cerrada.
    ERROR_4 En caso de que, la reserva no esté en estado “pendiente”
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno cancelarReserva(int codMedico, int ciPaciente); 
    
    /*pre:El paciente anuncia su llegada en el tótem. Se deberá controlar que en esa fecha (today)
    el paciente tiene consulta.
    post: Se imprime el Nombre del Médico con el cual tiene consulta y el número de reserva. 
    Su consulta pasará a estado “en espera”.
    Retorno OK Si el paciente pudo anunciar su llegada.
    Retorna ERROR_1 En caso de que no exista la ci del paciente.
    ERROR_2 En caso de que no tenga consultas ese día o no tenga reservada una consulta.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno anunciaLlegada(int codMedico, int CIPaciente); 
    
    /*pre: Se cierra la consulta de ese paciente con ese médico. La consulta pasa a estado “terminada” y se agrega
    a la historia clínica.
    post: Retorno OK Si se pudo cerrar correctamente.    
    ERROR_1 En caso de que no exista la ci del paciente.    
    ERROR_2 En caso de que dicho paciente no tenga consulta “en espera” con ese médico en la fecha del día.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno terminarConsultaMedicoPaciente(int CIPaciente, int codMedico, String detalleDeConsulta); 
    
    /*pre: Se modifica el estado a "No Asistió" a las consultas donde no se presentó y formar parte de la lista 
    de la historia clínica.
    post: Retorno OK Si se pudo cerrar la consulta correctamente   
    ERROR_1 En caso de que el codMédico no exista.
    ERROR_2 En caso de que ese médico no tenga consultas el día de la fecha.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno cerrarConsulta(String codMédico, Date fechaConsulta); 
    
    /*Pre: Debe de existir una lista agenda en el médico, previamente inicializada.
    Se registra un nuevo día donde puede atender el médico
    Post: Retorno OK Si pudo registrar el día de consulta
    ERROR_1 Si no existe un médico con dicho código                                              
    ERROR_2 En caso de que ya exista registrada una fecha de consulta para el médico
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/    
    public Retorno registrarDiaDeConsulta (int codMedico, Date fecha);
      /*
    **************** LISTADO Y REPORTES **************************************
    */
    
    /*pre: Lista de medicos está ordenada alfabeticamente y los imprime
    post: Retorno OK y me muestra listado de medicos
    Error: no hay ninguno.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno listarMédicos(); 
    
    /*pre: Imprime lista de pacientes.
    post: Retorno OK y muestra listado de pacientes
    Error: no hay ninguno.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno listarPacientes();  
    
    /*pre: Se muestran todas las consultas asignadas a ese médico agrupadas por día de forma recursiva.
    post: Retorno: OK Si se muestran todas las consultas con sus fechas.
    ERROR_1 si el código de médico no existe
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno listarConsultas(int codMedico); 
    
    /*pre:Imprime todos los pacientes que están anotados en una consulta para ese médico en la fecha indicada
    con estado “en espera”. Los mismo deberán ser mostrados en orden, según su número de reserva.
    post: Retorno: OK Si se muestran los pacientes “en espera” para ese médico en esa fecha.
    RROR_1 si el médico no tiene consulta en esa fecha
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno listarPacientesEnEspera (String codMedico, Date fecha);  
    
    /*pre: Lista todas las consultas pendientes de ese paciente, se realiza de forma recursiva
    post: Retorno: OK Si se listan todas las consultas pendientes del paciente.
    Error_1 En caso de que no exista la ci del paciente
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno consultasPendientesPaciente(int CIPaciente); 
    
    /*pre: Si se listan todas las consultas a las que asistió o no asistió el paciente de forma recursiva
    post: Error_1 si no existe paciente con esa ci
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno historiaClínicaPaciente (int ci);    
    
    /*pre: Se muestra una matriz donde, para cada día del mes (filas) y cada especialidad (columnas),
       se muestran la cantidad de pacientes que fueron atendidos (consultas cerradas) por cada especialidad
    post: Retorno: OK Si se muestra el reporte correctamente.
    Error_1 Mes <=0 y mes >12 o año < 2020 o >2023.
    NO_IMPLEMENTADA Cuando aún no se implementó. Es el tipo de retorno por defecto.*/
    public Retorno reporteDePacientesXFechaYEspecialidad(int mes, int año); 
     
}
    