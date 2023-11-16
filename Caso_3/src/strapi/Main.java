package strapi;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clasesLogicas.*;
import interfacesGraficas.AgregarAsesorUI;
import interfacesGraficas.AgregarCasoUI;
import interfacesGraficas.AgregarPasoUI;
import interfacesGraficas.AsesorUI;
import interfacesGraficas.CasoUI;
import interfacesGraficas.FurtherInformationUI;
import interfacesGraficas.PlanEconomicoUI;
import interfacesGraficas.RevisarPlanesUI;
import interfacesGraficas.VentanaInicialUI;

public class Main {
	
	public static AgregarCasoUI ACasoUI = new AgregarCasoUI();
	public static AgregarPasoUI APasoUI = new AgregarPasoUI();
	public static RevisarPlanesUI RevisarPlanesUI = new RevisarPlanesUI();
	public static VentanaInicialUI Ventana = new VentanaInicialUI();
	public static AsesorUI AsesorUI = new AsesorUI();
	public static AgregarAsesorUI AAsesorUI = new AgregarAsesorUI(AsesorUI);
	public static CasoUI CasoUI = new CasoUI();
	public static PlanEconomicoUI PlanEconomicoUI = new PlanEconomicoUI();
	public static FurtherInformationUI VerMasUI = new FurtherInformationUI();

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
        
    }
    
    public static void verAsesor(Asesor a) {
    	System.out.println("====================");
        System.out.println("Asesor:");
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Correo: " + a.getCorreo());
        System.out.println("Cantidad de Casos: " + Integer.toString(a.getCantCasos()));
        System.out.println("Rating: " + Double.toString(a.getRating()));
        System.out.println("Años de experiencia: " + Double.toString(a.getExperiencia()));
        System.out.println("Lugar de procedencia: " + a.getLugar());
        System.out.println("Fecha de ingreso: " + a.getFechaIngreso());
        System.out.println("====================");
    }
}
