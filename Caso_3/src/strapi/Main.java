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
		
	o	Agregar caso - agricultor debería ser de selección - se hace match con la zona del asesor y eso lo hacemos por selección -
		productos sembrado es saber que es lo que tiene sembrado, tomar en cuenta que pueden ser N productos, y las cantidades respectivas de cada producto.
		
	o	Ventana que lista los casos, que sea ordenado por fecha y estado
	
*/
	
	private static ArrayList<Asesor> asesoresRegistrados = new ArrayList<>();
	public static ArrayList<PlanEconomico> planesRegistrados = new ArrayList<>();
	public static ArrayList<InfoTemporal> infoTemporalessinasignar = new ArrayList<>();
	public static ArrayList<Caso> casos = new ArrayList<>();
	
	public static SeleccionarAsesorPlan seleccionarAsesor = new SeleccionarAsesorPlan();
	public static RevisarPlanesUI revisarPlanesUI = new RevisarPlanesUI();
	public static VentanaInicialUI Ventana = new VentanaInicialUI();
	public static AsesorUI asesorUI = new AsesorUI();
	public static AgregarAsesorUI agregarAsesorUI = new AgregarAsesorUI();
	public static CasoUI casoUI = new CasoUI();
	public static AgregarCasoUI agregarCasoUI = new AgregarCasoUI(casoUI);
	
	//Secuencia de las interfaces de los planes economicos
	/*
	 * El mae primero arranca con la clase PlanEconomicoUI donde observo los casos no asignados
	 * Luego Ahí mismo puedo crear un plan economico, donde pregunto primero el nombre del asesor y luego se definen los pasos
	 * Cuando se crea un plan economico se guarda en la lista public de los planes economicos
	 * Luego cuando para ver o asginar un plan a un caso, primero de debe de seleccionar una fila de la tabla (cada caso sin asignar)*/
	
	public static AgregarPlanEconomicoUI agregarPlanUI = new AgregarPlanEconomicoUI();
	public static ModificarPlanEconomicoUI modificarPlanUI = new ModificarPlanEconomicoUI();
	public static PlanEconomicoUI planesEconomicosUI = new PlanEconomicoUI(casoUI);
	public static AgregarPasoUI agregarPasoUI = new AgregarPasoUI(agregarPlanUI);
	public static FurtherInformationUI verMasUI = new FurtherInformationUI();
	public static PlanEconomicoDisponible planDisponible = new PlanEconomicoDisponible();

	public static int numeroCaso = 0;
    public static void main(String[] args) {
    	
    	//Lo primero que debo hacer es traer la informaicion de la base de datos
    	//para el asesor se hace lo siguiente
    	ApiClientAsesor asesorStrapi = ApiClientAsesor.getInstance();
    	asesorStrapi.getObject();
    	asesoresRegistrados = asesorStrapi.getAsesores();

    
        Ventana.setVisible(true);
    }
    
    public static ArrayList<Asesor> getAsesores(){
    	return asesoresRegistrados;
    }
    
    public static ArrayList<Caso> getCasos(){
    	return casos;
    }
    
}
