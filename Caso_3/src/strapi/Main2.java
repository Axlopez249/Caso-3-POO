package strapi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clasesLogicas.*;
import strapi.*;

public class Main2 {

    public static void main(String[] args) {
    	ArrayList<Terreno> listaTerrenos = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        Date fecha = new Date("11/11/2020");

        Terreno terreno = new Terreno("Arido", false, true, false, 10.675, "werwer");
        Producto producto = new Producto("yuca", true, fecha, 12, "rrrrrr");
        
        
        listaTerrenos.add(terreno);
        listaProductos.add(producto);
        
        Agricultor agricultor = new Agricultor("yyy", 1234, 350000.45, 120000.34, listaTerrenos, listaProductos);
        Asesor asesor = new Asesor("Axel", "Turrialba", "axelstevenlopezvega04@gmail.com", 23.567, 4, 98, fecha);
        Caso caso = new Caso(1234, agricultor, 94509324, asesor, "Cartago", 934938948, "Academia Josefa", fecha, "Pendiente");

        
        //ApiClientAsesor ase = ApiClientAsesor.getInstance();
        //ase.enviarPOST(asesor);
        //ase.getObject("Axel");
        
        ApiClientCaso casoStrapi = ApiClientCaso.getInstance();
        casoStrapi.enviarPOST(caso);
        
        //ApiClientAgricultor agri = ApiClientAgricultor.getInstance();
        //agri.enviarPOST(agricultor);
        
        //ApiClientTerreno terre = ApiClientTerreno.getInstance();
        //terre.enviarPOST(terreno);

        //ApiClientProducto pro = ApiClientProducto.getInstance();
        //pro.enviarPOST(producto);
        //pro.getObjects();
        
    }
}

