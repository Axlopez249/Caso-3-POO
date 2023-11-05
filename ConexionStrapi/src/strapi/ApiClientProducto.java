package strapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import clasesLogicas.*;

public class ApiClientProducto {

	private static ApiClientProducto instanceProducto = new ApiClientProducto();
	private static String apiUrl;
	
	private ApiClientProducto() {
		apiUrl = "http://localhost:1337/api/productos";
	}
	
	public static ApiClientProducto getInstance() {
		return instanceProducto;
	}
	

	public static String enviarPOST(Producto producto) {
		
		//Aqui se estaria guardando el registro correspondiente en la coleccion de agricultores
		String postData = "{\"data\":{\"nombre\":\"" + producto.getNombre() + "\",\"productor\":\"" + producto.getProductor() + 
				"\",\"abonado\":" + producto.isAbonado() + ",\"caducidad\":\"" + getFecha(producto.getCaducidad()) +
				"\",\"cantidad\":" + producto.getCantidad() + "}}";

        StringBuilder response = new StringBuilder();
        try {
        	
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(postData.getBytes());
            os.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
	
	public Producto getObject(String productor) {
	    Producto producto = null;
	    try {
	        // Construye la URL con el nombre buscado como parámetro de consulta
	        String apiUrl = "http://localhost:1337/api/productos?productor=" + URLEncoder.encode(productor, "UTF-8");
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            response.append(line);
	        }
	        reader.close();

	        connection.disconnect();

	        // Parsea la respuesta JSON utilizando las librerías javax.json
	        try (JsonReader jsonReader = Json.createReader(new java.io.StringReader(response.toString()))) {
	            JsonObject jsonObject = jsonReader.readObject();
	            JsonArray dataArray = jsonObject.getJsonArray("data");

	            // Si hay al menos un objeto en el array 'data'
	            if (dataArray.size() > 0) {
	                JsonObject firstObject = dataArray.getJsonObject(0);
	                JsonObject attributesObject = firstObject.getJsonObject("attributes");
	                
	                
	                // Obtiene los valores de los campos necesarios del objeto JSON
	                boolean abonado = attributesObject.getBoolean("abonado");
	                int cantidad = Integer.parseInt(attributesObject.getString("cantidad"));
	                Date caducidad = new Date(attributesObject.getString("caducidad"));
	                String nombre = attributesObject.getString("nombre");
	                

	                // Crea un nuevo objeto Agricultor con los datos obtenidos
	                producto = new Producto(nombre, abonado, caducidad, cantidad, productor);
	            } else {
	                System.out.println("No se encontraron datos para el productor buscado: " + productor);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return producto;
	}
	
	
	public ArrayList<Pago> getListObject() {
		//Logica para crear el objeto con la informacion
		ArrayList<Pago> listaPagos = new ArrayList<>();
		return listaPagos;
	}
	
	public static String getFecha(Date fecha) {
		
		Date fechaActual = new Date();

        // Define el formato de fecha que deseas
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Convierte la fecha a un String en el formato deseado
        String fechaFormateada = formato.format(fechaActual);

        // Imprime la fecha formateada
        
        return fechaFormateada;
	}
}
