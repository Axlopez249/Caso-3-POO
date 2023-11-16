package strapi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import clasesLogicas.*;
import strapi.*;

public class Main2 {

    public static void main(String[] args) {

        String fechaString = "11/11/2023";
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date fecha = null;
        try {
            // Parsea la fecha en el formato de entrada
            fecha = inputDateFormat.parse(fechaString);
            // Formatea la fecha en el formato esperado por Strapi
            String fechaFormateada = outputDateFormat.format(fecha);
            // Crea un objeto Date a partir de la fecha formateada
            fecha = outputDateFormat.parse(fechaFormateada);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Terreno terreno = new Terreno("Arido", false, true, false, 10.675, "Pedro Morales");
        Producto producto = new Producto("Papa", true, fecha, 12, "Pedro Morales");
        Agricultor agricultor = new Agricultor("Pedro Morales", 1234, 350000.45, 120000.34, terreno, producto);
        Asesor asesor = new Asesor("Axel", "Turrialba", "axelstevenlopezvega04@gmail.com", 23.567, 4, 98, fecha);
        Caso caso = new Caso(1234, agricultor, 94509324, asesor, "Cartago", 934938948, "Academia Josefa", fecha, "Pendiente");

        ApiClientCaso casoStrapi = ApiClientCaso.getInstance();
        casoStrapi.enviarPOST(caso);

    }
}

