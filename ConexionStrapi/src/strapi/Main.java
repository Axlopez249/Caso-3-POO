package strapi;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clasesLogicas.*;

public class Main {

    public static void main(String[] args) {

    	Date fecha = new Date("12/10/2023");
        
        Terreno terreno = new Terreno("Arido", false, true, false, 10.675, "Pedro Morales");
        Producto producto = new Producto("Papa", true, fecha, 12, "Pedro Morales");
        Agricultor agricultor = new Agricultor("Pedro Morales", 1234, 350000.45, 120000.34, terreno, producto);
        
        Asesor asesor = new Asesor("Axel", "Turrialba", "axelstevenlopezvega04@gmail.com", 23.567, 4, 98, fecha);
        
        Caso caso = new Caso(1234, agricultor, 94509324, asesor, "Cartago", 934938948, "Academia Josefa", fecha, "Pendiente");

        //ApiClientAgricultor agricultorStrapi = ApiClientAgricultor.getInstance();
        //agricultorStrapi.enviarPOST(agricultor);
        //agricultorStrapi.getObject("Pedro Morales");
        
        ApiClientAsesor asesorStrapi = ApiClientAsesor.getInstance();
        //asesorStrapi.enviarPOST(asesor);
        //Asesor asesor1 = asesorStrapi.getObject("Axel");
        
        ApiClientCaso casoStrapi = ApiClientCaso.getInstance();
        //casoStrapi.enviarPOST(caso);
        casoStrapi.getObject(1234);
        
        
        
        
    }
}
