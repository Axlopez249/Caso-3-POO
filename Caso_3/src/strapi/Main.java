package strapi;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clasesLogicas.*;
import interfacesGraficas.*;
public class Main {
	
	/*
	 * Arturo Chavarrïa, Axel Lopez y Tony Solano, 20
	-	Diseño de las pantallas de usuario en java o web según el acuerdo
	
	o	Agregar Asesor - el rating y casos completados debería calcularse con las acciones del sistema
		
	o	Agregar paso - el estado inicial siempre es “planeado” - los que se hacen en el mes 1 pasan a “ejecución” y los del mes 2 en adelante “pending”.
		
	o	Agregar caso - agricultor debería ser de selección - se hace match con la zona del asesor y eso lo hacemos por selección -
		productos sembrado es saber que es lo que tiene sembrado, tomar en cuenta que pueden ser N productos, y las cantidades respectivas de cada producto.
		
	o	Ventana que lista los casos, que sea ordenado por fecha y estado
	
	o	En la ventana de los pasos , aprovechar lo de marcar pero que se pueda escoger el estado y marcarlo, por ejemplo: planeado, 
		pendiente, ejecución, terminado, cancelado, incompleto, no completado.
		
	-	Acceso a datos usando base de datos o headless cms con las operaciones del sistema, -10
	
	o	Están armando un json con concatenación de string
	
	o	Y se parsea también la respuesta con un stringbuilder
	
	o	El que agregaAgricultor no tiene por que retornar string
	
	o	Todos los apiclient solo tienen dos métodos uno para guardar un item y otro para recuperar un item dada una llave, que llega 
		siempre como string aunque no sea string lo que requiere el tipo de dato
		
	o	El prosamiento de json haganlo con json no manipulación,
	 
	o	Hay un static extraño
	
	o	Factorizar el código de los http request en una sola clase que sea usada por los apiclients, el apiclients solo interfaza la lógica hacia los objetos
*/
	
	public static SeleccionarAsesorPlan seleccionarAsesor = new SeleccionarAsesorPlan();
	public static RevisarPlanesUI RevisarPlanesUI = new RevisarPlanesUI();
	public static VentanaInicialUI Ventana = new VentanaInicialUI();
	public static AsesorUI AsesorUI = new AsesorUI();
	public static AgregarAsesorUI AAsesorUI = new AgregarAsesorUI(AsesorUI);
	public static CasoUI CasoUI = new CasoUI();
	public static AgregarCasoUI ACasoUI = new AgregarCasoUI(CasoUI);
	
	//Secuencia de las interfaces de los planes economicos
	/*
	 * El mae primero arranca con la clase PlanEconomicoUI donde observo los casos no asignados
	 * Luego Ahí mismo puedo crear un plan economico, donde pregunto primero el nombre del asesor y luego se definen los pasos
	 * Cuando se crea un plan economico se guarda en la lista public de los planes economicos
	 * Luego cuando para ver o asginar un plan a un caso, primero de debe de seleccionar una fila de la tabla (cada caso sin asignar)*/
	public static AgregarPlanEconomicoUI plan = new AgregarPlanEconomicoUI();
	public static PlanEconomicoUI planesEconomicos = new PlanEconomicoUI(CasoUI);
	public static AgregarPasoUI APasoUI = new AgregarPasoUI(plan);
	public static FurtherInformationUI VerMasUI = new FurtherInformationUI();
	public static PlanEconomicoDisponible planDisponible = new PlanEconomicoDisponible();
	
	public static ArrayList<Asesor> asesoresRegistrados = new ArrayList<>();
	public static ArrayList<PlanEconomico> planesRegistrados = new ArrayList<>();
	public static ArrayList<InfoTemporal> infoTemporalessinasignar = new ArrayList<>();
	public static ArrayList<Caso> casos = new ArrayList<>();

	public static int numeroCaso = 0;
    public static void main(String[] args) {

    	/*Date fecha = new Date("12/10/2023");
        
        Terreno terreno = new Terreno("Arido", false, true, false, 10.675, "Pedro Morales");
        Producto producto = new Producto("Papa", true, fecha, 12, "Pedro Morales");
        Agricultor agricultor = new Agricultor("Pedro Morales", 1234, 350000.45, 120000.34, terreno, producto);
        
        Asesor asesor = new Asesor("Axel", "Turrialba", "axelstevenlopezvega04@gmail.com", 23.567, 4, 98, fecha);
        
        Caso caso = new Caso(1234, agricultor, 94509324, asesor, "Cartago", 934938948, "Academia Josefa", fecha, "Pendiente");

        //ApiClientAgricultor agricultorStrapi = ApiClientAgricultor.getInstance();
        //agricultorStrapi.enviarPOST(agricultor);
        //agricultorStrapi.getObject("Pedro Morales");
        
        ApiClientAsesor asesorStrapi = ApiClientAsesor.getInstance();
        ApiClientAgricultor agricultorStrapi = ApiClientAgricultor.getInstance();
        //asesorStrapi.enviarPOST(asesor);
        //Asesor asesor1 = asesorStrapi.getObject("Axel");
        
        ApiClientCaso casoStrapi = ApiClientCaso.getInstance();
        //casoStrapi.enviarPOST(caso);

        Caso casoResultado = casoStrapi.getObject(1234);
        
        verCaso(casoResultado);
        verAgricultor(casoResultado.getAgricultor());
        verAsesor(casoResultado.getAsesor());*/

        Ventana.setVisible(true);
    }
    
    public static void verCaso(Caso c) {
    	System.out.println("====================");
        System.out.println("Caso:");
        System.out.println("ID: " + Integer.toString(c.getIdCaso()));
        System.out.println("Telefono Agricultor: " + Integer.toString(c.getTelefonoAgricultor()));
        System.out.println("Telefono Asesor: " + Integer.toString(c.getTelefonoAsesor()));
        System.out.println("Estado: " + c.getEstado());
        System.out.println("Organización representante: " + c.getOrganiRepresentante());
        System.out.println("Provincia: " + c.getProvincia());
        System.out.println("Fecha de inicio: " + c.getFechaIngreso());
    }
    /*
    public static void verAgricultor(Agricultor a) {

        System.out.println("====================");
        System.out.println("Agricultor:");
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("ID: " + Integer.toString(a.getId()));
        System.out.println("Deuda: " + Double.toString(a.getDeuda()));
        System.out.println("Dinero: " + Double.toString(a.getDinero()));
        System.out.println("====================");
        System.out.println("Terreno:");
        System.out.println("Tipo: " + a.getTerreno().getTipoSuelo());
        System.out.println("====================");
        System.out.println("Producto: ");
        System.out.println("Nombre: " + a.getProducto().getNombre());
        System.out.println("Caducidad: " + a.getProducto().getCaducidad());
        System.out.println("Cantidad: " + Integer.toString(a.getProducto().getCantidad()));
        
    }*/
    
    public static void verAsesor(Asesor a) {
    	System.out.println("====================");
        System.out.println("Asesor:");
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Correo: " + a.getCorreo());
        System.out.println("Cantidad de Casos: " + Integer.toString(a.getCantidadCasos()));
        System.out.println("Rating: " + Double.toString(a.getRating()));
        System.out.println("Años de experiencia: " + Double.toString(a.getExperiencia()));
        System.out.println("Lugar de procedencia: " + a.getZona());
        System.out.println("Fecha de ingreso: " + a.getFechaIngreso());
        System.out.println("====================");
    }
}
